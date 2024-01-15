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
            
            if (sel == 1 || sel == 2 || sel == 3) {
                playGame(sel - 1, user, scanner);

            } else if (sel == 4) {
                exit();
                
            } else {
                Window.seperator();
                Window.empty();
                Window.text("Invalid input!");
                Window.empty();
                Window.seperator();
                Window.none();

                Thread.sleep(1000);

            }

        }

        scanner.close();

        exit();

    }

    // Plays a specific game (0 = Blackjack, 1 = Roulette, 2 = Slots)
    public static void playGame(int game, User user, Scanner scanner) throws InterruptedException {
        Window.clear();
        switch (game) {
            case 0:
                Window.displayBlackjackTitle();
                break;

            case 1:
                Window.displayRouletteTitle();
                break;

            case 2:
                Window.displaySlotsTitle();
                break;

            default:
                break;
        }
        Window.displayBalance(user);

        Window.seperator();
        Window.empty();
        Window.text("How much would you like to bet?");
        Window.empty();
        Window.seperator();
        Window.none();

        int money = user.getBalance();
        int bet = scanner.nextInt();
        System.out.println();
        

        if (bet < 0) {
            Window.seperator();
            Window.empty();
            Window.text("You can't bet negative money!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(1000);
            return;

        }

        if (money - bet < 0) {
            Window.seperator();
            Window.empty();
            Window.text("You don't have enough money to play!");
            Window.empty();
            Window.seperator();
            Window.none();
            return;

        }

        int profit = 0;
        switch (game) {
            case 0:
                Window.clear();
                Window.displayBlackjackTitle();
                Window.displayBalanceAndBet(user, bet);
                
                profit = Blackjack.playBlackjack(bet, scanner);
                break;

            case 1:
                Window.clear();
                Window.displayRouletteTitle();
                Window.displayBalanceAndBet(user, bet);
        
                profit = Roulette.playRoulette(bet, scanner);
                break;

            case 2:
                Window.clear();
                Window.displaySlotsTitle();
                Window.displayBalanceAndBet(user, bet);

                profit = new Slots().playSlots(bet, user, scanner);
                break;
        
            default:
                break;

        }
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

    // Creates a new user at the start of the program
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

    // Exits the program
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
