import java.awt.event.*;

public class Controller implements KeyListener, ActionListener {

    private Model model;
    private Levels levels;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
        levels = new Levels();
    }

    public Model getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command) {
            case "Reset":
                model.reset();
                break;
            case "Exit":
                model.exit();
                break;
            case "levelOne":
                model.startLevel(1);
                break;
            case "levelTwo":
                model.startLevel(2);
                break;
            case "levelThree":
                model.startLevel(3);
                break;
            case "levelFour":
                model.startLevel(4);
                break;
            case "levelFive":
                model.startLevel(5);
                break;
            case "levelSix":
                model.startLevel(6);
                break;
            case "levelSeven":
                model.startLevel(7);
                break;
            case "levelEight":
                model.startLevel(8);
                break;
            case "levelNine":
                model.startLevel(9);
                break;
            default:
                return;
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case 32:
                model.reset();
                break;
            case 37:
                model.move("Left");
                break;
            case 38:
                model.move("Up");
                break;
            case 39:
                model.move("Right");
                break;
            case 40:
                model.move("Down");
                break;
            default:
                return;
        }
    }

    @Override
    public void keyTyped(KeyEvent event) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }
}
