import java.util.Scanner;

import Blackjack.Blackjack;
import Roulette.Roulette;
import Slots.Slots;
import Gui.User;
import Gui.Window;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Window.displayTitle();

        User user = createNewUser(scanner);

        if (user.getAge() < 18) {
            Window.seperator();
            Window.empty();
            Window.text("You are not old enough to play!");
            Window.empty();
            Window.seperator();

            Thread.sleep(3000);

            System.exit(0);

        }
        
        boolean playing = true;
        while (playing) {
            Window.clear();
            Window.displayTitle();
            Window.displayUserStats(user);
            
            int sel = Window.option("Please select a game:", new String[]{"Blackjack", "Roulette", "Slots", "Exit"}, scanner);
            switch (sel) {
                case 1:
                    playBlackjack(user, scanner);
                    break;

                case 2:
                    playRoulette(user, scanner);
                    break;

                case 3:
                    playSlots(user, scanner);
                    break;

                case 4:
                    playing = false;

            }

        }

        scanner.close();

        exit();

    }
    
    public static void playBlackjack(User user, Scanner scanner) throws InterruptedException {
        Window.clear();
        Window.displayBlackjackTitle();
        Window.displayBalance(user);

        int money = user.getBalance();

        Window.seperator();
        Window.empty();
        Window.text("How much would you like to bet?");
        Window.empty();
        Window.seperator();
        Window.none();

        int bet = scanner.nextInt();
        System.out.println();

        if (money - bet < 0) {
            Window.seperator();
            Window.empty();
            Window.text("You don't have enough money to play!");
            Window.empty();
            Window.seperator();
            Window.none();

            return;

        }

        Window.clear();
        Window.displayBlackjackTitle();
        Window.displayBalanceAndBet(user, bet);

        int profit = Blackjack.playBlackjack(bet, scanner);
        user.setBalance(money + profit);
        
        if (profit > 0) {
            user.addGame(true); 

            Window.seperator();
            Window.empty();
            Window.text("You won $" + (profit) + "!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(5000);

        } else {
            user.addGame(false);

            Window.seperator();
            Window.empty();
            Window.text("You lost $" + (-profit) + "!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(5000);

        }

    }

    public static void playRoulette(User user, Scanner scanner) throws InterruptedException {
        Window.clear();
        Window.displayRouletteTitle();
        Window.displayBalance(user);

        int money = user.getBalance();

        Window.seperator();
        Window.empty();
        Window.text("How much would you like to bet?");
        Window.empty();
        Window.seperator();
        Window.none();

        int bet = scanner.nextInt();
        System.out.println();

        if (money - bet < 0) {
            Window.seperator();
            Window.empty();
            Window.text("You don't have enough money to play!");
            Window.empty();
            Window.seperator();
            Window.none();

            return;

        }

        Window.clear();
        Window.displayRouletteTitle();
        Window.displayBalanceAndBet(user, bet);

        int profit = Roulette.playRoulette(bet, scanner);
        user.setBalance(money + profit);

        if (profit > 0) {
            user.addGame(true); 
            
            Window.seperator();
            Window.empty();
            Window.text("You won $" + (profit) + "!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(5000);

        } else {
            user.addGame(false);

            Window.seperator();
            Window.empty();
            Window.text("You lost $" + (-profit) + "!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(5000);

        }

    }

    public static void playSlots(User user, Scanner scanner) throws InterruptedException {
        Window.clear();
        Window.displaySlotsTitle();
        Window.displayBalance(user);

        int money = user.getBalance();

        Window.seperator();
        Window.empty();
        Window.text("How much would you like to bet?");
        Window.empty();
        Window.seperator();
        Window.none();

        int bet = scanner.nextInt();
        System.out.println();

        if (money - bet < 0) {
            Window.seperator();
            Window.empty();
            Window.text("You don't have enough money to play!");
            Window.empty();
            Window.seperator();
            Window.none();

            return;

        }

        int profit = new Slots().playSlots(bet, user, scanner);
        user.setBalance(money + profit);

        if (profit > 0) {
            user.addGame(true); 

            Window.seperator();
            Window.empty();
            Window.text("You won $" + (profit) + "!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(5000);

        } else {
            user.addGame(false);

            Window.seperator();
            Window.empty();
            Window.text("You lost $" + (-profit) + "!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(5000);

        }

    }

    public static User createNewUser(Scanner scanner) {
        Window.seperator();
        Window.empty();
        Window.text("Welcome to the casino!");
        Window.empty();
        Window.text("Please enter your name: ");
        Window.empty();
        Window.seperator();
        Window.none();

        String name = scanner.nextLine();
        System.out.println();

        Window.seperator();
        Window.empty();
        Window.text("Please enter your age: ");
        Window.empty();
        Window.seperator();
        Window.none();

        int age = scanner.nextInt();
        System.out.println();

        User user = new User(name, age, 10000);

        return user;

    }

    public static void exit() throws InterruptedException {
        Window.none();
        Window.seperator();
        Window.empty();
        Window.text("Thank you for playing!");
        Window.empty();
        Window.seperator();

        Thread.sleep(3000);

        System.exit(0);

    }

}
