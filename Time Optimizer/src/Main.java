import objects.Task;
import objects.TaskOrganizer;
import visuals.TaskWindow;

public class Main {

	public static void main(String[] args) {
		TaskOrganizer to = new TaskOrganizer(new Task("Marketing", 12, 11,11));
		TaskWindow w = new TaskWindow(to);
		w.setVisible(true);
	}
}
