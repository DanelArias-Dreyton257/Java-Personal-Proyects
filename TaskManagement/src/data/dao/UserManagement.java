package data.dao;

import java.util.HashMap;
import java.util.List;

import data.domain.*;

public class UserManagement {
	
	private HashMap<String,User> users = new HashMap<>();
	
	private static UserManagement instance;
	
	private UserManagement() {
	}
	
	public static UserManagement getInstance(){
		if ( instance == null ) {
			instance = new UserManagement();
		}
		return instance;
	}

	public User getUser(String email) {
		return users.get(email);
	}

	public void addUser(User u) {
		this.users.put(u.getEmail(), u);
	}
	public void addUsers(List<User> users) {
		for (User u: users) addUser(u);
	}
	
	
	
}
