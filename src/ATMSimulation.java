import java.util.Scanner;

public class ATMSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMOperations atmOperations = new ATMOperations();
        AdminOperations adminOperations = new AdminOperations();

        System.out.println("Welcome to the ATM Simulation System");
        System.out.print("Are you an (1) Admin or (2) User? ");
        int mode = scanner.nextInt();

        if (mode == 1) {
            // Admin mode
            System.out.println("Admin Mode:");
            System.out.print("Do you want to (1) Add User or (2) Delete User? ");
            int adminChoice = scanner.nextInt();

            if (adminChoice == 1) {
                System.out.print("Enter User Name: ");
                String name = scanner.next();
                System.out.print("Enter User PIN: ");
                String pin = scanner.next();
                System.out.print("Enter Initial Balance: ");
                double balance = scanner.nextDouble();
                adminOperations.addUser(name, pin, balance);
            } else if (adminChoice == 2) {
                System.out.print("Enter User ID to delete: ");
                int userId = scanner.nextInt();
                adminOperations.deleteUser(userId);
            }
        } else if (mode == 2) {
            // User mode
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            System.out.print("Enter PIN: ");
            String pin = scanner.next();

            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserById(userId);

            if (user != null && atmOperations.validatePIN(user, pin)) {
                System.out.println("User Mode:");
                System.out.println("(1) Check Balance");
                System.out.println("(2) Deposit");
                System.out.println("(3) Withdraw");
                int userChoice = scanner.nextInt();

                if (userChoice == 1) {
                    System.out.println("Balance: " + atmOperations.checkBalance(user));
                } else if (userChoice == 2) {
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    atmOperations.deposit(user, amount);
                } else if (userChoice == 3) {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    atmOperations.withdraw(user, amount);
                }
            } else {
                System.out.println("Invalid User ID or PIN.");
            }
        }

        scanner.close();
    }
}