package Models.TripModel;

import java.util.Date;

public class Travel<T extends Terminal> {

	private Terminal to;
	private Terminal from;
	private Date departureTime;
	private Date arrivalTime;

	public Travel(Terminal to, Terminal from, Date departureTime, Date arrivalTime) {
		this.to = to;
		this.from = from;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	// Make getters
	public Terminal getTo() {
		return to;
	}

	public Terminal getFrom() {
		return from;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}
	


}