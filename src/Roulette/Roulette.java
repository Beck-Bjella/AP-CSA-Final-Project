package Roulette;

import java.util.Random;
import java.util.Scanner;

public class Roulette {
    private static final int MIN_BET = 1;
    private static final int MAX_BET = 1000;
    private static final int MIN_BALANCE = 100;

    private static final String[] BET_TYPES = {"Number", "Even/Odd", "Red/Black"};
    private static final String[] COLORS = {"Red", "Black"};

    private static final int NUMBER_BET_MULTIPLIER = 36;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to the Roulette Game!");

        while (true) {
            int betAmount = getBetAmount();

            int betType = getBetType();

            if (betType == 0) {
                int chosenNumber = getChosenNumber();
                playNumberBet(betAmount, chosenNumber);
            } else {
                playNonNumberBet(betAmount, betType);
            }
        }

        // System.out.println("Game Over! Thank you for playing.");
    }

    private static int getBetAmount() {
        int betAmount;
        do {
            System.out.print("Place your bet (1 - 1000, 0 to exit): ");
            betAmount = scanner.nextInt();

            if (betAmount == 0) {
                exitGame();
            }

            if (betAmount < MIN_BET || betAmount > MAX_BET) {
                System.out.println("Invalid bet amount. Please bet between 1 and " + MAX_BET);
            }

        } while (betAmount < MIN_BET || betAmount > MAX_BET);

        return betAmount;
    }

    private static void exitGame() {
        System.out.println("Game Over! Thank you for playing.");
        System.exit(0);
    }

    private static int getBetType() {
        System.out.println("Select your bet type:");
        for (int i = 0; i < BET_TYPES.length; i++) {
            System.out.println((i) + ". " + BET_TYPES[i]);
        }

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice < 0 || choice > BET_TYPES.length) {
                System.out.println("Invalid choice. Please choose a number between 1 and " + BET_TYPES.length);
            }

        } while (choice < 0 || choice > BET_TYPES.length);

        return choice;
    }

    private static int getChosenNumber() {
        int chosenNumber;
        do {
            System.out.print("Choose your number (0-36): ");
            chosenNumber = scanner.nextInt();

            if (chosenNumber < 0 || chosenNumber > 36) {
                System.out.println("Invalid number. Please choose a number between 0 and 36.");
            }

        } while (chosenNumber < 0 || chosenNumber > 36);

        return chosenNumber;
    }

    private static void playNumberBet(int betAmount, int chosenNumber) {
        int rouletteNumber = random.nextInt(37);
        System.out.println("The roulette landed on: " + rouletteNumber);

        if (chosenNumber == rouletteNumber) {
            int winnings = betAmount * NUMBER_BET_MULTIPLIER;
            System.out.println("Congratulations! You won " + winnings + " chips!");
        } else {
            System.out.println("Sorry! You lost " + betAmount + " chips.");
        }
    }

    private static void playNonNumberBet(int betAmount, int betType) {
        String chosenColor = (betType == 1) ? getEvenOddChoice() : getRedBlackChoice();
        int rouletteNumber = random.nextInt(37);
        String rouletteColor = getNumberColor(rouletteNumber);
        System.out.println("The roulette landed on: " + rouletteNumber + " (" + rouletteColor + ")");

        if (chosenColor.equalsIgnoreCase(rouletteColor)) {
            System.out.println("Congratulations! You won " + betAmount + " chips!");
        } else {
            System.out.println("Sorry! You lost " + betAmount + " chips");
        }
    }

    private static String getEvenOddChoice() {
        int choice;
        do {
            System.out.print("Choose even (1) or odd (2): ");
            choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 for even or 2 for odd.");
            }

        } while (choice != 1 && choice != 2);

        return (choice == 1) ? "Even" : "Odd";
    }

    private static String getRedBlackChoice() {
        int choice;
        do {
            System.out.print("Choose red (1) or black (2): ");
            choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 for red or 2 for black.");
            }

        } while (choice != 1 && choice != 2);

        return (choice == 1) ? "Red" : "Black";
    }

    private static String getNumberColor(int number) {
        if (number == 0) {
            return "Green";
        } else if ((number % 2 == 0 && number >= 1 && number <= 10) || (number % 2 == 1 && number >= 11 && number <= 18)
                || (number % 2 == 0 && number >= 19 && number <= 28) || (number % 2 == 1 && number >= 29 && number <= 36)) {
            return "Red";
        } else {
            return "Black";
        }
    }
}
