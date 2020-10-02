
import java.util.GregorianCalendar;
import java.util.TreeSet;

import objects.Task;

public class Main {
	
	public static void main(String[] args) {
		TreeSet<Task> tasks = new TreeSet<>();
		Task t1 = new Task("Terminar Estadistica", new GregorianCalendar(2020, 9, 04), true);
		tasks.add(t1);
		Task t2 = new Task("Hacer Sostenibilidad", new GregorianCalendar(2020, 9, 05), false);
		tasks.add(t2);
		Task t3 = new Task("Proyecto prog", new GregorianCalendar(2021, 0, 01), true);
		tasks.add(t3);
		for (Task t: tasks) {
			System.out.println(t);
		}
	}
}
