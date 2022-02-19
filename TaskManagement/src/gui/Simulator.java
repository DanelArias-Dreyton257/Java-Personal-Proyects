package gui;

import controller.Controller;
import data.domain.enums.TaskType;

public class Simulator {

	public static void simulate() {
		// Programa de prueba
		A01ValueTest();
	}

	private static void A01ValueTest() {
		// Coger los datos de la "ventana"
		String email = "danel.prueba2@gmail.com";
		// Llamada al controller
		Controller.getInstance().login(email);

		// Coger los datos de la "ventana"
		String Dname = "Formateo";
		String Ddeadline = "2022-02-18";
		long Dduration = 1000 * 3600 * 10;

		// Llamada al controller
		Controller.getInstance().createTask(email, TaskType.DEADLINE, Dname + "#\t#" + Ddeadline + "#\t#" + Dduration);

		// Coger los datos de la "ventana"
		String Dname1 = "Caps 1,2,3,4  GPS";
		String Ddeadline1 = "2022-02-22";
		long Dduration1 = 1000 * 3600 * 2;

		// Llamada al controller
		Controller.getInstance().createTask(email, TaskType.DEADLINE, Dname1 + "#\t#" + Ddeadline1 + "#\t#" + Dduration1);
		
		//TODO
	}

	private static void A00TaskCreateTest() {
		// 1-Crear un usuario

		// Coger los datos de la "ventana"
		String email = "danel.prueba@gmail.com";
		// Llamada al controller
		Controller.getInstance().login(email);

		// 2-Crear diferentes tareas

		// Coger los datos de la "ventana"
		String Aname = "Appointment";
		String Adeadline = "2022-02-17";
		long Atime = 0;

		// Llamada al controller
		Controller.getInstance().createTask(email, TaskType.APPOINTMENT, Aname + "#\t#" + Adeadline + "#\t#" + Atime);

		// Coger los datos de la "ventana"
		String Dname = "Deadline";
		String Ddeadline = "2022-02-17";
		long Dduration = 1000 * 3600 * 4;

		// Llamada al controller
		Controller.getInstance().createTask(email, TaskType.DEADLINE, Dname + "#\t#" + Ddeadline + "#\t#" + Dduration);

		// Coger los datos de la "ventana"
		String Pname = "Passive";
		long Pduration = 1000 * 3600 * 4;

		// Llamada al controller
		Controller.getInstance().createTask(email, TaskType.PASSIVE, Pname + "#\t#" + Pduration);

		// Coger los datos de la "ventana"
		String RAname = "RepeatingAppointment";
		String RAdeadline = "2022-02-17";
		long RAtime = 0;
		String RAperiod = "DAY";

		// Llamada al controller
		Controller.getInstance().createTask(email, TaskType.REPEATING_APPOINTMENT,
				RAname + "#\t#" + RAdeadline + "#\t#" + RAtime + "#\t#" + RAperiod);

		// Coger los datos de la "ventana"
		String RDname = "RepeatingAppointment";
		String RDdeadline = "2022-02-17";
		long RDduration = 1000 * 3600 * 4;
		String RDperiod = "DAY";

		// Llamada al controller
		Controller.getInstance().createTask(email, TaskType.REPEATING_DEADLINE,
				RDname + "#\t#" + RDdeadline + "#\t#" + RDduration + "#\t#" + RDperiod);

		// 3-Interacciones con las tareas

		// 4-Almacenar las tareas del usuario
	}

}
