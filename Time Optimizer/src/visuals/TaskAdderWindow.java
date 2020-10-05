package visuals;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TaskAdderWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 300;
	
	private JPanel pnCentro = new JPanel();
	
	public TaskAdderWindow() {

		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		
		getContentPane().add(pnCentro,BorderLayout.CENTER);

	}
}
