package data.domain.task;

import java.time.LocalDate;

import data.domain.enums.TaskType;
import data.domain.interfaces.IDeadline;
import data.domain.interfaces.IDuration;

public class DeadlineTask extends Task implements IDeadline, IDuration {

	protected LocalDate deadline;
	
	protected long duration;
	
	public DeadlineTask(String name, LocalDate deadline, long duration) {
		setName(name);
		setDeadline(deadline);
		setDuration(duration);
		this.type = TaskType.DEADLINE;
	}

	@Override
	public long getDuration() {
		return duration;
	}

	@Override
	public void setDuration(long duration) {
		this.duration = duration;
	}

	@Override
	public void setDeadline(LocalDate d) {
		this.deadline = d;
	}

	@Override
	public LocalDate getDeadline() {
		return deadline;
	}
	
	@Override
	public String toString() {
		return type.toString()+" [name="+name+", deadline="+deadline+", duration="+duration+"]";
	}
}
