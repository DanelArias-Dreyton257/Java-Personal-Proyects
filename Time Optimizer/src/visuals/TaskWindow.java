package visuals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.GregorianCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import objects.Task;
import objects.TaskOrganizer;

public class TaskWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 300;
	private TaskOrganizer tOrg = new TaskOrganizer();
	
	private JList<String> lsTasks = new JList<>();
	private DefaultListModel<String> mdLsTasks = new DefaultListModel<>();

	public TaskWindow() {
		
		Task t1 = new Task("Terminar Estadistica", new GregorianCalendar(2020, 9, 04), true);
		Task t2 = new Task("Hacer Sostenibilidad", new GregorianCalendar(2020, 9, 05), false);
		Task t3 = new Task("Proyecto prog", new GregorianCalendar(2021, 0, 01), true);
		tOrg.addAll(t1, t2, t3);

		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		
		getContentPane().add(new JScrollPane(lsTasks),BorderLayout.CENTER);
		lsTasks.setModel(mdLsTasks);
		updateList();

	}
	
	public void updateList() {
		mdLsTasks.clear();
		for (String s: tOrg.getTaskStringsforList()) {
			mdLsTasks.addElement(s);
		}
	}

}
