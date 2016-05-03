package twitter.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import twitter.domain.MyUser;
import twitter.service.TwitterService;

@Controller
@RequestMapping("/users")
public class UserMvcController {
	
	@Autowired
	TwitterService twitterService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return "users";
	}
	
	@ModelAttribute("user")
	public MyUser member() {
		return new MyUser();
	}
	
	@ModelAttribute("users")
	public List<MyUser> members(){
		return twitterService.listAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerMember(@ModelAttribute("user") MyUser user) {
		if(user.getId() == null){
			twitterService.registerUser(user.getNickName());
			
		}
		return "redirect:/";
	}
}
