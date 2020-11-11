import objects.Task;
import objects.User;
import visuals.TaskWindow;

public class Main {

	public static void main(String[] args) {
		User us = new User("Danel",5);
		us.getTasks().add(new Task("Marketing", 12, 11, 23));
		TaskWindow w = new TaskWindow(us);
		w.setVisible(true);
	}
}
