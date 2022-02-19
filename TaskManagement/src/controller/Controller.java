package controller;

import java.time.LocalDate;

import data.dao.UserManagement;
import data.domain.User;
import data.domain.enums.TaskType;
import data.domain.task.TaskFactory;

public class Controller {
	
	private static Controller instance;
	
	private Controller() {
	}
	
	public static Controller getInstance(){
		if ( instance == null ) {
			instance = new Controller();
		}
		return instance;
	}
	
	public void login(String email) {
		
		//TODO
		UserManagement.getInstance().addUser(new User(email));
	}
	
	public void createTask(String email, TaskType taskType, String info) {
		
		UserManagement.getInstance().getUser(email).addTask(TaskFactory.getInstance().createTask(taskType, info));
		
	}
	
	public void orgTime(String email, LocalDate date, long init, long end) {
		UserManagement.getInstance().getUser(email);
	}
	
}
