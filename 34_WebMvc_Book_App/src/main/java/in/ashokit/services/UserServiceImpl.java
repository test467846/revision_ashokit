package in.ashokit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entities.User;
import in.ashokit.repos.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public boolean saveUser(User user) {
		User savedUser = userRepo.save(user);
		if(savedUser.getUserId()!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);
		
		
	}

}
