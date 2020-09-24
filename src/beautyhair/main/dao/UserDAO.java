package beautyhair.main.dao;

import java.security.Principal;
import java.util.List;

import beautyhair.main.entity.User;

public interface UserDAO {

	public List<User> getUserList();
	
	public List<User> getFourEmployeesForIndex();
	
	public User getUserByUsername(String username);
	
	public void saveOrUpdateUser(User user);
	
	public void enableDisableUser(String username);
	
	public void deleteUser(String username);
	
	public User getPrincipal(Principal principal);
	
}
