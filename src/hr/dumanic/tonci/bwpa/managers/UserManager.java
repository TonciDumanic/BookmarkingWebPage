/**

 * 
 */
package hr.dumanic.tonci.bwpa.managers;
import java.util.List;

import hr.dumanic.tonci.bwpa.dao.UserDao;
import hr.dumanic.tonci.bwpa.entities.User;
/**
 * @author etondum
 *
 */
public class UserManager {

	private static UserManager instance = new UserManager();

	private UserManager() {}
	
	private static UserDao userDao = new UserDao();
	
	public static UserManager getInstance() {
		
		return instance;
	}
	
	public User createUser(long id, String email, String password, String firstName, String lastName, int gender, String UserType) {
		
		User user = new User();
		
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(UserType);
		
		return user;
		
	}
	
	public List<User> getUsers( ) {
		return userDao.getUser();
	}
	
	
}
