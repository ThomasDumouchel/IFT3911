package Models.TripModel;

import java.util.Date;

public class Travel<T extends Terminal> {

	private T to;
	private T from;
	private Date departureTime;
	private Date arrivalTime;

	public Travel(T to, T from, Date departureTime, Date arrivalTime) {
		this.to = to;
		this.from = from;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	// Make getters
	public T getTo() {
		return to;
	}

	public T getFrom() {
		return from;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}
	


}