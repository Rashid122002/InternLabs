import javax.swing.*;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Viewer {

    private final Model model;
    private final Canvas canvas;
    private final JFrame frame;

    public Viewer() {
        Controller controller = new Controller(this);

        model = controller.getModel();
        canvas = new Canvas(model);

        JMenuBar menuBar = createMenu(controller);
        ImageIcon imageIconLogo = new ImageIcon("images/logo.png");

        frame = new JFrame("Sokoban Game MVC Pattern");
        frame.setIconImage(imageIconLogo.getImage());
        frame.setSize(900, 670);
        frame.setBackground(Color.BLACK);
        frame.setJMenuBar(menuBar);
        frame.add("Center", canvas);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                model.exit();
            }
        });
    }

    public JMenuBar createMenu(Controller controller) {
        JMenuItem resetMenuItem = createMenuItem("Reset", controller, "Reset");
        JMenuItem exitMenuItem = createMenuItem("Exit", controller, "Exit");

        JMenu mainMenu = new JMenu("Main");
        mainMenu.add(resetMenuItem);
        mainMenu.add(exitMenuItem);

        JMenuItem level1 = createMenuItem("Level 1", controller, "levelOne");
        JMenuItem level2 = createMenuItem("Level 2", controller, "levelTwo");
        JMenuItem level3 = createMenuItem("Level 3", controller, "levelThree");
        JMenuItem level4 = createMenuItem("Level 4", controller, "levelFour");
        JMenuItem level5 = createMenuItem("Level 5", controller, "levelFive");
        JMenuItem level6 = createMenuItem("Level 6", controller, "levelSix");
        JMenuItem level7 = createMenuItem("Level 7", controller, "levelSeven");
        JMenuItem level8 = createMenuItem("Level 8", controller, "levelEight");
        JMenuItem level9 = createMenuItem("Level 9", controller, "levelNine");

        JMenu levelsMenu = new JMenu("Levels");
        levelsMenu.add(level1);
        levelsMenu.add(level2);
        levelsMenu.add(level3);
        levelsMenu.add(level4);
        levelsMenu.add(level5);
        levelsMenu.add(level6);
        levelsMenu.add(level7);
        levelsMenu.add(level8);
        levelsMenu.add(level9);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(mainMenu);
        menuBar.add(levelsMenu);
        return menuBar;
    }

    public JMenuItem createMenuItem(String name, Controller controller, String actionCommand) {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(controller);
        menuItem.setActionCommand(actionCommand);
        return menuItem;
    }

    public void update() {
        canvas.repaint();
    }

    public int showWonDialog() {
        return JOptionPane.showConfirmDialog(
                frame,
                "Done!\nMoves: " + model.getNumberOfMoves() +
                        "\nDo you want to start the next level?",
                "Congratulations",
                JOptionPane.YES_NO_OPTION);
    }

    public int exitDialog() {
        return JOptionPane.showConfirmDialog(
                frame,
                "Do you realy want to exit?",
                "Exit dialog",
                JOptionPane.YES_NO_OPTION);
    }
}
