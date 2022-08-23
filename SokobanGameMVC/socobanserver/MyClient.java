import java.io.*;
import java.net.Socket;

public class MyClient extends Thread {

    private final Socket socket;

    public MyClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("socket = " + socket);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             OutputStream outputStream = socket.getOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(outputStream)
        ) {

            String level = in.readLine();
            System.out.println("Client is waiting level : " + level);

            Desktop desktop = new Desktop();

            if (level.equals("7")) {
                desktop.selectSeventhLevel();
            } else if (level.equals("8")) {
                desktop.selectEightLevel();
            } else if (level.equals("9")) {
                desktop.selectNinethLevel();
            }

            out.writeObject(desktop);
            socket.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
