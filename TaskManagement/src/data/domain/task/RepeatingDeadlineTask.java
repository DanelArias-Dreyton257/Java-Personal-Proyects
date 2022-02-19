package data.domain.task;

import java.time.LocalDate;

import data.domain.enums.RepeatingPeriod;
import data.domain.enums.TaskType;
import data.domain.interfaces.IRepeteable;

public class RepeatingDeadlineTask extends DeadlineTask implements IRepeteable {
	
	private RepeatingPeriod period;
	
	public RepeatingDeadlineTask(String name, LocalDate deadline, long duration, RepeatingPeriod period) {
		super(name,deadline,duration);
		setRepetingPeriod(period);
		this.type = TaskType.REPEATING_DEADLINE;
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
		return type.toString()+" [name="+name+", deadline="+deadline+", duration="+duration+", "+period+"]";
	}

}
