package EdmundWu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    String name;
    int gameType;
    int max;
    int number;

    private void fetchName (Scanner stdin) {
        System.out.println("What is your name?");
        this.name = stdin.nextLine();
        System.out.printf("Hello there, %s.\n", this.name);
    }

    private void fetchGameType (Scanner stdin) {
        System.out.println("What type of game do you want to play, 0 - Player guesses, 1 - Computer guesses?");
        int gameType = 0;

        try {
            gameType = stdin.nextInt();

            if (gameType < 0 || gameType > 1)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value for gameType, exiting...");
            System.exit(1);
        }
        this.gameType = gameType;
    }

    private void fetchDifficulty (Scanner stdin) {
        System.out.println("What difficulty do you want to choose, 1-4, transforms range from [1, 10^n].");
        int difficulty = 0;

        try {
            difficulty = stdin.nextInt();

            if (difficulty < 1 || difficulty > 4)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value for difficulty, exiting...");
            System.exit(1);
        }
        this.max = (int) Math.pow(10, difficulty);
    }

    private void getNumber (Scanner stdin) {
        if (gameType == 1)
            System.out.printf("Choose a number from [1, %d].\n", (int) max);
        int number = 0;

        try {
            number = gameType == 1 ? stdin.nextInt() : (int) (Math.random() * max + 1f);

            if (number < 1 || number > max)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value for max, exiting...");
            System.exit(1);
        }
        this.number = number;
    }

    public Game (Scanner stdin) {
        this.fetchName(stdin);
        this.fetchGameType(stdin);
        this.fetchDifficulty(stdin);
        this.getNumber(stdin);
    }
}
