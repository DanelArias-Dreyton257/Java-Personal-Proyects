package objects;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private GregorianCalendar deadline;
	private double completionRate;

	public Task(String name, GregorianCalendar deadline) {
		setName(name);
		setDeadline(deadline);
		setCompletionRate(0);
	}

	public Task(String name, int day, int month, int hour, int minute) {
		GregorianCalendar now = new GregorianCalendar();
		int year = now.get(Calendar.YEAR);
		if (now.get(Calendar.MONTH) < month - 1) {
			year++;
		}

		setName(name);
		setDeadline(new GregorianCalendar(year, month - 1, day, hour, minute));
		setCompletionRate(0);
	}
	
	public Task(String name, int day, int month, int hour) {
		this(name, month - 1, day, hour, 0);
	}

	public Task(String name, int day, int month) {
		this(name, day, month -1 , 0, 0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GregorianCalendar getDeadline() {
		return deadline;
	}

	public void setDeadline(GregorianCalendar deadline) {
		this.deadline = deadline;
	}

	public double getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate(double completionRate) {
		this.completionRate = completionRate;
	}

	@Override
	public String toString() {
		return name + " (" + getDeadLineString() + ") " + completionRate * 100 + "% done";
	}

	public String getDeadLineString() {
		int year = deadline.get(Calendar.YEAR);
		int month = deadline.get(Calendar.MONTH) + 1;
		int dayOfTheMonth = deadline.get(Calendar.DAY_OF_MONTH);
		int hour = deadline.get(Calendar.HOUR_OF_DAY);
		int minute = deadline.get(Calendar.MINUTE);
		String h = hour+"";
		String min = minute+"";
		if (hour<10) h = "0"+h;
		if (minute<10) min = "0"+min;
		return dayOfTheMonth + "/" + month + "/" + year + " - " + h + ":" + min;
	}

}
