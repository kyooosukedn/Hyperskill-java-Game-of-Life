package life;

import java.util.Random;

public class Universe {
    protected Evolution evolution;
    protected Cell[][] currentGeneration;
    protected Cell[][] nextGeneration;
    protected int size;
    private Random random;
    protected int numOfGenerations;

    public Universe(int n, long seed, int numOfGenerations) {
        this.size = n;
        this.currentGeneration = new Cell[n][n];
        this.random = new Random(seed);
        this.numOfGenerations = numOfGenerations;
        this.evolution = new Evolution(this);
        initializeCells();
    }

    public void evolve() {
        for (int i = 0; i < numOfGenerations; i++) {
            nextGeneration = evolution.getNextGeneration();
            currentGeneration = nextGeneration;
            nextGeneration = new Cell[size][size];
        }
    }

    public void initializeCells() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                currentGeneration[i][j] = new Cell(random.nextBoolean(), i, j);
            }
        }

    }

    public void printUniverseState() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (currentGeneration[i][j].isAlive) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public boolean getCell(int x, int y) {
        return x < 0 || x >= size || y < 0 || y >= size ? false : currentGeneration[x][y].alive();
    }

    public Cell[][] getCurrentGeneration() {
        return currentGeneration;
    }

    public Cell[][] getNextGeneration() {
        return nextGeneration;
    }

    public void setEvolution(Evolution evolution) {
        this.evolution = evolution;
    }
}
