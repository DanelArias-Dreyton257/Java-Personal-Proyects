package data.domain.task;

import java.time.LocalDate;

import data.domain.enums.TaskType;
import data.domain.interfaces.IDeadline;

public class Appointment extends Task implements IDeadline{
	
	protected LocalDate deadline;
	
	protected long time;
	
	public Appointment(String name, LocalDate deadline, long time) {
		setName(name);
		setDeadline(deadline);
		setTime(time);
		this.type = TaskType.APPOINTMENT;
	}
	public Appointment(String name, LocalDate deadline, int hours, int minutes, int seconds) {
		setName(name);
		setDeadline(deadline);
		setTime(hours,minutes,seconds);
		this.type = TaskType.APPOINTMENT;
	}
	
	@Override
	public void setDeadline(LocalDate d) {
		this.deadline = d;
	}

	@Override
	public LocalDate getDeadline() {
		return deadline;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public void setTime(int hours, int minutes, int seconds) {
		this.time = ((long)hours)*3600*1000 + ((long)minutes)*60*1000 + ((long)seconds)*1000;
	}
	@Override
	public String toString() {
		return type.toString()+" [name="+name+", deadline="+deadline+", time="+time+"]";
	}
}
