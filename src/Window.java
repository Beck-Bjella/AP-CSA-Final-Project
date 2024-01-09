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
