package visuals;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import objects.Task;
import objects.TaskOrganizer;
import objects.User;

public class TaskWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private TaskOrganizer organizer;
	
	private DefaultListModel<String> mdTasks = new DefaultListModel<>();
	private JList<String> lsTasks = new JList<String>();
	
	private JLabel lbUser = new JLabel();
	
	private JPanel pnCentral = new JPanel();

	public TaskWindow(User user) {
		
		setOrganizer(user.getTasks());
		lbUser.setText(user.getName() + " works "+user.getWorkingHoursDay()+" h a day");

		setSize(400,400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

<<<<<<< HEAD
//		Task t1 = new Task("Ejs BD", new GregorianCalendar(2020, 9, 7),2, true);
//		Task t2 = new Task("Hacer Sostenibilidad", new GregorianCalendar(2020, 9, 7), 2, false);
//		Task t3 = new Task("Proyecto prog", new GregorianCalendar(2021, 0, 01), true);
//		Task t4 = new Task("Hacer Trello Prog", new GregorianCalendar(2020, 9, 8), 2, false);
//		Task t5 = new Task("Telematics time management", new GregorianCalendar(2020, 9, 12), 4, true);
//		tOrg.addAll(t1, t2, t3, t4, t5);

		System.out.println(tOrg);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);

		getContentPane().add(pnLista, BorderLayout.CENTER);
		pnLista.add(new JScrollPane(lsTasks));
		lsTasks.setModel(mdLsTasks);
=======
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Test");
		
		lsTasks.setModel(mdTasks);
		getContentPane().add(pnCentral,BorderLayout.CENTER);
		getContentPane().add(lbUser,BorderLayout.NORTH);
		pnCentral.add(new JScrollPane(lsTasks));
		
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
		updateList();
	}
	
	public void updateList() {
		mdTasks.clear();
		for (Task t:organizer) {
			mdTasks.addElement(t.toString());
		}
	}

	public TaskOrganizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(TaskOrganizer organizer) {
		this.organizer = organizer;
	}

}
