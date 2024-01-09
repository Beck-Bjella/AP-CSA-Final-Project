import java.util.Scanner;

import Blackjack.Blackjack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        displayTitle();

        User user = createNewUser(scanner);

        if (user.getAge() < 18) {
            Window.none();
            Window.seperator();
            Window.empty();
            Window.text("You are not old enough to play!");
            Window.empty();
            Window.seperator();
            
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
                    System.out.println("Roulette");
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
        int money = user.getBalance();

        Window.none();
        Window.seperator();
        Window.empty();
        Window.text("How much would you like to bet?");
        Window.empty();
        Window.seperator();

        System.out.println();

        int bet = scanner.nextInt();

        if (money - bet < 0) {
            Window.none();
            Window.seperator();
            Window.empty();
            Window.text("You don't have enough money to play!");
            Window.empty();
            Window.seperator();

            return;

        }

        int[] result = Blackjack.playBlackjack(money, scanner);

        if (result[0] == 2) {
            money += bet * 2;

            user.addGame(true); 

            Window.none();
            Window.seperator();
            Window.empty();
            Window.text("You won " + (bet * 2) + "$!");
            Window.empty();
            Window.seperator();

            Thread.sleep(3000);

        } else {
            money -= bet;

            user.addGame(false);

            Window.none();
            Window.seperator();
            Window.empty();
            Window.text("You lost " + (bet) + "$!");
            Window.empty();
            Window.seperator();

            Thread.sleep(3000);

        }

        user.setBalance(money);
        
    }

    public static void exit() throws InterruptedException {
        Window.none();
        Window.seperator();
        Window.empty();
        Window.text("Thank you for playing!");
        Window.empty();
        Window.seperator();

        Thread.sleep(2000);

        System.exit(0);

    }

    public static User createNewUser(Scanner scanner) {
        Window.none();
        Window.seperator();
        Window.empty();
        Window.text("Welcome to the casino!");
        Window.empty();
        Window.text("Please enter your name: ");
        Window.empty();
        Window.seperator();

        System.out.println();
        String name = scanner.nextLine();
        System.out.println();

        Window.seperator();
        Window.empty();
        Window.text("Please enter your age: ");
        Window.empty();
        Window.seperator();

        System.out.println();
        int age = scanner.nextInt();

        User user = new User(name, age, 10000);

        return user;

    }

    public static void displayTitle() {
        Window.seperator();
        Window.empty();
        Window.text(" $$$$$$\\  $$\\       $$$$$$\\\\        $$$$$$\\   $$$$$$\\   $$$$$$\\  $$$$$$\\ $$\\   $$\\  $$$$$$\\");
        Window.text("$$  __$$\\ $$ |      \\_$$  _|      $$  __$$\\ $$  __$$\\\\ $$  __$$\\ \\_$$  _|$$$\\  $$ |$$  __$$\\");
        Window.text("$$ /  \\__|$$ |        $$ |        $$ /  \\__|$$ /  $$ |$$ /  \\__|  $$ |  $$$$\\ $$ |$$ /  $$ |");
        Window.text("$$ |      $$ |        $$ |        $$ |      $$$$$$$$ |\\$$$$$$\\    $$ |  $$ $$\\$$ |$$ |  $$ |");
        Window.text("$$ |      $$ |        $$ |        $$ |      $$  __$$ | \\____$$\\   $$ |  $$ \\$$$$ |$$ |  $$ |");
        Window.text("$$ |  $$\\ $$ |        $$ |        $$ |  $$\\ $$ |  $$ |$$\\   $$ |  $$ |  $$ |\\$$$ |$$ |  $$ |");
        Window.text("\\$$$$$$  |$$$$$$$$\\ $$$$$$\\       \\$$$$$$  |$$ |  $$ |\\$$$$$$  |$$$$$$\\ $$ | \\$$ | $$$$$$  |");
        Window.text(" \\______/ \\________|\\______|       \\______/ \\__|  \\__| \\______/ \\______|\\__|  \\__| \\______/");
        Window.empty();
        Window.seperator();

    }

    public static void displayUserStats(User user) {
        int[] stats = user.getGameStats();

        Window.none();
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

    }

}
