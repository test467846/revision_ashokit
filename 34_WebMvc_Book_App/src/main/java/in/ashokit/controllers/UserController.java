package in.ashokit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entities.User;
import in.ashokit.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView();
		List<User> allUsers = userService.getAllUsers();
		mav.addObject("users", allUsers);
		mav.setViewName("usersView");
		return mav;
		
	}

	@PostMapping("/users")
	public ModelAndView saveUser(User user) {
		ModelAndView mav = new ModelAndView();
		boolean saveUser = userService.saveUser(user);
		if (saveUser) {
			mav.addObject("succMsg", "User Saved");
		} else {
			mav.addObject("errMsg", "User Failed");
		}
		mav.setViewName("userIndex");
		return mav;

	}
	
	@GetMapping("/userindex")
	public ModelAndView displayForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",new User());
		mav.setViewName("userIndex");
		return mav;

	}
	@GetMapping("/delete")
	public ModelAndView deleteUser(@RequestParam("userId")  Integer userId) {
		userService.deleteUser(userId);
		
		ModelAndView mav = new ModelAndView();
		List<User> allUsers = userService.getAllUsers();
		mav.addObject("users", allUsers);
		mav.setViewName("usersView");
		return mav;
	}
	
	

}
