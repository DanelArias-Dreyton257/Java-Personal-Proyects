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
	private boolean important = true;
	private GregorianCalendar deadline;
	private int expectedDaysLong;

	/**
	 * Creates a task
	 * 
	 * @param name             Name of the task
	 * @param deadline         Date when the task must be finished
	 * @param expectedDaysLong Expected days that will be spent in doing that task
	 * @param important        boolean that indicates if the task is important
	 */
	public Task(String name, GregorianCalendar deadline, int expectedDaysLong, boolean important) {
		setName(name);
		setDeadline(deadline);
		setImportant(important);
		setExpectedDaysLong(expectedDaysLong);
	}

	/**
	 * Creates a task
	 * 
	 * @param name             Name of the task
	 * @param deadline         Date when the task must be finished
	 * @param expectedDaysLong Expected days that will be spent in doing that task
	 *                         It is automatically set as important
	 */
	public Task(String name, GregorianCalendar deadline, int expectedDaysLong) {
		this(name, deadline, expectedDaysLong, true);
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
				(int) ((deadline.getTimeInMillis() - new GregorianCalendar().getTimeInMillis()) / DAY_MILLIS),
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
	 * Returns the number of expected days to finish the task
	 * 
	 * @return int expectedDaysLong
	 */
	public int getExpectedDaysLong() {
		return expectedDaysLong;
	}

	/**
	 * Sets the number of expected days to finish the task
	 * 
	 * @param numDaysLong
	 */
	public void setExpectedDaysLong(int numDaysLong) {
		this.expectedDaysLong = numDaysLong;
	}

	/**
	 * Returns true if the difference between the remaining days to the deadline and
	 * the expected daysLong is less or equal to 1
	 * 
	 * @return
	 */
	public boolean isUrgent() {
		return (getRemainingDays() - expectedDaysLong) <= 1;
	}

	/**
	 * Returns the number of days to the deadline
	 * 
	 * @return
	 */
	public int getRemainingDays() {
		long fD = deadline.getTimeInMillis();
		long now = new GregorianCalendar().getTimeInMillis();
		long sub = fD - now;
		int res = (int) (sub / DAY_MILLIS);
		return res;
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
		if (!isImportant()) sIm= "N-"+sIm;
		String sUr = "Urg";
		if (!isImportant()) sIm= "N-"+sUr;
		return getName()+"[ "+sUr+", "+sIm+ "] ("+getDeadlineInString()+") "+getRemainingDays()+ "ds. remaining";
	}

	@Override
	public int compareTo(Task o) {
		return getRemainingDays() - o.getRemainingDays();
	}

	@Override
	public String toString() {
		String im = "IMPORTANT";
		if (!important)
			im = "NOT " + im;
		return name + ", " + im + ", Finish before: " + getDeadlineInString() + ", " + getRemainingDays()
				+ " days remaining ";
	}

}
