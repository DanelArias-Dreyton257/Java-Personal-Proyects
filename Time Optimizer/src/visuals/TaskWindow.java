package visuals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.GregorianCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import objects.Task;
import objects.TaskOrganizer;

public class TaskWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 300;
	private TaskOrganizer tOrg = new TaskOrganizer();

	private JList<String> lsTasks = new JList<String>();
	private DefaultListModel<String> mdLsTasks = new DefaultListModel<>();
	private JTextField txName = new JTextField(40);
	private JLabel lbDeadline = new JLabel();

	private JPanel pnLista = new JPanel();

	public TaskWindow() {

		Task t1 = new Task("Programar Tareas", new GregorianCalendar(2021, 02, 7),27, 6);
		Task t2 = new Task("Ordenar y limpiar habitacion", new GregorianCalendar(2021, 02, 7),22, 7);
		Task t3 = new Task("Investigar PILAR", new GregorianCalendar(2021, 01, 29),3, 7);
		Task t4 = new Task("Leds Vitrina", new GregorianCalendar(2021, 3, 31),2, 6);
		tOrg.addAll(t1, t2, t3, t4);
		
		System.out.println(tOrg);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
