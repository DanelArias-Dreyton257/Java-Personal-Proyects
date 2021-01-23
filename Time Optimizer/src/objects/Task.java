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

<<<<<<< HEAD
	private final static long DAY_MILLIS = 86400000;
=======
	private static final long serialVersionUID = 1L;

>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
	private String name;
<<<<<<< HEAD
	private int importance = 0;
=======
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
	private GregorianCalendar deadline;
	private double completionRate;
	private double expectedHoursLong;

	/**
	 * Constructor of a task where the deadline is already defined in a
	 * gregorianCalendar object
	 * 
<<<<<<< HEAD
	 * @param name              Name of the task
	 * @param deadline          Date when the task must be finished
	 * @param expectedHoursLong Expected hours that will be spent in doing that task
	 * @param importance        importance rating between 0 and 10
=======
	 * @param name
	 * @param deadline
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
	 */
<<<<<<< HEAD
	public Task(String name, GregorianCalendar deadline, int expectedHoursLong, int importance) {
=======
	public Task(String name, double expectedHoursLong, GregorianCalendar deadline) {
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
		setName(name);
<<<<<<< HEAD
		setDeadline(deadline);
		setImportance(importance);
=======
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
		setExpectedHoursLong(expectedHoursLong);
		setDeadline(deadline);
		setCompletionRate(0);
	}

	/**
<<<<<<< HEAD
	 * Returns the name of the task
	 * 
	 * @return String name
=======
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
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
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

<<<<<<< HEAD
	/**
	 * Returns the task importance rating
	 * 
	 * @return int importance
	 */
	public int getImportance() {
		return importance;
	}

	/**
	 * Sets the task's importance rating
	 * 
	 * @param importance
	 */
	public void setImportance(int importance) {
		this.importance = importance;
	}

	/**
	 * Returns the GregorianCalendar with the deadline
	 * 
	 * @return GregorianCalendar deadline
=======
	/*
	 * @return deadline of the task represented by a GregorianCalendar
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
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
<<<<<<< HEAD
	public void setExpectedHoursLong(int numHoursLong) {
		this.expectedHoursLong = numHoursLong;
	}

	/**
	 * Returns the deadline in a String of format "dd/MM/yyyy"
	 * 
	 * @return
	 */
	public String getDeadlineInString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		return sd.format(new java.util.Date(deadline.getTimeInMillis()));
	}

	@Override
	public int compareTo(Task o) {
		return (int) ((o.getCalculatedValue()*100) - (this.getCalculatedValue()*100));
	}

	private double getCalculatedValue() {
		return (getHoursPerDay() * importance) / 10;
	}
	
	private long getRemainingDays() {
		long remainingMillis = deadline.getTimeInMillis() - new GregorianCalendar().getTimeInMillis();
		return Math.floorDiv(remainingMillis, DAY_MILLIS );
	}
	private double getHoursPerDay() {
		return expectedHoursLong / getRemainingDays();
=======
	public void setCompletionRate(double completionRate) throws IllegalArgumentException {
		if (completionRate >= 0 && completionRate <= 1) {
			this.completionRate = completionRate;
		} else
			throw new IllegalArgumentException("The completionRate must be between 0 and 1, both inclusive");
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		//TODO
		return super.toString();
=======
		return name + " (" + getDeadlineString() + ") " + completionRate * 100 + "% done";
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
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
<<<<<<< HEAD
			return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() - this.deadline.hashCode();
=======
			throw new IllegalArgumentException("The expectedHoursLong must be greater than 0");
>>>>>>> branch 'master' of https://github.com/DanelArias-Dreyton257/Personal-Proyects
	}

}
