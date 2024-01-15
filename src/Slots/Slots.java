package Slots;

import java.util.Random;
import java.util.Scanner;

import Gui.User;
import Gui.Window;

public class Slots {
    public static SlotItem blankItem = new SlotItem("blank", new String[]{"       ", "       ", "  ---  ", "       "});
    public static SlotItem blurItem = new SlotItem("blur", new String[]{"       ", " ||||| ", " ||||| ", " ||||| "});
    public static SlotItem starItem = new SlotItem("star", new String[]{"       ", " _/\\_  ", " ]/\\[  ", "       "});
    public static SlotItem diamondItem = new SlotItem("diamond", new String[]{" _____ ", "/|___|\\", "'.\\ /.'", "  '.'  "});
    public static SlotItem cherryItem = new SlotItem("cherry", new String[]{"\\\\_    ", "| \\\\ _ ", " \\\\_(_)", " (_)   "});
    public static SlotItem cardItem = new SlotItem("card", new String[]{" _____ ", "|4 v v|", "| v v |", "|____h|"});
    public static SlotItem barItem = new SlotItem("bar", new String[]{" _____ ", "|     |", "|*BAR*|", "|_____|"});
    public static SlotItem bar2Item = new SlotItem("bar2", new String[]{" _____ ", "|*BAR*|", "|*BAR*|", "|_____|"});
    public static SlotItem sevenItem = new SlotItem("seven", new String[]{"  ___  ", " |_  | ", "  / /  ", " /_/   "});
    public static SlotItem bellItem = new SlotItem("bell", new String[]{"   |   ", "  / \\  ", " /_ _\\ ", "   O   "});
    public static SlotItem leverOffItem = new SlotItem("leverOff", new String[]{" __", "(__)", " ||", " ||", " ||", " ||", " ||", "_//", "_/"});
    public static SlotItem leverOnItem = new SlotItem("leverOn", new String[]{"       __", "      (__)", "      //", "     //", "    //", "   //", "  //", "_//", "_/"});
    
    public static Random r = new Random();

    SlotItem[][] slotConfig;
    SlotItem leverPos;
    SlotItem win;
    double winScale = 1;

