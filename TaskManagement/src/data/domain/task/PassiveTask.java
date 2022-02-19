package data.domain.task;

import data.domain.enums.TaskType;
import data.domain.interfaces.IDuration;

public class PassiveTask extends Task implements IDuration {
	
	private long duration;
	
	public PassiveTask(String name, long duration) {
		setName(name);
		setDuration(duration);
		this.type = TaskType.PASSIVE;
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
	public String toString() {
		return type.toString()+" [name="+name+", duration="+duration+"]";
	}

}
