import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User getUserById(int userId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("pin"),
                    resultSet.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUserBalance(int userId, double newBalance) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE users SET balance = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, newBalance);
            statement.setInt(2, userId);
            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}