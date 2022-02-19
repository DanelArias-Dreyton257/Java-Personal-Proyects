package data.domain.interfaces;

import java.time.LocalDate;

public interface IDeadline {
	public void setDeadline(LocalDate d);
	public LocalDate getDeadline();
}
