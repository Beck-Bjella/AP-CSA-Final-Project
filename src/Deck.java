import java.util.Random;
import java.util.ArrayList;
public class Deck{
    /**
     * key:
     * spades - 0
     * clubs - 1
     * hearts - 2
     * diamonds 3
     *
     * ace - 1
     * jack - 11
     * queen - 12
     * king - 13
     *
     * Ex. 5 of clubs would be 105
     * Ex. jack of spades would be 011
     * */
    int deck;
    Random rnum = new Random();
    ArrayList<Integer> used = new ArrayList<Integer>();
    public Deck(){
        int deck=0;    
    }
    public int draw(){
        int pass=0, suite, number, choice;
        do{
            suite = rnum.nextInt(4)*100;
            number = rnum.nextInt(13)+1;
            choice = suite+number;
            for(int k=0; k<used.size();k++){
                if(choice==used.get(k)){
                    pass=1;
                }
            }
        }while(pass != 0);
        used.add(choice);
        return choice;
    }
    public void scoopDeck(){
        used.clear();
    }
}



