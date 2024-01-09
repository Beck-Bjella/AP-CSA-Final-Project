public class User {
    private String name;
    private int age;
    private int balance;

    private int[] gameStats;

    public User(String name, int age, int balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;

        this.gameStats = new int[3];

    }

    public String getName() {
        return this.name;

    }
    
    public int getAge() {
        return this.age;

    }
    
    public int getBalance() {
        return this.balance;

    }

    public int[] getGameStats() {
        return this.gameStats;

    }

    public void setBalance(int balance) {
        this.balance = balance;

    }

    public void addGame(Boolean win) {
        this.gameStats[0]++;
        if (win) {
            this.gameStats[1]++;
            
        } else {
            this.gameStats[2]++;

        }

    }

}
