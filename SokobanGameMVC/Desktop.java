public class Desktop implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private int[][] desktop;

    public Desktop(int[][] desktop) {
        this.desktop = desktop;
    }

    public int[][] getDesktop() {
        return desktop;
    }
}
