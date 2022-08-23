import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Canvas extends JPanel {

    private final Model model;
    private Image imageLogo;
    private Image imagePlayer;
    private Image imageWall;
    private Image imageBox;
    private Image imageGoal;
    private Image imageBoxOnGoal;
    private Image imageFloor;
    private Image imageError;

    public Canvas(Model model) {
        this.model = model;
        setBackground(Color.BLACK);
        setOpaque(true);
        File fileNameImageLogo = new File("images/just.png");
        File fileNameImagePlayer = new File("images/player.png");
        File fileNameImageWall = new File("images/wall.png");
        File fileNameImageBox = new File("images/box.png");
        File fileNameImageGoal = new File("images/goal.png");
        File fileNameImageBoxOnGoal = new File("images/box1.png");
        File fileNameImageFloor = new File("images/floor.png");
        URL url = this.getClass().getResource("images/error.gif");
        try {
            imageLogo = ImageIO.read(fileNameImageLogo);
            imagePlayer = ImageIO.read(fileNameImagePlayer);
            imageWall = ImageIO.read(fileNameImageWall);
            imageBox = ImageIO.read(fileNameImageBox);
            imageGoal = ImageIO.read(fileNameImageGoal);
            imageBoxOnGoal = ImageIO.read(fileNameImageBoxOnGoal);
            imageFloor = ImageIO.read(fileNameImageFloor);
            imageError = new ImageIcon(url).getImage();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (model.isErrorState() == false) {
            drawError(g);
            return;
        }
        drawDesktop(g);

        g.setColor(new Color(23, 32, 42));
        g.fillRect(0, 0, 300, 700);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.ITALIC, 50));
        g.drawString("Sokoban", 30, 70);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Level: " + model.getLevelFromModel() + "/9", 50, 150);

        g.drawImage(imageLogo, 30, 200, this);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Moves: " + model.getNumberOfMoves(), 50, 500);
    }

    public void drawDesktop(Graphics g) {
        int[][] desktop = model.getDesktop();
        int x = 350;
        int y = 50;
        int width = 50;
        int height = 50;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 0) {
                    g.drawImage(imageFloor, x, y, null);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, width, height);
                } else if (desktop[i][j] == 1) {
                    g.drawImage(imagePlayer, x, y, null);
                } else if (desktop[i][j] == 2) {
                    g.drawImage(imageWall, x, y, null);
                } else if (desktop[i][j] == 3) {
                    g.drawImage(imageBox, x, y, null);
                } else if (desktop[i][j] == 4) {
                    g.drawImage(imageGoal, x, y, null);
                } else if (desktop[i][j] == 5) {
                    g.drawImage(imageBoxOnGoal, x, y, null);
                } else {
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, width, height);
                }
                x = x + width;
            }
            x = 350;
            y = y + height;
        }
    }

    public void drawError(Graphics g) {
        setBackground(Color.BLACK);
        g.drawImage(imageError, 130, 50, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Level has an incorrect structure!", 210, 350);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("You can play other levels!", 310, 450);
    }
}
