package com.seavus.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.seavus.domain.Member;
import com.seavus.service.LibraryService;

@Controller
@RequestMapping("/members")
public class MembershipMvcController {
	
	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return "members";
	}
	
	@ModelAttribute("member")
	public Member member() {
		return new Member();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerMember(@ModelAttribute("member") Member member) {
		if(member.getId() == null){
			libraryService.registerMember(member);
			
		}
		return "redirect:/";
	}
}
