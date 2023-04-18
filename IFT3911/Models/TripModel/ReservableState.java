package Models.TripModel;
public interface ReservableState {

	public Boolean isAvailable();

	/**
	 * 
	 * @param client
	 */
	public Reservable book();

}