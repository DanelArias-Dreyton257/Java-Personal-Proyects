package data.domain.interfaces;

import data.domain.enums.RepeatingPeriod;

public interface IRepeteable {
	public void setRepetingPeriod(RepeatingPeriod d);
	public RepeatingPeriod getRepetingPeriod(RepeatingPeriod d);
}
