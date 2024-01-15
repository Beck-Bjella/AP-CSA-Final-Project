import java.util.Scanner;

import Blackjack.Blackjack;
import Roulette.Roulette;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        displayTitle();

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
            displayTitle();
            displayUserStats(user);
            
            int sel = Window.option("Please select a game:", new String[]{"Blackjack", "Roulette", "Slots", "Exit"}, scanner);
            switch (sel) {
                case 1:
                    playBlackjack(user, scanner);
                    break;

                case 2:
                    playRoulette(user, scanner);
                    break;

                case 3:
                    System.out.println("Slots");
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
        displayBlackjackTitle();
        displayUserStats(user);

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

        int profit = Blackjack.playBlackjack(bet, scanner);
        user.setBalance(money + profit);
        
        if (profit > 0) {
            user.addGame(true); 

            Window.seperator();
            Window.empty();
            Window.text("You won " + (profit) + "$!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(3000);

        } else {
            user.addGame(false);

            Window.none();
            Window.seperator();
            Window.empty();
            Window.text("You lost " + (-profit) + "$!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(3000);

        }

    }

    public static void playRoulette(User user, Scanner scanner) throws InterruptedException {
        Window.clear();
        displayRouletteTitle();
        displayUserStats(user);

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

        int profit = Roulette.playRoulette(bet, scanner);
        user.setBalance(money + profit);

        if (profit > 0) {
            user.addGame(true); 

            Window.seperator();
            Window.empty();
            Window.text("You won " + (profit) + "$!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(3000);

        } else {
            user.addGame(false);

            Window.seperator();
            Window.empty();
            Window.text("You lost " + (-profit) + "$!");
            Window.empty();
            Window.seperator();
            Window.none();

            Thread.sleep(3000);

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

    public static void displayUserStats(User user) {
        int[] stats = user.getGameStats();

        Window.seperator();
        Window.empty();
        Window.text("USER: " + user.getName());
        Window.text("AGE: " + user.getAge());
        Window.empty();
        Window.text("BALANCE: " + user.getBalance() + "$");
        Window.empty();
        Window.text("GAMES PLAYED: " + stats[0]);
        Window.text("GAMES WON: " + stats[1]);
        Window.text("GAMES LOST: " + stats[2]);
        Window.empty();
        Window.seperator();
        Window.none();

    }

    public static void displayTitle() {
        Window.seperator();
        Window.empty();
        Window.text(" $$$$$$\\  $$\\       $$$$$$\\        $$$$$$\\   $$$$$$\\   $$$$$$\\  $$$$$$\\ $$\\   $$\\  $$$$$$\\");
        Window.text("$$  __$$\\ $$ |      \\_$$  _|      $$  __$$\\ $$  __$$\\ $$  __$$\\ \\_$$  _|$$$\\  $$ |$$  __$$\\");
        Window.text("$$ /  \\__|$$ |        $$ |        $$ /  \\__|$$ /  $$ |$$ /  \\__|  $$ |  $$$$\\ $$ |$$ /  $$ |");
        Window.text("$$ |      $$ |        $$ |        $$ |      $$$$$$$$ |\\$$$$$$\\    $$ |  $$ $$\\$$ |$$ |  $$ |");
        Window.text("$$ |      $$ |        $$ |        $$ |      $$  __$$ | \\____$$\\   $$ |  $$ \\$$$$ |$$ |  $$ |");
        Window.text("$$ |  $$\\ $$ |        $$ |        $$ |  $$\\ $$ |  $$ |$$\\   $$ |  $$ |  $$ |\\$$$ |$$ |  $$ |");
        Window.text("\\$$$$$$  |$$$$$$$$\\ $$$$$$\\       \\$$$$$$  |$$ |  $$ |\\$$$$$$  |$$$$$$\\ $$ | \\$$ | $$$$$$  |");
        Window.text(" \\______/ \\________|\\______|       \\______/ \\__|  \\__| \\______/ \\______|\\__|  \\__| \\______/");
        Window.empty();
        Window.seperator();
        Window.none();

    }

    public static void displayBlackjackTitle() {
        Window.seperator();
        Window.empty();
        Window.text("$$$$$$$\\  $$\\        $$$$$$\\   $$$$$$\\  $$\\   $$\\   $$$$$\\  $$$$$$\\   $$$$$$\\  $$\\   $$\\");
        Window.text("$$  __$$\\ $$ |      $$  __$$\\ $$  __$$\\ $$ | $$  |  \\__$$ |$$  __$$\\ $$  __$$\\ $$ | $$  |");
        Window.text("$$ |  $$ |$$ |      $$ /  $$ |$$ /  \\__|$$ |$$  /      $$ |$$ /  $$ |$$ /  \\__|$$ |$$  /");
        Window.text("$$$$$$$\\ |$$ |      $$$$$$$$ |$$ |      $$$$$  /       $$ |$$$$$$$$ |$$ |      $$$$$  /");
        Window.text("$$  __$$\\ $$ |      $$  __$$ |$$ |      $$  $$<  $$\\   $$ |$$  __$$ |$$ |      $$  $$<");
        Window.text("$$ |  $$ |$$ |      $$ |  $$ |$$ |  $$\\ $$ |\\$$\\ $$ |  $$ |$$ |  $$ |$$ |  $$\\ $$ |\\$$\\");
        Window.text("$$$$$$$  |$$$$$$$$\\ $$ |  $$ |\\$$$$$$  |$$ | \\$$\\\\$$$$$$  |$$ |  $$ |\\$$$$$$  |$$ | \\$$\\");
        Window.text("\\_______/ \\________|\\__|  \\__| \\______/ \\__|  \\__|\\______/ \\__|  \\__| \\______/ \\__|  \\__");
        Window.empty();
        Window.seperator();
        Window.none();

    }

    public static void displayRouletteTitle() {
        Window.seperator();
        Window.empty();
        Window.text("$$$$$$$\\   $$$$$$\\  $$\\   $$\\ $$\\       $$$$$$$$\\ $$$$$$$$\\ $$$$$$$$\\ $$$$$$$$\\");
        Window.text("$$  __$$\\ $$  __$$\\ $$ |  $$ |$$ |      $$  _____|\\__$$  __|\\__$$  __|$$  _____|");
        Window.text("$$ |  $$ |$$ /  $$ |$$ |  $$ |$$ |      $$ |         $$ |      $$ |   $$ |");
        Window.text("$$$$$$$  |$$ |  $$ |$$ |  $$ |$$ |      $$$$$\\       $$ |      $$ |   $$$$$\\");
        Window.text("$$  __$$< $$ |  $$ |$$ |  $$ |$$ |      $$  __|      $$ |      $$ |   $$  __|");
        Window.text("$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |      $$ |         $$ |      $$ |   $$ |");
        Window.text("$$ |  $$ | $$$$$$  |\\$$$$$$  |$$$$$$$$\\ $$$$$$$$\\    $$ |      $$ |   $$$$$$$$\\");
        Window.text("\\__|  \\__| \\______/  \\______/ \\________|\\________|   \\__|      \\__|   \\________|");
        Window.empty();
        Window.seperator();
        Window.none();

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
