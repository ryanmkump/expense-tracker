package me.ryankump.expensetracker.data;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
	
	private List<User> users;
	
	public UserManager() {
		users = new ArrayList<User>();
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public boolean userExists(String username) {
		for(User user : users) {
			if(user.getUsername().equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean accountInfoCorrect(String username, String password) {
		for(User user : users) {
			if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
				return true;
			}
		}
		
		return false;
	}
	
	public User getUser(String username, String password) {
		for(User user : users) {
			if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}

}
