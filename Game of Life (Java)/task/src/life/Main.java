package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long seed = scanner.nextLong();
        int generations = scanner.nextInt();
        if (generations >= 0) {
            Universe universe = new Universe(n, seed, generations);
            universe.evolve();
            universe.printUniverseState();
        } else {
            System.out.println("Generations cannot be negative");
        }

    }


}
