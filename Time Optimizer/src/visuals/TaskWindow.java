package visuals;

import java.awt.BorderLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import objects.Task;
import objects.TaskOrganizer;

public class TaskWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 300;
	private TaskOrganizer tOrg = new TaskOrganizer();

	private JList<Task> lsTasks = new JList<Task>();
	private DefaultListModel<Task> mdLsTasks = new DefaultListModel<>();
	private JLabel lbName = new JLabel("NULL");
	private JLabel lbDeadline = new JLabel("XX/XX/XXXX");

	private JPanel pnLista = new JPanel();
	private JPanel pnSuperior = new JPanel();

	public TaskWindow() {
//		Task t1 = new Task("Programar Tareas", new GregorianCalendar(2021, 2-1, 7),27, 6);
//		Task t2 = new Task("Ordenar y limpiar habitacion", new GregorianCalendar(2021, 2-1, 7),22, 7);
//		Task t4 = new Task("Leds Vitrina", new GregorianCalendar(2021, 3-1, 31),2, 6);
//		tOrg.addAll(t1, t2, t4);
//		for (Task t: tOrg) {
//			System.out.println(t);
//			System.out.println(t.getDeadlineInString());
//			System.out.println("\t"+t.getRemainingDays());
//			System.out.println("\t"+t.getHoursPerDay());
//		}
		
		System.out.println(tOrg);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);

		getContentPane().add(pnLista, BorderLayout.CENTER);
		getContentPane().add(pnSuperior, BorderLayout.NORTH);
		pnLista.add(new JScrollPane(lsTasks));
		lsTasks.setModel(mdLsTasks);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) lsTasks.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		updateList();
		
		pnSuperior.add(new JLabel("Name:"));
		pnSuperior.add(lbName);
		pnSuperior.add(new JLabel("Deadline:"));
		pnSuperior.add(lbDeadline);
		
		lsTasks.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int id = lsTasks.getSelectedIndex();
				if (id != -1) {
					Task t = lsTasks.getSelectedValue();
					lbDeadline.setText(t.getDeadlineInString());
					lbName.setText(t.getName());
				}
				
			}
		});

	}

	public void updateList() {
		mdLsTasks.clear();
		for (Task s : tOrg) {
			mdLsTasks.addElement(s);
		}
	}

}
