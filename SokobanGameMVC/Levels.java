import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Levels {

    private int level;
    private LevelReaderFromFile levelReaderFromFile;
    private boolean flag;

    public Levels() {
        level = 1;
        levelReaderFromFile = new LevelReaderFromFile();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int[][] nextLevel() {
        int[][] desktop = null;
        switch (level) {
            case 1:
                desktop = getFirstLevel();
                break;
            case 2:
                desktop = getSecondLevel();
                break;
            case 3:
                desktop = getThirdLevel();
                break;
            case 4:
                try {
                    desktop = levelReaderFromFile.getLevelFromFile("levelsFromFile/level4.sok");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;
                break;
            case 5:
                try {
                    desktop = levelReaderFromFile.getLevelFromFile("levelsFromFile/level5.sok");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;
                break;
            case 6:
                try {
                    desktop = levelReaderFromFile.getLevelFromFile("levelsFromFile/level6.sok");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;
                break;
            case 7:
                desktop = getLevelFromServer("7");
                break;
            case 8:
                desktop = getLevelFromServer("8");
                break;
            case 9:
                desktop = getLevelFromServer("9");
                break;
            default:
                level = 1;
                desktop = getFirstLevel();
        }
        return desktop;
    }

    public int[][] getFirstLevel() {
        int[][] levelFirst = new int[][]{
                {6, 6, 6, 2, 2, 2, 2, 2, 6, 6},
                {6, 2, 2, 2, 0, 0, 0, 2, 6, 6},
                {6, 2, 0, 3, 0, 2, 0, 2, 2, 6},
                {6, 2, 0, 2, 0, 0, 4, 0, 2, 6},
                {6, 2, 0, 0, 0, 0, 2, 0, 2, 6},
                {6, 2, 2, 0, 2, 0, 0, 0, 2, 6},
                {6, 6, 2, 1, 0, 0, 2, 2, 2, 6},
                {6, 6, 2, 2, 2, 2, 2, 6, 6, 6},
                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6}
        };
        return levelFirst;
    }

    public int[][] getSecondLevel() {
        int[][] levelSecond = new int[][]{
                {6, 2, 2, 2, 2, 2, 6, 6, 6, 6},
                {6, 2, 0, 0, 0, 2, 2, 2, 2, 6},
                {6, 2, 0, 0, 0, 2, 0, 0, 2, 6},
                {6, 2, 2, 0, 0, 0, 0, 4, 2, 6},
                {2, 2, 2, 0, 2, 2, 2, 4, 2, 6},
                {2, 0, 3, 0, 2, 6, 2, 4, 2, 6},
                {2, 0, 3, 3, 2, 6, 2, 2, 2, 6},
                {2, 1, 0, 0, 2, 6, 6, 6, 6, 6},
                {2, 2, 2, 2, 2, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6}
        };
        return levelSecond;
    }

    public int[][] getThirdLevel() {
        int[][] levelThird = new int[][]{
                {6, 2, 2, 2, 2, 2, 2, 2, 2, 6},
                {6, 2, 0, 0, 0, 2, 0, 0, 2, 6},
                {6, 2, 0, 2, 0, 2, 3, 4, 2, 6},
                {6, 2, 0, 0, 0, 0, 3, 4, 2, 6},
                {6, 2, 0, 2, 0, 2, 3, 4, 2, 6},
                {6, 2, 0, 0, 0, 2, 0, 0, 2, 6},
                {6, 2, 2, 2, 2, 2, 1, 0, 2, 6},
                {6, 6, 6, 6, 6, 2, 2, 2, 2, 6},
                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6}
        };
        return levelThird;
    }

    public int[][] getLevelFromServer(String level) {
        //194.152.37.7  //localhost
        try (Socket socket = new Socket("localhost", 4446);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            out.println(level);

            Desktop serverDesktop = (Desktop) in.readObject();
            int[][] desktop = serverDesktop.getDesktop();

            return desktop;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return null;
    }
}
