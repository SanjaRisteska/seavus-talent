package com.seavus.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seavus.domain.Magazine;
import com.seavus.service.LibraryService;

@Controller
@RequestMapping("/magazines")
public class MagazineMvcController {

	@Autowired
	private LibraryService libraryService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "magazines";
	}
	
	@ModelAttribute("magazine")
	public Magazine magazine(){
		return new Magazine();
	}
	
	@ModelAttribute("magazines")
	public List<Magazine> magazines(){
		return libraryService.listMagazines();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerMagazine(@ModelAttribute("magazine") Magazine magazine) {
		if(magazine.getId() == null){
			libraryService.registerMagazine(magazine);
		} else {
			libraryService.updateMagazine(magazine);
		}
		return "redirect:/magazines";
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editMagazine(@PathVariable("id") Long id, Model model) {
		final Magazine magazine = libraryService.findMagazine(id);
		model.addAttribute("magazine", magazine);
		return "magazines";
	}
	
	@RequestMapping(value = "/unregister/{id}", method = RequestMethod.GET)
	public String unregisterMagazine(@PathVariable("id") Long id, Model model){
		libraryService.deleteMagazine(id);
		return "redirect:/magazines";
	}
	
	
}
