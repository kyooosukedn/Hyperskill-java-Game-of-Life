package life;

public class Cell {
    int x;
    int y;
    protected boolean isAlive;


    public Cell(boolean isAlive, int x, int y) {
        this.isAlive = isAlive;
        this.x = x;
        this.y = y;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean alive() {
        return isAlive;
    }


}
