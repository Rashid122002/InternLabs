public class Model {

    private Viewer viewer;
    private int[][] desktop;
    private int arrayGoalIndexes[][];
    private int indexX;
    private int indexY;
    private int numberOfMoves;
    private Levels levels;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        levels = new Levels();
        desktop = levels.nextLevel();
        initialization();
    }

    public void startLevel(int level) {
        levels.setLevel(level);
        desktop = levels.nextLevel();
        initialization();
        viewer.update();
    }

    public void initialization() {
        if (isErrorState() == true) {
            int countGoal = 0;
            for (int i = 0; i < desktop.length; i++) {
                for (int j = 0; j < desktop[i].length; j++) {
                    if (desktop[i][j] == 1) {
                        indexX = i;
                        indexY = j;
                    }
                    if (desktop[i][j] == 4) {
                        countGoal = countGoal + 1;
                    }
                }
            }
            arrayGoalIndexes = new int[2][countGoal];
            int temp = 0;
            for (int i = 0; i < desktop.length; i++) {
                for (int j = 0; j < desktop[i].length; j++) {
                    if (desktop[i][j] == 4) {
                        arrayGoalIndexes[0][temp] = i;
                        arrayGoalIndexes[1][temp] = j;
                        temp = temp + 1;
                    }
                }
            }
            numberOfMoves = 0;
        }
    }

    public void reset() {
        startLevel(levels.getLevel());
    }

    public void exit() {
        int n = viewer.exitDialog();
        if (n == 0)
            System.exit(0);
    }

    private void checkGoal() {
        for (int j = 0; j < arrayGoalIndexes[0].length; j++) {
            int x = arrayGoalIndexes[0][j];
            int y = arrayGoalIndexes[1][j];
            if (desktop[x][y] == 0) {
                desktop[x][y] = 4;
            }
        }
    }

    private void won() {
        boolean isWon = true;
        for (int j = 0; j < arrayGoalIndexes[0].length; j++) {
            int x = arrayGoalIndexes[0][j];
            int y = arrayGoalIndexes[1][j];
            if (desktop[x][y] == 4 || desktop[x][y] == 1) {
                isWon = false;
                break;
            }
        }
        if (isWon) {
            int n = viewer.showWonDialog();
            if (n == 0) {
                levels.setLevel(levels.getLevel() + 1);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
            } else reset();
        }
    }

    public void move(String direction) {
        if (direction.equals("Up")) {
            moveUp();
        } else if (direction.equals("Right")) {
            moveRight();
        } else if (direction.equals("Down")) {
            moveDown();
        } else if (direction.equals("Left")) {
            moveLeft();
        } else {
            return;
        }
        checkGoal();
        viewer.update();
        won();
    }

    private void moveUp() {
        if (desktop[indexX - 1][indexY] == 3) {
            if (desktop[indexX - 2][indexY] == 0) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
            if (desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 5;
            }
        }
        if (desktop[indexX - 1][indexY] == 5) {
            if (desktop[indexX - 2][indexY] == 0) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
            if (desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 5;
            }
        }
        if (desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
            numberOfMoves = numberOfMoves + 1;
        }
    }

    private void moveRight() {
        if (desktop[indexX][indexY + 1] == 3) {
            if (desktop[indexX][indexY + 2] == 0) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
            if (desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 5;
            }
        }
        if (desktop[indexX][indexY + 1] == 5) {
            if (desktop[indexX][indexY + 2] == 0) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
            if (desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 5;
            }
        }
        if (desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
            numberOfMoves = numberOfMoves + 1;
        }
    }

    private void moveDown() {
        if (desktop[indexX + 1][indexY] == 3) {
            if (desktop[indexX + 2][indexY] == 0) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
            if (desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 5;
            }
        }
        if (desktop[indexX + 1][indexY] == 5) {
            if (desktop[indexX + 2][indexY] == 0) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
            if (desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 5;
            }
        }
        if (desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
            numberOfMoves = numberOfMoves + 1;
        }
    }

    private void moveLeft() {
        if (desktop[indexX][indexY - 1] == 3) {
            if (desktop[indexX][indexY - 2] == 0) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
            if (desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 5;
            }
        }
        if (desktop[indexX][indexY - 1] == 5) {
            if (desktop[indexX][indexY - 2] == 0) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
            if (desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 5;
            }
        }
        if (desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
            numberOfMoves = numberOfMoves + 1;
        }
    }

    public boolean isErrorState() {
        return (desktop != null && desktop.length == 10 &&
                desktop[0].length == 10 && desktop[1].length == 10 &&
                desktop[2].length == 10 && desktop[3].length == 10 &&
                desktop[4].length == 10 && desktop[5].length == 10 &&
                desktop[6].length == 10 && desktop[7].length == 10 &&
                desktop[8].length == 10 && desktop[9].length == 10);
    }

    public int[][] getDesktop() {
        return desktop;
    }

    public int getLevelFromModel() {
        return levels.getLevel();
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }
}
