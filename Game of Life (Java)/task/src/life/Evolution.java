package life;

public class Evolution {
    protected Universe universe;

    public Evolution(Universe universe) {
        this.universe = universe;
    }
    public Cell[][] getNextGeneration() {
        Cell[][] cells = new Cell[universe.size][universe.size];
        for (int i = 0; i < universe.size; i++) {
            for (int j = 0; j < universe.size; j++) {
                int livingNeighbors = countLiveNeighbours();
                boolean isAlive = universe.getCell(i,j);
                // A live cell survives if it has two or three neighbors, a dead cell is reborn -> 3 live neighbors
                if (isAlive && (livingNeighbors == 2 || livingNeighbors == 3)) {
                    cells[i][j] = new Cell(true, i, j);
                } else if (!isAlive && livingNeighbors == 3) {
                    // Reborn if dead cell has 3 living neighbors
                    cells[i][j] = new Cell(true, i, j);
                } else {
                    cells[i][j] = new Cell(false, i, j);
                }
            }
        }
        return cells;
    }

    public int countLiveNeighbours() {
        int count = 0;
        for (int i = -1; i < 2;i++) {
            for (int j = -1; j < 2; j++) {
                if (i == j) {
                    continue;
                }

                if (universe.getCell(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

}
