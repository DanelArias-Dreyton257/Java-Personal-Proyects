package objects;

import java.util.TreeSet;

/**
 * 
 * @author danel
 *
 */
public class TaskOrganizer {

	private TreeSet<Task> tasks = new TreeSet<>(); // Where task are organized

	public TaskOrganizer() {

	}

	/**
	 * Adds a task to the organizer
	 * 
	 * @param task
	 */
	public void add(Task task) {
		tasks.add(task);
	}

	/**
	 * Adds all the tasks as parameters to the organizer
	 * 
	 * @param tasks
	 */
	public void addAll(Task... tasks) {
		for (Task t : tasks)
			add(t);
	}
	
	public String[] getTaskStringsforList() {
		String[] strs = new String[tasks.size()];
		int i=0;
		for (Task t:tasks) {
			strs[i]=t.getStringForList();
			i++;
		}
		return strs;
	}
	

	@Override
	public String toString() {
		String s = "";
		for (Task t : tasks) {
			s += t.toString() + ",\n";
		}
		return "TaskOrganizer:\n[" + s + "]";
	}
}
