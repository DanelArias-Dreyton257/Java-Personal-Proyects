package objects;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Task implements Comparable<Task> {
	private final static long DAY_MILLIS = 86400000;
	private String name;
	private boolean important = true;
	private GregorianCalendar finishDate;
	private int expectedDaysLong;

	public Task(String name, GregorianCalendar finishDate, int expectedDaysLong, boolean important) {
		setName(name);
		setFinishDate(finishDate);
		setImportant(important);
		setExpectedDaysLong(expectedDaysLong);
	}

	public Task(String name, GregorianCalendar finishDate, int expectedDaysLong) {
		this(name, finishDate, expectedDaysLong, true);
	}

	public Task(String name, GregorianCalendar finishDate, boolean important) {
		this(name, finishDate,
				(int) ((finishDate.getTimeInMillis() - new GregorianCalendar().getTimeInMillis()) / DAY_MILLIS),
				important);
	}

	public Task(String name, GregorianCalendar finishDate) {
		this(name, finishDate, true);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public GregorianCalendar getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(GregorianCalendar finishDate) {
		this.finishDate = finishDate;
	}

	public int getExpectedDaysLong() {
		return expectedDaysLong;
	}

	public void setExpectedDaysLong(int numDaysLong) {
		this.expectedDaysLong = numDaysLong;
	}

	public boolean isUrgent() {
		return (getRemainingDays() - expectedDaysLong) <= 1;
	}

	public int getRemainingDays() {
		long fD = finishDate.getTimeInMillis();
		long now = new GregorianCalendar().getTimeInMillis();
		long sub = fD - now;
		int res = (int) (sub / DAY_MILLIS);
		return res;
	}

	@Override
	public int compareTo(Task o) {
		return getRemainingDays() - o.getRemainingDays();
	}

	@Override
	public String toString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		String date = sd.format(new java.util.Date(finishDate.getTimeInMillis()));
		return "Task [name=" + name + ", important=" + important + ", finishDate=" + date + ", daysRemaining="
				+ getRemainingDays() + "]";
	}

}
