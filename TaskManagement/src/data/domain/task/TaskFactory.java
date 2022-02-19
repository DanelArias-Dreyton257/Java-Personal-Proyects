package data.domain.task;

import java.time.LocalDate;
import java.util.StringTokenizer;

import data.domain.enums.RepeatingPeriod;
import data.domain.enums.TaskType;

public class TaskFactory {
	private static TaskFactory instance;
	private static final String SEPARATOR = "#\t#";

	private TaskFactory() {
	}

	public static TaskFactory getInstance() {
		if (instance == null) {
			instance = new TaskFactory();
		}
		return instance;
	}
	/*
	public Task createTask(TaskType type, String... infos) {
		String str = "";
		for (String i: infos) {
			str+=i+SEPARATOR;
		}
		return createTask(type,str);
	}
	*/
	//TODO: make it throw an exception if the string does not meet the criteria for the factory
	public Task createTask(TaskType type, String info) {
		Task t = null;
		switch (type) {
		case APPOINTMENT:
			// structure: Aname + "#\t# + Adeadline + "#\t#" + Atime
			if (info != null && !info.trim().isEmpty()) {
				StringTokenizer tokenizer = new StringTokenizer(info, SEPARATOR);
				String name = tokenizer.nextToken();
				String deadlinestr = tokenizer.nextToken();
				String timestr = tokenizer.nextToken();
				
				LocalDate deadline = LocalDate.parse(deadlinestr);
				long time = Long.parseLong(timestr);
				
				t = new Appointment(name, deadline, time);
			}
			break;
		case DEADLINE:
			// structure: Dname + "#\t#" + Ddeadline + "#\t#" + Dduration
			if (info != null && !info.trim().isEmpty()) {
				StringTokenizer tokenizer = new StringTokenizer(info, SEPARATOR);
				String name = tokenizer.nextToken();
				String deadlinestr = tokenizer.nextToken();
				String durationstr = tokenizer.nextToken();
				
				LocalDate deadline = LocalDate.parse(deadlinestr);
				long duration = Long.parseLong(durationstr);
				
				t = new DeadlineTask(name, deadline, duration);
			}
			break;
		case PASSIVE:
			// structure: Pname + "#\t#" + Pduration
			if (info != null && !info.trim().isEmpty()) {
				StringTokenizer tokenizer = new StringTokenizer(info, SEPARATOR);
				String name = tokenizer.nextToken();
				
				String durationstr = tokenizer.nextToken();
				
				long duration = Long.parseLong(durationstr);
				
				t = new PassiveTask(name, duration);
			}
			break;
		case REPEATING_APPOINTMENT:
			// structure: RAname + "#\t#" + RAdeadline + "#\t#" + RAtime + "#\t#" + RAperiod
			if (info != null && !info.trim().isEmpty()) {
				StringTokenizer tokenizer = new StringTokenizer(info, SEPARATOR);
				String name = tokenizer.nextToken();
				String deadlinestr = tokenizer.nextToken();
				String timestr = tokenizer.nextToken();
				String periodstr = tokenizer.nextToken();
				
				LocalDate deadline = LocalDate.parse(deadlinestr);
				long time = Long.parseLong(timestr);
				RepeatingPeriod period = RepeatingPeriod.valueOf(periodstr);
				
				t = new RepeatingAppointment(name, deadline, time, period);
			}
			break;
		case REPEATING_DEADLINE:
			// structure: RDname + "#\t#" + RDdeadline + "#\t#" + RDduration + "#\t#" +
			if (info != null && !info.trim().isEmpty()) {
				StringTokenizer tokenizer = new StringTokenizer(info, SEPARATOR);
				String name = tokenizer.nextToken();
				String deadlinestr = tokenizer.nextToken();
				String durationstr = tokenizer.nextToken();
				String periodstr = tokenizer.nextToken();
				
				LocalDate deadline = LocalDate.parse(deadlinestr);
				long duration = Long.parseLong(durationstr);
				RepeatingPeriod period = RepeatingPeriod.valueOf(periodstr);
				
				t = new RepeatingDeadlineTask(name, deadline, duration, period);
			}
			
			break;
		default:
			break;
		}
		return t;
	}
}
