package CODESOFT1;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalScore = 0;
        int roundsWon = 0;

        while (playAgain) {
            int targetNumber = generateRandomNumber(1, 100);
            boolean guessedCorrectly = false;
            int attempts = 0;

            System.out.println("Guess the number between 1 and 100!");

            while (!guessedCorrectly && attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    totalScore += (MAX_ATTEMPTS - attempts + 1); // Higher score for fewer attempts
                    roundsWon++;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

            if (!playAgain) {
                System.out.println("Your Total score:" + totalScore);
                System.out.println("Rounds won: " + roundsWon);
                System.out.println("Thank you for playing!");
            }
        }

        scanner.close();
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
