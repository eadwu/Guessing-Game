package EdmundWu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int guesses = 0;

        // TODO: Finish refactoring
        // Properties are to be private
        Game mainframe = new EdmundWu.Game(stdin);

        int max = mainframe.max;
        String name = mainframe.name;
        int number = mainframe.number;
        int gameType = mainframe.gameType;

        int currentGuess = (int) (max / 2f);
        int lastGuess = max;

        while (true) {
            guesses++;
            if (gameType == 0) {
                System.out.printf("Guess a number, %s.\n", name);

                int guess = stdin.nextInt();
                if (guess == number) {
                    System.out.printf("You have chosen the correct number, %s.\n", name);
                    System.out.printf("It took you %d guesses to find the answer.", guesses);
                    break;
                }
            } else {
                if (currentGuess == number) {
                    System.out.printf("The AI has found the correct number, %s.\n", name);
                    System.out.printf("It took it %d guesses to find the number %d.\n", guesses, number);
                    break;
                }

                System.out.printf("The guessed number is %d, is the number higher than the guess (1) or lower than it (2)?\n",
                        currentGuess);
                int highOrLow = stdin.nextInt();

                if (highOrLow < 1 || highOrLow > 2 ||
                        (highOrLow == 1 && currentGuess > number) ||
                        (highOrLow == 2 && currentGuess < number)) {
                    System.out.println("Invalid value for highOrLow, exiting...");
                    System.exit(1);
                }

                float difference = Math.abs(currentGuess - lastGuess) / 2f;
                lastGuess = currentGuess;
                currentGuess = highOrLow == 1
                        ? Math.round(currentGuess + difference)
                        : Math.round(currentGuess - difference);
            }
        }
        stdin.close();
    }
}
