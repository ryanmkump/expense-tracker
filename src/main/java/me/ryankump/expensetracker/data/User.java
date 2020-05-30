package me.ryankump.expensetracker.data;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String username, password;
	private List<Expense> expenses = new ArrayList<>();
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Expense> getExpenses(){
		return this.expenses;
	}
	
	public void addExpense(Expense expense) {
		this.expenses.add(expense);
	}
	
}
