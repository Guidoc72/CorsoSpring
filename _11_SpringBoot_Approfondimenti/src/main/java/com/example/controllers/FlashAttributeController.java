package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.models.Student;

@Controller
public class FlashAttributeController {
	@GetMapping("/flash_attribute")
	public String goToFlashAttribute(Model model) {
		model.addAttribute("student", new Student());
		return "flash_attribute";
	}
	
    @PostMapping("/submit-form")
    public String submitForm(	@ModelAttribute("student") Student student, 
    							RedirectAttributes redirectAttributes) {
    	redirectAttributes.addFlashAttribute("student", student);
        redirectAttributes.addFlashAttribute("message", 
        		"Il modulo 'flashattribute' è stato inviato con successo!");
        return "redirect:/destination_fa";
    }

    @GetMapping("/destination_fa")
    public String confirmation(Model model) {
    	return "destination_fa";
    }
}

