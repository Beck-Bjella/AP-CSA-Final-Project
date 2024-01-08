import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        displayTitle();

        User user = createNewUser();

        if (user.getAge() < 18) {
            none();
            seperator();
            empty();
            text("You are not old enough to play!");
            empty();
            seperator();
            
            System.exit(0);

        }
        
        boolean playing = true;
        while (playing) {
            clear();
            displayUserStats(user);
            
            int sel = option("Please select a game:", new String[]{"Blackjack", "Roulette", "Slots", "Exit"} );
            switch (sel) {
                case 1:
                    playBlackjack(user);
                    break;

                case 2:
                    System.out.println("Roulette");
                    break;

                case 3:
                    System.out.println("Slots");
                    break;

                case 4:
                    exit();

            }

        }

        scanner.close();

    }

    public static void playBlackjack(User user) throws InterruptedException {
        int money = user.getBalance();

        none();
        seperator();
        empty();
        text("How much would you like to bet?");
        empty();
        seperator();

        System.out.println();

        int bet = scanner.nextInt();

        if (money - bet < 0) {
            none();
            seperator();
            empty();
            text("You don't have enough money to play!");
            empty();
            seperator();

            return;

        }

        Blackjack blackjack = new Blackjack();
        int[] result = blackjack.playBlackjack(money);

        if (result[0] == 2) {
            money += bet * 2;

            user.addGame(true); 

            none();
            seperator();
            empty();
            text("You won " + (bet * 2) + "$!");
            empty();
            seperator();

            Thread.sleep(5000);

        } else {
            money -= bet;

            user.addGame(false);

            none();
            seperator();
            empty();
            text("You lost " + (bet) + "$!");
            empty();
            seperator();

            Thread.sleep(5000);

        }

        user.setBalance(money);
        
    }

    public static void exit() throws InterruptedException {
        none();
        seperator();
        empty();
        text("Thank you for playing!");
        empty();
        seperator();

        Thread.sleep(2000);

        System.exit(0);

    }

    public static User createNewUser() {
        none();
        seperator();
        empty();
        text("Welcome to the casino!");
        empty();
        text("Please enter your name: ");
        empty();
        seperator();

        System.out.println();
        String name = scanner.nextLine();
        System.out.println();

        seperator();
        empty();
        text("Please enter your age: ");
        empty();
        seperator();

        System.out.println();
        int age = scanner.nextInt();

        User user = new User(name, age, 10000);

        return user;

    }

    public static void displayTitle() {
        seperator();
        empty();
        text(" $$$$$$\\  $$\\       $$$$$$\\\\        $$$$$$\\   $$$$$$\\   $$$$$$\\  $$$$$$\\ $$\\   $$\\  $$$$$$\\");
        text("$$  __$$\\ $$ |      \\_$$  _|      $$  __$$\\ $$  __$$\\\\ $$  __$$\\ \\_$$  _|$$$\\  $$ |$$  __$$\\");
        text("$$ /  \\__|$$ |        $$ |        $$ /  \\__|$$ /  $$ |$$ /  \\__|  $$ |  $$$$\\ $$ |$$ /  $$ |");
        text("$$ |      $$ |        $$ |        $$ |      $$$$$$$$ |\\$$$$$$\\    $$ |  $$ $$\\$$ |$$ |  $$ |");
        text("$$ |      $$ |        $$ |        $$ |      $$  __$$ | \\____$$\\   $$ |  $$ \\$$$$ |$$ |  $$ |");
        text("$$ |  $$\\ $$ |        $$ |        $$ |  $$\\ $$ |  $$ |$$\\   $$ |  $$ |  $$ |\\$$$ |$$ |  $$ |");
        text("\\$$$$$$  |$$$$$$$$\\ $$$$$$\\       \\$$$$$$  |$$ |  $$ |\\$$$$$$  |$$$$$$\\ $$ | \\$$ | $$$$$$  |");
        text(" \\______/ \\________|\\______|       \\______/ \\__|  \\__| \\______/ \\______|\\__|  \\__| \\______/");
        empty();
        seperator();

    }

    public static void displayUserStats(User user) {
        int[] stats = user.getGameStats();

        none();
        seperator();
        empty();
        text("USER: " + user.getName());
        text("AGE: " + user.getAge());
        empty();
        text("BALANCE: " + user.getBalance() + "$");
        empty();
        text("GAMES PLAYED: " + stats[0]);
        text("GAMES WON: " + stats[1]);
        text("GAMES LOST: " + stats[2]);
        empty();
        seperator();

    }

    public static void text(String text) {
        System.out.print("* \t");
        System.out.print(text);
        
        int n = text.length();
        // Tab using '\t' as many times as needed to get to the end of the box
        for (int i = 0; i < (100 - n - 4); i++) {
            System.out.print(" ");
        }
        System.out.println("*");

    }

    public static void empty() {
        System.out.println("*                                                                                                       *");
    }

    public static void seperator() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

    }

    public static void none() {
        System.out.println("");

    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        displayTitle();
    }

    public static int option(String q, String[] options) {
        none();
        seperator();
        empty();
        text(q);
        empty();     

        for (int i = 0; i < options.length; i++) {
            text((i + 1) + ". " + options[i]);
        }

        empty();
        seperator();

        System.out.println();

        int choice = scanner.nextInt();

        return choice;

    }

}
