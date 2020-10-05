package visuals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.GregorianCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import objects.Task;
import objects.TaskOrganizer;

public class TaskWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 300;
	private TaskOrganizer tOrg = new TaskOrganizer();

	private JList<String> lsTasks = new JList<String>();
	private DefaultListModel<String> mdLsTasks = new DefaultListModel<>();

	private JPanel pnLista = new JPanel();

	public TaskWindow() {

		Task t1 = new Task("Ejs BD", new GregorianCalendar(2020, 9, 7), 1, true);
		Task t2 = new Task("Hacer Sostenibilidad", new GregorianCalendar(2020, 9, 7), 1, false);
		Task t3 = new Task("Proyecto prog", new GregorianCalendar(2021, 0, 01), true);
		Task t4 = new Task("Hacer Trello Prog", new GregorianCalendar(2020, 9, 8), 1, false);
		Task t5 = new Task("Telematics time management", new GregorianCalendar(2020, 9, 12), 2, true);
		tOrg.addAll(t1, t2, t3, t4, t5);

		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);

		getContentPane().add(pnLista, BorderLayout.CENTER);
		pnLista.add(new JScrollPane(lsTasks));
		lsTasks.setModel(mdLsTasks);
		updateList();

	}

	public void updateList() {
		mdLsTasks.clear();
		for (String s : tOrg.getTaskStringsforList()) {
			mdLsTasks.addElement(s);
		}
	}

}