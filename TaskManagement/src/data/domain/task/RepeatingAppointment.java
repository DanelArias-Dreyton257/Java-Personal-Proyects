package data.domain.task;

import java.time.LocalDate;

import data.domain.enums.RepeatingPeriod;
import data.domain.enums.TaskType;
import data.domain.interfaces.IRepeteable;

public class RepeatingAppointment extends Appointment implements IRepeteable {
	private RepeatingPeriod period;

	public RepeatingAppointment(String name, LocalDate deadline, long time, RepeatingPeriod period) {
		super(name, deadline, time);
		setRepetingPeriod(period);
		this.type = TaskType.REPEATING_APPOINTMENT;
	}

	public RepeatingAppointment(String name, LocalDate deadline, int hours, int minutes, int seconds,
			RepeatingPeriod period) {
		super(name, deadline, hours, minutes, seconds);
		setRepetingPeriod(period);
		this.type = TaskType.REPEATING_APPOINTMENT;
	}

	@Override
	public void setRepetingPeriod(RepeatingPeriod d) {
		this.period = d;
	}

	@Override
	public RepeatingPeriod getRepetingPeriod(RepeatingPeriod d) {
		return period;
	}
	
	@Override
	public String toString() {
		return type.toString()+" [name="+name+", deadline="+deadline+", time="+time+", "+period+"]";
	}
}
