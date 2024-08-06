import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminOperations{
    public boolean addUser(String name, String pin, double balance){
        try(Connection connection = DatabaseConnection.getConnection()){
            String query = "INSERT INT users (name, pin, balance) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, pin);
            statement.setDouble(3, balance);
            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteUser(int userId){
        try(Connection connection = DatabaseConnection.getConnection()){
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}