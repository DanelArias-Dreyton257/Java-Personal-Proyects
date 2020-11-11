package visuals;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import objects.Task;
import objects.TaskOrganizer;

public class TaskWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private TaskOrganizer organizer;
	
	private DefaultListModel<String> mdTasks = new DefaultListModel<>();
	private JList<String> lsTasks = new JList<String>();

	public TaskWindow(TaskOrganizer organizer) {
		setOrganizer(organizer);

		setSize(400,400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Test");
		
		lsTasks.setModel(mdTasks);
		getContentPane().add(new JScrollPane(lsTasks));
		
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
