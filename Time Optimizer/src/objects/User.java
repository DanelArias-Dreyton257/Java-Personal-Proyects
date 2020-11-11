package objects;

public class User {
	private String name;
	private TaskOrganizer tasks = new TaskOrganizer();
	private int workingHoursDay;
	
	public User(String name, int workingHoursDay) {
		setName(name);
		setWorkingHoursDay(workingHoursDay);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskOrganizer getTasks() {
		return tasks;
	}

	public void setTasks(TaskOrganizer tasks) {
		this.tasks = tasks;
	}

	public int getWorkingHoursDay() {
		return workingHoursDay;
	}

	public void setWorkingHoursDay(int workingHoursDay) {
		this.workingHoursDay = workingHoursDay;
	}
	

}
