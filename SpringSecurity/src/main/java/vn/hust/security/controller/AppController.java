package vn.hust.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hust.security.service.UserService;

@Controller
public class AppController {
	@Autowired
	private UserService userService;
	
	@GetMapping({"/", "/login"})
	public String showHome() {
		return "login";
	}
	
	@GetMapping("/admin/home")
	public String showAdmin(Model model, Principal principal) {
		model.addAttribute("name", principal.getName());
		model.addAttribute("idAdmin", userService.searchByUsername(principal.getName()).getId());
		return "admin";
	}
	
	@PreAuthorize("@preauthorizeUser.authorize(#idAdmin)")
	@GetMapping("/admin/{idAdmin}/notification")
	public String showNotification(@PathVariable("idAdmin") String idAdmin) {
		return "notification";
	}
	
	@GetMapping("/user/home")
	public String showUser() {
		return "user";
	}
	
	@GetMapping("/403")
	public String showError() {
		return "403";
	}
	
	@GetMapping("/register")
	public String showRegister() {
		return "register";
	}
	
	@GetMapping("/search")
	public String showSearch() {
		return "search";
	}

}
