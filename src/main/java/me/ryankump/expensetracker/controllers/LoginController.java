package me.ryankump.expensetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import me.ryankump.expensetracker.data.Expense;
import me.ryankump.expensetracker.data.User;

@Controller
@SessionAttributes("user")
public class LoginController {

	@ModelAttribute("user")
	@GetMapping("/login")
	public void loginForm(Model model) {
		model.addAttribute("user", new User());
	}

	@PostMapping("/login")
	public String loginSubmission(@ModelAttribute User user, Expense expense){
		return "expenses";
	}
	
	@GetMapping("/expenses")
	public void addExpenseForm(Model model) {
		model.addAttribute("expense", new Expense());
	}
	
	@PostMapping("/expenses")
	public String addExpenseSubmission(@ModelAttribute Expense ex, @SessionAttribute("user") User user) {
		user.addExpense(ex);
		return "redirect:/expenses";
	}
	
}
