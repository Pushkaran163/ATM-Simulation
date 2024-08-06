public class ATMOperations {
    private UserDAO userDAO = new UserDAO();

    public boolean validatePIN(User user, String inputPIN) {
        return user.getPin().equals(inputPIN);
    }

    public double checkBalance(User user) {
        return user.getBalance();
    }

    public boolean deposit(User user, double amount) {
        double newBalance = user.getBalance() + amount;
        return userDAO.updateUserBalance(user.getId(), newBalance);
    }

    public boolean withdraw(User user, double amount) {
        if (amount > user.getBalance()) {
            return false;
        }
        double newBalance = user.getBalance() - amount;
        return userDAO.updateUserBalance(user.getId(), newBalance);
    }
}