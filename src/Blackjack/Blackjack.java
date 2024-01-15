package Blackjack;

import java.util.Scanner;
import java.util.ArrayList;

public class Blackjack {
    public static int playBlackjack(int betAmount, Scanner reader) throws InterruptedException {
        Deck deck = new Deck(0);

        int choice=0, win=0 ;//hit=1 stay=2 split=3
        //for loose: 1=dealer wins, 2 = player wins
        ArrayList<Integer> startingHand = new ArrayList<Integer>();
        ArrayList<Integer> dealerHand = new ArrayList<Integer>();
        //dealing the hand
        startingHand.add(deck.draw());
        startingHand.add(deck.draw());
        dealerHand.add(deck.draw());
        do{
            //printing hands
            displayHands(startingHand, dealerHand);

            if(getTotal(startingHand)>21){
               choice=2;
               win=1;
            }
            else{
                System.out.println("1. Hit 2. Stay");
                System.out.print("Enter choice: ");
                choice=reader.nextInt();

                if(choice==1){
                    startingHand.add(deck.draw());
                }
                else{
                    choice=2;
                }

            }

            if(getTotal(startingHand)>21){
               System.out.println("Bust!");

            }
            System.out.println();

        } while(choice != 2);

        //dealer taking turn
        if(win!=1){
            do{
                dealerHand.add(deck.draw());
            }while(getTotal(dealerHand)<17);

            displayHands(startingHand, dealerHand);

            if(getTotal(dealerHand)>getTotal(startingHand) && getTotal(dealerHand)<=21){
                win=1;
            } else{
                win=2;
            }    

        }

        if (win == 2) {
            return betAmount;
            
        } else {
            return -betAmount;

        }

    }

    public static void displayHands(ArrayList<Integer> startingHand, ArrayList<Integer> dealerHand) {
        System.out.println("+");
        System.out.println("|  Dealer's Hand: (" + getTotal(dealerHand) + ")");
        printHand(dealerHand);
        System.out.println("|");
        System.out.println("|  Your hand: (" + getTotal(startingHand) + ")");
        printHand(startingHand);
        System.out.println("+");
        System.out.println();

    }

    public static String getSuit (int card){
        switch((card/100)){
            case 0:
                return "Spades";
            case 1:
                return "Clubs";
            case 2:
                return "Hearts";
            case 3:
                return "Diamonds";
            default:
                return "error";
        }
    }
    public static int getNumber (int card){
        int temp=card-((card/100)*100);
        return temp;
    }
    
    public static String getFace (int number){
        switch(number){
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "error";
        }
    }

    public static int getTotal (ArrayList<Integer> startingHand){
        int sum=0, temp, aces=0;
        for(int k=0;k<startingHand.size();k++){
            temp=getNumber(startingHand.get(k));
            switch(temp){
                case 1:
                    //aces are weird
                    aces++;
                    break;
                case 11:
                case 12:
                case 13:
                    sum+=10;
                    break;
                default:
                    sum+=temp;
                    break;
            }
        }
        for(int k=1; k<=aces;k++){
            if((sum+11)<21){
                sum+=11;
            }
            else if((sum+1)<=21){
                sum++;
            }
        }
        return sum;
    }
    public static void printHand(ArrayList<Integer> startingHand){
        for(int k=0;k<startingHand.size();k++){
            if(getNumber(startingHand.get(k))==1||getNumber(startingHand.get(k))>10){
                System.out.print("|     * " + getFace(getNumber(startingHand.get(k))));
            }
            else{
                System.out.print("|     * " + getNumber(startingHand.get(k)));
            }
            System.out.println(" of "+getSuit(startingHand.get(k)));
        }

    }
}
