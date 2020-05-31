package me.ryankump.expensetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import me.ryankump.expensetracker.ExpenseTracker;
import me.ryankump.expensetracker.data.Expense;
import me.ryankump.expensetracker.data.Status;
import me.ryankump.expensetracker.data.User;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@ModelAttribute("user")
	@GetMapping("/login")
	public void loginForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("login", new User());
		model.addAttribute("status", new Status());
	}
	
	@PostMapping("/login")
	public String loginSubmission(Model model, @ModelAttribute("login") User login, @ModelAttribute Status status, Expense expense){
		if(ExpenseTracker.getUserManager().accountInfoCorrect(login.getUsername(), login.getPassword())) {
			model.addAttribute("user", ExpenseTracker.getUserManager().getUser(login.getUsername(), login.getPassword()));
		return "expenses";
		} else {
			status.setStatus("PASSWORDERROR");
			status.setMessage("The password entered for account " + login.getUsername() + " is wrong.");
		}
		return "login";
	}
	
	@GetMapping("/createAccount")
	public void createAccount(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("status", new String());
	}
	
	@PostMapping("/createAccount")
	public String createAccountSubmission(@ModelAttribute User user, @ModelAttribute Status status) {
		if(ExpenseTracker.getUserManager().userExists(user.getUsername())) {
			status.setStatus("ERROR");
			status.setMessage("Error: An account with the username " + user.getUsername() + " already exists.");
		} else {
			ExpenseTracker.getUserManager().addUser(user);
			status.setStatus("SUCCESS");
			status.setMessage("Success! An account named " + user.getUsername() + " has been created!");
		}
		return "login";
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
