package in.ashokit.services;

import java.util.List;

import in.ashokit.entities.User;

public interface UserService {
	
	public boolean saveUser(User user);
	
	public List<User> getAllUsers();
	
	public void deleteUser(Integer userId);

}
