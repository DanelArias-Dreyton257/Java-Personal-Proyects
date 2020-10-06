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
	private static int utilHoursInDay = 8;
	private String name;
	private boolean important = true;
	private GregorianCalendar deadline;
	private int expectedHoursLong;

	/**
	 * Creates a task
	 * 
	 * @param name              Name of the task
	 * @param deadline          Date when the task must be finished
	 * @param expectedHoursLong Expected hours that will be spent in doing that task
	 * @param important         boolean that indicates if the task is important
	 */
	public Task(String name, GregorianCalendar deadline, int expectedHoursLong, boolean important) {
		setName(name);
		setDeadline(deadline);
		setImportant(important);
		setExpectedHoursLong(expectedHoursLong);
	}

	/**
	 * Creates a task
	 * 
	 * @param name              Name of the task
	 * @param deadline          Date when the task must be finished
	 * @param expectedHoursLong Expected hours that will be spent in doing that task
	 *                          It is automatically set as important
	 */
	public Task(String name, GregorianCalendar deadline, int expectedHoursLong) {
		this(name, deadline, expectedHoursLong, true);
	}

	/**
	 * Creates a task
	 * 
	 * @param name      Name of the task
	 * @param deadline  Date when the task must be finished
	 * @param important boolean that indicates if the task is important The expected
	 *                  days are set as the number of days to reach the finish date
	 */
	public Task(String name, GregorianCalendar deadline, boolean important) {
		this(name, deadline,
				(int) (((deadline.getTimeInMillis() - new GregorianCalendar().getTimeInMillis()) / DAY_MILLIS)
						* utilHoursInDay),
				important);
	}

	/**
	 * Creates a task
	 * 
	 * @param name     Name of the task
	 * @param deadline Date when the task must be finished The expected days are set
	 *                 as the number of days to reach the finish date It is
	 *                 automatically set as important
	 */
	public Task(String name, GregorianCalendar deadline) {
		this(name, deadline, true);
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
	 * Returns if the task is important
	 * 
	 * @return boolean important
	 */
	public boolean isImportant() {
		return important;
	}

	/**
	 * Sets if the task is important
	 * 
	 * @param important
	 */
	public void setImportant(boolean important) {
		this.important = important;
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
	 * Returns true if the difference between the remaining days to the deadline and
	 * the expected daysLong is less or equal to 1
	 * 
	 * @return
	 */
	public boolean isUrgent() {
		return (getRemainingHours() - expectedHoursLong) <= utilHoursInDay;
	}

	/**
	 * Returns the number of days to the deadline
	 * 
	 * @return
	 */
	public int getRemainingHours() {
		long fD = deadline.getTimeInMillis();
		long now = new GregorianCalendar().getTimeInMillis();
		long sub = fD - now;
		int res = (int) ((sub / DAY_MILLIS) * utilHoursInDay);
		return res;
	}

	public int getRemainingDays() {
		return (int) (getRemainingHours() / utilHoursInDay);
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

	public String getStringForList() {
		String sIm = "Imp";
		if (!isImportant())
			sIm = "N-" + sIm;
		String sUr = "Urg";
		if (!isImportant())
			sUr = "N-" + sUr;
		return getName() + " [" + sUr + ", " + sIm + "] (" + expectedHoursLong + "hs.) " + getRemainingDays()
				+ "ds. to start" + " (" + getDeadlineInString() + ") ";
	}

	@Override
	public int compareTo(Task o) {
		double n1 = 0;
		double n2 = 0;
		double extra = 10000;
		if (this.isImportant())
			n1 += extra;
		if (o.isImportant())
			n2 += extra;
		return (int) ((getRemainingHours() - n1) - (o.getRemainingHours() - n2));
	}

	@Override
	public String toString() {
		String im = "IMPORTANT";
		if (!important)
			im = "NOT " + im;
		return name + ", " + im + ", (" + expectedHoursLong + "hs.) " + getRemainingHours() + " hours to start "
				+ ", Finish before: " + getDeadlineInString();
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

	public static int getUtilHoursInDay() {
		return utilHoursInDay;
	}

	public static void setUtilHoursInDay(int utilHoursInDay) {
		Task.utilHoursInDay = utilHoursInDay;
	}

}