    public Slots() {
        slotConfig = new SlotItem[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                slotConfig[i][j] = blankItem;
            }
        }
        leverPos = leverOffItem;
    }

    public static void prefix(User user, int bet) {
        Window.clear();
        Window.displaySlotsTitle();
        Window.displayBalanceAndBet(user, bet);

    }

    public int playSlots(int bet, User user, Scanner scanner) throws InterruptedException {
        prefix(user, bet);
        displaySlots();

        Thread.sleep(1000);
        
        setSpinning();
        prefix(user, bet);
        displaySlots();

        Thread.sleep(1000);

        generateRandom();
        reveal(user, bet);

        setStopped();
        prefix(user, bet);
        displaySlots();

        checkAllWins();

        if (win != null) {
            System.out.println("");

            return (int) (bet * winScale);
        
        } else {
            System.out.println("No winning combination found");
            System.out.println("");

            return -bet;
        
        }
        
    
    }

    public void displaySlots() {
        String[][][] indivSlot = slotsToStringArray(slotConfig);
        String[] lever = leverPos.getArray();
        String renderedSlots = ("" + 
        "                       .-------.\r\n" + 
        "                       |Jackpot|\r\n" + 
        "           ____________|_______|____________\r\n" + 
        "          |  __    __    ___  _____   __    |\r\n" + 
        "          | / _\\  / /   /___\\/__   \\ / _\\   |\r\n" + 
        "          | \\ \\  / /   //  //  / /\\ \\\\ \\  25|\r\n" + 
        "          | _\\ \\/ /___/ \\_//  / /  \\/_\\ \\ []|\r\n" + 
        "          | \\__/\\____/\\___/   \\/     \\__/ []|\r\n" + 
        "          |===_______===_______===_______===|\r\n" + 
        "          ||*|"+indivSlot[0][0][0]+"|*|"+indivSlot[0][1][0]+"|*|"+indivSlot[0][2][0]+"|*||\r\n" + 
        "          ||*|"+indivSlot[0][0][1]+"|*|"+indivSlot[0][1][1]+"|*|"+indivSlot[0][2][1]+"|*||\r\n" + 
        "          ||*|"+indivSlot[0][0][2]+"|*|"+indivSlot[0][1][2]+"|*|"+indivSlot[0][2][2]+"|*||\r\n" + 
        "          ||*|"+indivSlot[0][0][3]+"|*|"+indivSlot[0][1][3]+"|*|"+indivSlot[0][2][3]+"|*||"+lever[0]+"\r\n" + 
        "          ||*|_______|*|_______|*|_______|*||"+lever[1]+"\r\n" + 
        "          |===_______===_______===_______===|"+lever[2]+"\r\n" + 
        "          ||*|"+indivSlot[1][0][0]+"|*|"+indivSlot[1][1][0]+"|*|"+indivSlot[1][2][0]+"|*||"+lever[3]+"\r\n" + 
        "          ||*|"+indivSlot[1][0][1]+"|*|"+indivSlot[1][1][1]+"|*|"+indivSlot[1][2][1]+"|*||"+lever[4]+"\r\n" + 
        "          ||*|"+indivSlot[1][0][2]+"|*|"+indivSlot[1][1][2]+"|*|"+indivSlot[1][2][2]+"|*||"+lever[5]+"\r\n" + 
        "          ||*|"+indivSlot[1][0][3]+"|*|"+indivSlot[1][1][3]+"|*|"+indivSlot[1][2][3]+"|*||"+lever[6]+"\r\n" + 
        "          ||*|_______|*|_______|*|_______|*||"+lever[7]+"\r\n" + 
        "          |===_______===_______===_______===|"+lever[8]+"\r\n" + 
        "          ||*|"+indivSlot[2][0][0]+"|*|"+indivSlot[2][1][0]+"|*|"+indivSlot[2][2][0]+"|*||\r\n" + 
        "          ||*|"+indivSlot[2][0][1]+"|*|"+indivSlot[2][1][1]+"|*|"+indivSlot[2][2][1]+"|*||\r\n" + 
        "          ||*|"+indivSlot[2][0][2]+"|*|"+indivSlot[2][1][2]+"|*|"+indivSlot[2][2][2]+"|*||\r\n" + 
        "          ||*|"+indivSlot[2][0][3]+"|*|"+indivSlot[2][1][3]+"|*|"+indivSlot[2][2][3]+"|*||\r\n" + 
        "          ||*|_______|*|_______|*|_______|*||\r\n" + 
        "          |lc=___________________________===|\r\n" + 
        "          |  /___________________________\\  |\r\n" + 
        "          |   |                         |   |\r\n" + 
        "         _|    \\_______________________/    |_\r\n" + 
        "        (_____________________________________)");
        
        System.out.println(renderedSlots);
        System.out.println();

    }

    public void setSpinning() {
        leverPos = leverOnItem;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                slotConfig[i][j] = blurItem;
            }
        }

    }

    public void setStopped() {
        leverPos = leverOffItem;

    }

    public void reveal(User user, int bet) throws InterruptedException {
        SlotItem[][] slotConfigClone = new SlotItem[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                slotConfigClone[i][j] = slotConfig[i][j];

            }

        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                slotConfig[i][j] = blurItem;

            }

        }

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                slotConfig[i][j] = slotConfigClone[i][j];

                prefix(user, bet);
                displaySlots();

                Thread.sleep(150);

            }

            Thread.sleep(250);

        }

    }

    public String[][][] slotsToStringArray(SlotItem[][] slotItems) {
        String[][][] stringArray = new String[3][3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                stringArray[i][j] = slotItems[i][j].getArray();
            }
        }
        return stringArray;
    }

    public String[][] slotsToStringItem(SlotItem[][] slotItems) {
        String[][] stringItem = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                stringItem[i][j] = slotItems[i][j].getName();
            }
        }
        return stringItem;
    }

    public void generateRandom() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double itemChooser = r.nextDouble();
                SlotItem slotItem = numToslotItem(itemChooser);
                slotConfig[i][j] = slotItem;
            }
        }
    }

    public SlotItem numToslotItem(double num) {
        if (num < 0.03) return sevenItem;        // 3% chance
        else if (num < 0.08) return starItem;    // 5% chance
        else if (num < 0.15) return diamondItem; // 7% chance
        else if (num < 0.22) return bellItem;    // 7% chance
        else if (num < 0.30) return barItem;     // 8% chance
        else if (num < 0.39) return bar2Item;    // 9% chance
        else if (num < 0.56) return cherryItem;  // 17% chance
        else if (num < 0.88) return cardItem;    // 32% chance (scaled up)
        else return blankItem;
    }
    
    public void checkAllWins() {
        checkSevenWins();
        checkStarWins();
        checkCardWins();
        checkAllSlotWins();
        
    }

    public boolean checkSevenWins() {
        int count = 0;
        // Iterate through the entire grid and count the number of sevens
        for (int i = 0; i < slotConfig.length; i++) {
            for (int j = 0; j < slotConfig[i].length; j++) {
                if (slotConfig[i][j] == sevenItem) {
                    count++;
                }
            }
        }
        if (count >= 4) {
            win = sevenItem;
            winScale *= 10;
            return true;
        }
        return false;
    }

    public boolean checkStarWins() {
        String[][] slots = slotsToStringItem(slotConfig);
        String[] winTypes = {
            "Stars are at the top separated",
            "Stars are at the top together left",
            "Stars are at the top together right"
        };
        int[][] winPatterns = {
            {0, 0, 0, 2}, // 13
            {0, 0, 0, 1}, // 12
            {0, 1, 0, 2}, // 23
        };

        for (int i = 0; i < winPatterns.length; i++) {
            if (checkAndRecordWin(slots, winPatterns[i], winTypes[i], "star")) {
                System.out.println("Winning combination found: " + winTypes[i]);
                winScale *= 3;
                return true;
            }
        }
        return false;
    }

    public boolean checkCardWins() {
        String[][] slots = slotsToStringItem(slotConfig);
        String[] winTypes = {
            "Four cards in the upper left corner",
            "Four cards in the upper right corner",
            "Four cards in the bottom left corner",
            "Four cards in the bottom right corner"
        };
        int[][] winPatterns = {
            {0, 0, 0, 1, 1, 0, 1, 1}, // 1245
            {0, 1, 0, 2, 1, 1, 1, 2}, // 2356
            {1, 0, 1, 1, 2, 0, 2, 1}, // 4578
            {1, 1, 1, 2, 2, 1, 2, 2}  // 5689
        };

        for (int i = 0; i < winPatterns.length; i++) {
            if (checkAndRecordWin(slots, winPatterns[i], winTypes[i], "card")) {
                System.out.println("Winning combination found: " + winTypes[i]);
                winScale *= 5;
                return true;
            }
        }
        return false;
    }

    public boolean checkAllSlotWins() {
        String[][] slots = slotsToStringItem(slotConfig);
        String[] winTypes = {
            "Three in a row horizontally at the top",
            "Three in a row horizontally in the middle",
            "Three in a row horizontally at the bottom",
            "Three in a row diagonally from top left to bottom right",
            "Three in a row diagonally from top right to bottom left"
        };
        int[][] winPatterns = {
            {0, 0, 0, 1, 0, 2}, // 1-2-3
            {1, 0, 1, 1, 1, 2}, // 4-5-6
            {2, 0, 2, 1, 2, 2}, // 7-8-9
            {0, 0, 1, 1, 2, 2}, // 1-5-9
            {0, 2, 1, 1, 2, 0}  // 3-5-7
        };

        boolean foundWin = false;

        for (int i = 0; i < winPatterns.length; i++) {
            if (checkAndRecordWin(slots, winPatterns[i], winTypes[i], null)) {
                System.out.println("Winning combination found: " + winTypes[i]);
                if (win == sevenItem) winScale *= 80; // Rarest
                else if (win == starItem) winScale *= 30;
                else if (win == diamondItem) winScale *= 20;
                else if (win == bellItem) winScale *= 10;
                else if (win == barItem) winScale *= 7;
                else if (win == bar2Item) winScale *= 7;
                else if (win == cherryItem) winScale *= 5; // Less rare
                else if (win == cardItem) winScale *= 3;
                foundWin = true; // Mark that a win was found
            }            
        }

        return foundWin;
    }

    private boolean checkAndRecordWin(String[][] slots, int[] pattern, String winType, String specificSlotItem) {
        String firstSlot = specificSlotItem == null ? slots[pattern[0]][pattern[1]] : specificSlotItem;
        boolean isWin = true;

        for (int i = 0; i < pattern.length; i += 2) {
            String currentSlot = slots[pattern[i]][pattern[i + 1]];
            if (specificSlotItem != null && !currentSlot.equals(specificSlotItem)) {
                isWin = false;
                break;
            } else if (specificSlotItem == null && !currentSlot.equals(firstSlot)) {
                isWin = false;
                break;
            }
        }

        if (isWin) {win = slotConfig[pattern[0]][pattern[1]];}
        return isWin;
    }

}