package service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.HashMap;

import data.domain.User;
import data.domain.interfaces.IDeadline;
import data.domain.task.Task;

public class CalendarManager {
	
	private static CalendarManager instance;
	
	private CalendarManager() {
	}
	
	public static CalendarManager getInstance(){
		if ( instance == null ) {
			instance = new CalendarManager();
		}
		return instance;
	}
	
	public void orgTime(User u, LocalDate date, long init, long end) {
		long aviableTime = end - init;
		LocalDate today = LocalDate.now();
		HashMap<IDeadline, Long> tiempoRestante = new HashMap<>();
		
		//Calcular el tiempo restante para cada tarea
		for (Task t : u.getTasks()) {
			if (t instanceof IDeadline) {
				IDeadline d = (IDeadline) t;
				//calcular tiempo restante
				long diff = d.getDeadline().getLong(ChronoField.EPOCH_DAY) - today.getLong(ChronoField.EPOCH_DAY);
				tiempoRestante.put(d, diff);
			}
		}
		
		//TODO
		
	}
	
	

}
