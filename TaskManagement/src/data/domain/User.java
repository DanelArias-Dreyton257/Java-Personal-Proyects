package data.domain;

import java.util.ArrayList;
import java.util.List;

import data.domain.task.Task;

public class User {
	private String email;
	private List<Task> tasks = new ArrayList<>();
	
	public User(String email) {
		setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Task> getTasks() {
		return tasks;
	}
	
	public void addTask(Task t) {
		if (!tasks.contains(t)) tasks.add(t);
	}
	
	public void deleteTask(Task t) {
		tasks.remove(t);
	}
	
	
}
