package Blackjack;

import java.util.Random;
import java.util.ArrayList;

public class Deck{
    int deck;
    Random rnum = new Random();
    ArrayList<Integer> used = new ArrayList<Integer>();

    public Deck(int n){
        deck = n;    

    }

    public void scoopDeck(){
        used.clear();

    }

    public int draw() {
        boolean valid = false;

        int choice = 1000000;

        do {
            int suite = rnum.nextInt(4)*100;
            int number = rnum.nextInt(13)+1;

            choice = suite+number;
            
            valid = true;
            for (int i = 0; i < used.size(); i++) {
                if (choice == used.get(i)) {
                    valid = false;

                }

            }

        } while (!valid);

        return choice;

    }
    
}



