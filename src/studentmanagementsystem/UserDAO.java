package studentmanagementsystem;
import java.sql.Connection;

public class UserDAO {
	
	Connection connection;

	public User findByUsername(String username) {
		
		return null;
	}
	
	public boolean saveUser(User user) {
		return false;
		
	}
	boolean updatePassword(int userId, String newPassword) {
		return false;
		
	}
	boolean deleteUser(int userId) {
		return false;
		
	}
}
