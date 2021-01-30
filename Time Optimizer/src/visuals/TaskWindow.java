package visuals;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import objects.Task;
import objects.TaskOrganizer;

public class TaskWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 500;

	private TaskOrganizer tOrg = new TaskOrganizer();

	private JList<Task> lsTasks = new JList<Task>();
	private DefaultListModel<Task> mdLsTasks = new DefaultListModel<>();

	private JLabel lbName = new JLabel("NULL");
	private JLabel lbDeadline = new JLabel("XX/XX/XXXX");

	private JPanel pnList = new JPanel();
	private JPanel pnSuperior = new JPanel();
	private JPanel pnButtons = new JPanel();
	private JPanel pnTaskManager = new JPanel();
	private JPanel pnCentral = new JPanel();
	private JPanel pnTaskCentral = new JPanel();

	private JTextField txName = new JTextField(20);
	private JTextField txNumHours = new JTextField(4);
	private JTextField txDay = new JTextField(3);
	private JTextField txMonth = new JTextField(3);
	private JTextField txYear = new JTextField(6);
	private JSlider slImportance = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);

	private JButton btAdd = new JButton("Add Task");

	public TaskWindow() {
//		Task t1 = new Task("Programar Tareas", new GregorianCalendar(2021, 2 - 1, 7), 27, 6);
//		Task t2 = new Task("Ordenar y limpiar habitacion", new GregorianCalendar(2021, 2 - 1, 7), 22, 7);
//		Task t4 = new Task("Leds Vitrina", new GregorianCalendar(2021, 3 - 1, 31), 2, 6);
//		tOrg.addAll(t1, t2, t4);
//		for (Task t: tOrg) {
//			System.out.println(t);
//			System.out.println(t.getDeadlineInString());
//			System.out.println("\t"+t.getRemainingDays());
//			System.out.println("\t"+t.getHoursPerDay());
//		}
//
//		System.out.println(tOrg);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);

		getContentPane().add(pnCentral, BorderLayout.CENTER);
		getContentPane().add(pnSuperior, BorderLayout.NORTH);
		pnCentral.add(pnList);
		pnCentral.add(pnTaskManager);
		pnList.add(new JScrollPane(lsTasks));
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
		pnTaskManager.setLayout(new BorderLayout());
		pnTaskManager.add(pnTaskCentral, BorderLayout.CENTER);
		pnTaskCentral.add(txName);
		pnTaskCentral.add(txNumHours);
		pnTaskCentral.add(txDay);
		pnTaskCentral.add(new JLabel("/"));
		pnTaskCentral.add(txMonth);
		pnTaskCentral.add(new JLabel("/"));
		pnTaskCentral.add(txYear);
		pnTaskCentral.add(slImportance);
		slImportance.setMajorTickSpacing(1);
		slImportance.setPaintTicks(true);
		slImportance.setPaintLabels(true);
		pnTaskManager.add(pnButtons, BorderLayout.SOUTH);
		pnButtons.add(btAdd);

		btAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Task t = null;
				String name = txName.getText();
				String hoursStr = txNumHours.getText();
				String dayStr = txDay.getText();
				String monthStr = txMonth.getText();
				String yearStr = txYear.getText();
				int importance = slImportance.getValue();
				checkAndAddTask(name, hoursStr, dayStr, monthStr, yearStr, importance);
				updateList();

			}

			private void checkAndAddTask(String name, String hoursStr, String dayStr, String monthStr, String yearStr,
					int importance) {
				int numHours = 0;
				int day = 0;
				int month = 0;
				int year = 0;
				try {
					numHours = Integer.parseInt(hoursStr);
					day = Integer.parseInt(dayStr);
					month = Integer.parseInt(monthStr);
					year = Integer.parseInt(yearStr);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("The strings cant be parsed", e);
				}
				if (numHours>0 && day>0 && day<=31 && year>=2020 && month>0 && month<=12) {
					tOrg.add(new Task(name, new GregorianCalendar(year, month-1, day), numHours, importance));
				}

			}
		});

	}

	public void updateList() {
		mdLsTasks.clear();
		for (Task s : tOrg) {
			mdLsTasks.addElement(s);
		}
		if (tOrg.size() > 0) {
			lbName.setText(tOrg.first().getName());
			lbDeadline.setText(tOrg.first().getDeadlineInString());
		}
	}

}
