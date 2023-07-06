package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	public String viewStartpage() {
		return "getstarted";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/s_viewmember")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "s_viewmember";
	}
    @GetMapping("/login")
    public String viewLoginPage() {
        // custom logic before showing login page...
         
        return "login";
    }
    
    @GetMapping("/who")
    public String who() {
        // custom logic before showing login page...
         
        return "who";
    }
    @GetMapping("/users")
    public String viewMember() {
        // custom logic before showing login page...
    	
         
        return "users";
    }
    
    @GetMapping("/s_home")
    public String home() {
        // custom logic before showing login page...
         
        return "s_home";
    }
    
//	@GetMapping("/s_viewmember")
//	public String listMembers(Model model) {
//		List<User> listMember = memberRepo.findAll();
//		model.addAttribute("listMembers", listMembers);
//		
//		return "s_viewmember";
//	}
}
