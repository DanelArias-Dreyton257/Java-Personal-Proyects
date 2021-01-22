package objects;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * 
 * @author danel
 *
 */
public class Task implements Comparable<Task> {

	private final static long DAY_MILLIS = 86400000;
	private String name;
	private int importance = 0;
	private GregorianCalendar deadline;
	private int expectedHoursLong;

	/**
	 * Creates a task
	 * 
	 * @param name              Name of the task
	 * @param deadline          Date when the task must be finished
	 * @param expectedHoursLong Expected hours that will be spent in doing that task
	 * @param importance        importance rating between 0 and 10
	 */
	public Task(String name, GregorianCalendar deadline, int expectedHoursLong, int importance) {
		setName(name);
		setDeadline(deadline);
		setImportance(importance);
		setExpectedHoursLong(expectedHoursLong);
	}

	/**
	 * Returns the name of the task
	 * 
	 * @return String name
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
	 */
	public GregorianCalendar getDeadline() {
		return deadline;
	}

	/**
	 * Sets the GregorianCalendar deadline
	 * 
	 * @param deadline
	 */
	public void setDeadline(GregorianCalendar deadline) {
		this.deadline = deadline;
	}

	/**
	 * Returns the number of expected hours to finish the task
	 * 
	 * @return int expectedHoursLong
	 */
	public int getExpectedHoursLong() {
		return expectedHoursLong;
	}

	/**
	 * Sets the number of expected hours to finish the task
	 * 
	 * @param numHoursLong
	 */
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
	}

	@Override
	public String toString() {
		//TODO
		return super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		Task o = null;
		if (obj instanceof Task) {
			o = (Task) obj;
			return this.name.equals(o.getName()) && this.deadline.equals(o.getDeadline());
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() - this.deadline.hashCode();
	}

}
