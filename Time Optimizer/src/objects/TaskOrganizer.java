package objects;

import java.util.TreeSet;

/**
 * 
 * @author danel
 *
 */
public class TaskOrganizer extends TreeSet<Task>{

	
	private static final long serialVersionUID = 1L;

	public TaskOrganizer() {
		super();
	}

	/**
	 * Adds all the tasks as parameters to the organizer
	 * 
	 * @param tasks
	 */
	public void addAll(Task... tasks) {
		for (Task t : tasks)
			this.add(t);
	}
	
	public String[] getTaskStringsforList() {
		String[] strs = new String[this.size()];
		int i=0;
		for (Task t:this) {
			strs[i]=t.getName();
			i++;
		}
		return strs;
	}
	

	@Override
	public String toString() {
		String s = "";
		for (Task t : this) {
			s += t.toString() + ",\n";
		}
		return "TaskOrganizer:\n[" + s + "]";
	}
}
