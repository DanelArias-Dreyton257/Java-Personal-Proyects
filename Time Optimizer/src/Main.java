import objects.Task;
import objects.User;
import visuals.TaskWindow;

public class Main {

	public static void main(String[] args) {
		User us = new User("Danel",5);
		us.getTasks().add(new Task("Marketing", 5, 12, 11, 23));
		us.getTasks().get(0).setCompletionRate(0.85);;
		TaskWindow w = new TaskWindow(us);
		w.setVisible(true);
	}
}
