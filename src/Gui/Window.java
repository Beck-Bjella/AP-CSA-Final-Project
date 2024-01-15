package Gui;
import java.util.Scanner;

public class Window {
    public static void text(String text) {
        System.out.print("* \t");
        System.out.print(text);
        
        int n = text.length();
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

    }

    public static int option(String q, String[] options, Scanner scanner) {
        seperator();
        empty();
        text(q);
        empty();     
        for (int i = 0; i < options.length; i++) {
            text((i + 1) + ". " + options[i]);
        }
        empty();
        seperator();
        none();

        int choice = scanner.nextInt();

        return choice;

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

    public static void displaySlotsTitle() {
        Window.seperator();
        Window.empty();
        Window.text(" $$$$$$\\  $$\\       $$$$$$\\ $$$$$$$$\\  $$$$$$\\");
        Window.text("$$  __$$\\ $$ |     $$  __$$\\\\__$$  __|$$  __$$\\ ");
        Window.text("$$ /  \\__|$$ |     $$ /  $$ |  $$ |   $$ /  \\__|");
        Window.text("\\$$$$$$\\  $$ |     $$ |  $$ |  $$ |   \\$$$$$$\\  ");
        Window.text(" \\____$$\\ $$ |     $$ |  $$ |  $$ |    \\____$$\\ ");
        Window.text("$$\\   $$ |$$ |     $$ |  $$ |  $$ |   $$\\   $$ |");
        Window.text("\\$$$$$$  |$$$$$$$$\\ $$$$$$  |  $$ |   \\$$$$$$  |");
        Window.text(" \\______/ \\________|\\______/   \\__|    \\______/ ");
        Window.empty();
        Window.seperator();
        Window.none();
        
    }

    public static void displayUserStats(User user) {
        int[] stats = user.getGameStats();

        Window.seperator();
        Window.empty();
        Window.text("USER: " + user.getName());
        Window.text("AGE: " + user.getAge());
        Window.empty();
        Window.text("BALANCE: $" + user.getBalance());
        Window.empty();
        Window.text("GAMES PLAYED: " + stats[0]);
        Window.text("GAMES WON: " + stats[1]);
        Window.text("GAMES LOST: " + stats[2]);
        Window.empty();
        Window.seperator();
        Window.none();

    }

    public static void displayBalance(User user) {
        Window.seperator();
        Window.empty();
        Window.text("BALANCE: $" + user.getBalance());
        Window.empty();
        Window.seperator();
        Window.none();

    }
    
    public static void displayBet(int bet) {
        Window.seperator();
        Window.empty();
        Window.text("BET: $" + bet);
        Window.empty();
        Window.seperator();
        Window.none();
        
    }

    public static void displayBalanceAndBet(User user, int bet) {
        Window.seperator();
        Window.empty();
        Window.text("BALANCE: $" + user.getBalance());
        Window.text("BET: $" + bet);
        Window.empty();
        Window.seperator();
        Window.none();

    }
    
}
