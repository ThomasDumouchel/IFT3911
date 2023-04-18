package Models.TripModel;

import java.util.Date;

public class Reserved implements ReservableState {

	Reservable context;
	private Date expirationDate;

	public Reserved(Reservable context) {
		this.context = context;
		// Set the expiration date to 24 hours from now
		expirationDate = new Date();
		expirationDate.setTime(expirationDate.getTime() + 24 * 60 * 60 * 1000);
	}

	@Override
	public Boolean isAvailable() {
		// If it has been more than 24 hours since the reservation 
		// was made, the reservation is no longer valid
		Date now = new Date();
		if (now.after(expirationDate)) {
			context.changeState(new Available(context));
			return true;
		}
		return false;
	}
	@Override
	public Reservable book() {
		// Calling book on a reserved should move the reservation to confirmed,
		// only if the reservation is not expired
		if (isAvailable()) {
			context.changeState(new Confirmed(context));
			return context;
		}
		return null;
	}



}