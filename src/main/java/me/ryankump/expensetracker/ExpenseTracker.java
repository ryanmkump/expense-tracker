package me.ryankump.expensetracker;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.ryankump.expensetracker.data.UserManager;

@SpringBootApplication
public class ExpenseTracker {

	private static UserManager userManager;
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(ExpenseTracker.class, args);
		userManager = new UserManager();
	}
	
	public static UserManager getUserManager() {
		return userManager;
	}
	
}
