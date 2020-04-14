package com.fdmgroup.soloProject_Colin_OneDay.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.soloProject_Colin_OneDay.model.User;
import com.fdmgroup.soloProject_Colin_OneDay.service.UserService;

@Controller
public class LoginController {

	public final static String SESSION_ATTRIBUTE_USER = "USER";

	@Autowired
	UserService userService;

	@GetMapping("")
	public String home() {
		return "mainScreen.jsp";
	}

	@GetMapping("Logout")
	public String logout() {
		return "mainScreen.jsp";
	}

	@GetMapping("basket")
	public String basket() {
		return "basket.jsp";
	}

	@PostMapping("UserLoginSubmit")
	public ModelAndView loginSubmit(@ModelAttribute("userId") User userId, ModelMap model, HttpSession session) {
		User user = userService.findById(userId.getUserId()).get();
		if (user == null) {
			model.addAttribute("errorMessage", "Incorrect userId");
			return new ModelAndView("home.jsp");
		}
		session.setAttribute(SESSION_ATTRIBUTE_USER, user);
		userService.calculateTotalPrice(user);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/basket.jsp", "user", user);
		return modelAndView;

	}

}
