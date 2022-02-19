package data.domain.task;

import data.domain.enums.TaskType;

public abstract class Task {
	protected String name;
	protected TaskType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskType getType() {
		return type;
	}

	@Override
	public abstract String toString();
	
	
}
