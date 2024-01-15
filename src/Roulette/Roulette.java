package Roulette;

import java.util.Random;
import java.util.Scanner;

public class Roulette {
    private static final String[] BET_TYPES = {"Number", "Even/Odd", "Red/Black"};
    private static final int NUMBER_BET_MULTIPLIER = 36;

    private static Random random = new Random();

    public static int playRoulette(int betAmount, Scanner scanner) throws InterruptedException {
        int betType = 4;

        betType = getBetType(scanner);

        boolean win = false;
        int winAmount = 0;
        switch (betType) {
            case 0:
                win = playNumberBet(betAmount, scanner);
                if (win) {
                    winAmount = betAmount * NUMBER_BET_MULTIPLIER;
                }

                break;

            case 1:
                win = playEvenOddBet(betAmount, scanner);
                if (win) {
                    winAmount = betAmount;
                }

                break;

            case 2:
                win = playRedBlackBet(betAmount, scanner);
                if (win) {
                    winAmount = betAmount;
                }

                break;

            default:
                System.out.println("Invalid bet type.");
                System.out.println();
                break;

        }

        if (win) {
            return winAmount;

        } else {
            return -betAmount;

        }

    }

    private static int getBetType(Scanner scanner) {
        System.out.println("Select your bet type:");
        for (int i = 0; i < BET_TYPES.length; i++) {
            System.out.println((i) + ". " + BET_TYPES[i]);
        }

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println();

            if (choice < 0 || choice > 2) {
                System.out.println("Invalid choice. Please choose a number between 0 and 3.");
                System.out.println();
            }

        } while (choice < 0 || choice > 2);

        return choice;
    }

    private static int getChosenNumber(Scanner scanner) {
        int chosenNumber;
        do {
            System.out.print("Choose your number (0-36): ");
            chosenNumber = scanner.nextInt();
            System.out.println();

            if (chosenNumber < 0 || chosenNumber > 36) {
                System.out.println("Invalid number. Please choose a number between 0 and 36.");
                System.out.println();
            }

        } while (chosenNumber < 0 || chosenNumber > 36);
        

        return chosenNumber;
    }

    private static boolean playNumberBet(int betAmount, Scanner scanner) {
        int chosenNumber = getChosenNumber(scanner);

        int rouletteNumber = random.nextInt(37);
        System.out.println("The roulette landed on: " + rouletteNumber);
        System.out.println();

        return chosenNumber == rouletteNumber;
        
    }

    private static boolean playEvenOddBet(int betAmount, Scanner scanner) {
        String chosenType = getEvenOddChoice(scanner);
        int rouletteNumber = random.nextInt(37);

        System.out.println("The roulette landed on: " + rouletteNumber);
        System.out.println();

        if (chosenType.equalsIgnoreCase("Even") && rouletteNumber % 2 == 0) {
            return true;

        } else if (chosenType.equalsIgnoreCase("Odd") && rouletteNumber % 2 == 1) {
            return true;

        } else {
            return false;
            
        }

    }

    private static boolean playRedBlackBet(int betAmount, Scanner scanner) {
        String chosenColor = getRedBlackChoice(scanner);

        int rouletteNumber = random.nextInt(37);
        String rouletteColor = getNumberColor(rouletteNumber);

        System.out.println("The roulette landed on: " + rouletteNumber + " (" + rouletteColor + ")");
        System.out.println();

        return chosenColor.equalsIgnoreCase(rouletteColor);

    }

    private static String getEvenOddChoice(Scanner scanner) {
        int choice;
        do {
            System.out.print("Choose even (1) or odd (2): ");
            choice = scanner.nextInt();
            System.out.println();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 for even or 2 for odd.");
                System.out.println();
            }

        } while (choice != 1 && choice != 2);

        return (choice == 1) ? "Even" : "Odd";
    }

    private static String getRedBlackChoice(Scanner scanner) {
        int choice;
        do {
            System.out.print("Choose red (1) or black (2): ");
            choice = scanner.nextInt();
            System.out.println();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 for red or 2 for black.");
                System.out.println();
            }

        } while (choice != 1 && choice != 2);

        return (choice == 1) ? "Red" : "Black";
    }

    private static String getNumberColor(int number) {
        if (number == 0) {
            return "Green";
        } else if ((number % 2 == 0 && number >= 1 && number <= 10) || (number % 2 == 1 && number >= 11 && number <= 18) || (number % 2 == 0 && number >= 19 && number <= 28) || (number % 2 == 1 && number >= 29 && number <= 36)) {
            return "Red";
        } else {
            return "Black";
        }
        
    }

}
