public class User {
    private int id;
    private String name;
    private String pin;
    private double balance;

    public User(int id, String name, String pin, double balance) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setBalance(double balance) {
        this.balance = balance;
    }
}