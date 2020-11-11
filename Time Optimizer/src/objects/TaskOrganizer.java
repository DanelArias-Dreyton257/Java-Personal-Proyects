package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class TaskOrganizer implements Serializable, Iterable<Task>{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Task> tasks = new ArrayList<>();
	
	private Comparator<Task> timeComparator = new Comparator<Task>() {
		public int compare(Task o1, Task o2) {
			return (int) (o1.getDeadline().getTimeInMillis()-o2.getDeadline().getTimeInMillis());
		};
	};
	
	public TaskOrganizer() {
		
	}
	public TaskOrganizer(Task...tasks) {
		this.tasks.addAll(Arrays.asList(tasks));
		sort();
	}
	
	private void sort() {
		tasks.sort(timeComparator);
	}
	@Override
	public Iterator<Task> iterator() {
		return tasks.iterator();
	}
}
