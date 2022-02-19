package data.domain.enums;

public enum RepeatingPeriod {

	DAY(86400000),
	TWO_DAYS(2 * DAY.getDuration()),
	WEEK(7 * DAY.getDuration()),
	TWO_WEEKS(2 * WEEK.getDuration()),
	MONTH(30 * DAY.getDuration()),
	TWO_MONTHS(2 * MONTH.getDuration()),
	THREE_MONTHS(3 * MONTH.getDuration()),
	HALF_YEAR(6 * MONTH.getDuration()),
	YEAR(12 * MONTH.getDuration()),
	TWO_YEAR(2 * YEAR.getDuration());

	private long durationInMillis;

	private RepeatingPeriod(long durationInMillis) {
		this.durationInMillis = durationInMillis;
	}

	public long getDuration() {
		return this.durationInMillis;
	}

}
