package com.seavus.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seavus.domain.ThymeleafObjectBindingHelper;
import com.seavus.service.LibraryService;

@Controller
@RequestMapping("/loan")
public class LoanMvcController {
	@Autowired
	private LibraryService libraryService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "loan";
	}
	

	@ModelAttribute("loan")
	public ThymeleafObjectBindingHelper loan() {
		return new ThymeleafObjectBindingHelper();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerLoan(ThymeleafObjectBindingHelper loan) {

		Long mId = loan.getMemberId();
		Long pId = loan.getPublicationId();

		libraryService.registerLoan(mId, pId);
		return "redirect:/";
	}
}
