package objects;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author danel
 *
 */
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private GregorianCalendar deadline;
	private double completionRate;
	private double expectedHoursLong;

	/**
	 * Constructor of a task where the deadline is already defined in a
	 * gregorianCalendar object
	 * 
	 * @param name
	 * @param deadline
	 */
	public Task(String name, double expectedHoursLong, GregorianCalendar deadline) {
		setName(name);
		setExpectedHoursLong(expectedHoursLong);
		setDeadline(deadline);
		setCompletionRate(0);
	}

	/**
	 * Constructor of a task that receives the day, month, hour and minute of the
	 * deadline as parameters. The year is automatically selected considering the
	 * deadline is a date in the future.
	 * 
	 * @param name
	 * @param day    day of the month
	 * @param month  number of month of the year e.g. January -> 1 and December ->
	 *               12
	 * @param hour   hour of the day in a 24 h format
	 * @param minute minute of the hour, between 0 and 60
	 */
	public Task(String name, double expectedHoursLong, int day, int month, int hour, int minute) {
		GregorianCalendar now = new GregorianCalendar();
		int year = now.get(Calendar.YEAR);
		if (now.get(Calendar.MONTH) > month - 1
				|| (now.get(Calendar.MONTH) == month - 1 && now.get(Calendar.DAY_OF_MONTH) > day)) {
			year++;
		}

		setName(name);
		setExpectedHoursLong(expectedHoursLong);
		setDeadline(new GregorianCalendar(year, month - 1, day, hour, minute));
		setCompletionRate(0);
	}

	/**
	 * Constructor of a task that receives the day, month and hour of the deadline
	 * as parameters. The minutes are set to 0, e.g. 10 -> 10:00. The year is
	 * automatically selected considering the deadline is a date in the future.
	 * 
	 * @param name
	 * @param day   day of the month
	 * @param month number of month of the year e.g. January -> 1 and December -> 12
	 * @param hour  hour of the day in a 24 h format
	 */
	public Task(String name, double expectedHoursLong, int day, int month, int hour) {
		this(name, expectedHoursLong, day, month, hour, 0);
	}

	/**
	 * Constructor of a task that receives the day and month of the deadline as
	 * parameters. The hour and minutes are set to 0. The year is automatically
	 * selected considering the deadline is a date in the future.
	 * 
	 * @param name
	 * @param day   day of the month
	 * @param month number of month of the year e.g. January -> 1 and December -> 12
	 */
	public Task(String name, double expectedHoursLong, int day, int month) {
		this(name, expectedHoursLong, day, month, 0, 0);
	}

	/**
	 * @return name of the task
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the task
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @return deadline of the task represented by a GregorianCalendar
	 */
	public GregorianCalendar getDeadline() {
		return deadline;
	}

	/**
	 * Sets the deadline of the task represented by a GregorianCalendar
	 * 
	 * @param deadline
	 */
	public void setDeadline(GregorianCalendar deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return the completion rate of the task between 0 and 1, where 0 is nothing
	 *         done and 1 is completely done
	 */
	public double getCompletionRate() {
		return completionRate;
	}

	/**
	 * Sets the completion rate of the task between 0 and 1, where 0 is nothing done
	 * and 1 is completely done
	 * 
	 * @param completionRate
	 * @throws IllegalArgumentException
	 */
	public void setCompletionRate(double completionRate) throws IllegalArgumentException {
		if (completionRate >= 0 && completionRate <= 1) {
			this.completionRate = completionRate;
		} else
			throw new IllegalArgumentException("The completionRate must be between 0 and 1, both inclusive");
	}

	@Override
	public String toString() {
		return name + " (" + getDeadlineString() + ") " + completionRate * 100 + "% done";
	}

	/**
	 * @return A string representing the deadline in the format "DD/MM/YYYY - HH:mm"
	 */
	public String getDeadlineString() {
		int year = deadline.get(Calendar.YEAR);
		int month = deadline.get(Calendar.MONTH) + 1;
		int dayOfTheMonth = deadline.get(Calendar.DAY_OF_MONTH);
		int hour = deadline.get(Calendar.HOUR_OF_DAY);
		int minute = deadline.get(Calendar.MINUTE);
		return Utils.digitFormatter(dayOfTheMonth, 2) + "/" + Utils.digitFormatter(month, 2) + "/"
				+ Utils.digitFormatter(year, 4) + " - " + Utils.digitFormatter(hour, 2) + ":"
				+ Utils.digitFormatter(minute, 2);
	}

	public double getExpectedHoursLong() {
		return expectedHoursLong;
	}

	public void setExpectedHoursLong(double expectedHoursLong) {
		if (expectedHoursLong > 0) {
			this.expectedHoursLong = expectedHoursLong;
		} else
			throw new IllegalArgumentException("The expectedHoursLong must be greater than 0");
	}

}
