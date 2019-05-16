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
	
	@GetMapping({"/", "/user/home"})
	public String showHome(Principal principal) {
		try {
			if(principal.getName().isEmpty()) {
				return "login";
			}else {
				return "user";
			}
		} catch (Exception e) {
			return "login";
		}
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/admin/home")
	public String showAdmin(Model model, Principal principal) {
		model.addAttribute("name", principal.getName());
		model.addAttribute("idAdmin", userService.getAuthId(principal.getName()));
		return "admin";
	}
	
	@PreAuthorize("@preauthorizeUser.authorize(#idAdmin)")
	@GetMapping("/admin/{idAdmin}/notification")
	public String showNotification(@PathVariable("idAdmin") String idAdmin) {
		return "notification";
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
