package Controllers;

public interface ClientController {

	/**
	 * 
	 * @param reservationId
	 * @param paymentInfo
	 * @param client
	 */
	ControllerResponse<Confirmation> Confirm(String reservationId, PaymentInfo paymentInfo, Client client);

	/**
	 * 
	 * @param planeTripId
	 * @param planeClass
	 * @param option
	 * @param client
	 */
	Reservation ReservePlaneTrip(String planeTripId, String planeClass, PlaneReserveOption option, Client client);

	/**
	 * 
	 * @param trainId
	 * @param trainClass
	 * @param option
	 * @param client
	 */
	Reserved ReserveTrainTrip(String trainId, String trainClass, TrainReserveOption option, Client client);

	/**
	 * 
	 * @param cruiseId
	 * @param cruiseSection
	 * @param option
	 * @param client
	 */
	Reserved ReserveCruiseTrip(String cruiseId, String cruiseSection, CruiseReserveOption option, Client client);

	/**
	 * 
	 * @param originAirportId
	 * @param destAirportId
	 * @param date
	 * @param planeClass
	 */
	List<PlaneTrip> GetPlaneTrips(String originAirportId, String destAirportId, Date date, PlaneClasses planeClass);

	/**
	 * 
	 * @param originTrainStationId
	 * @param destTrainStationId
	 * @param date
	 * @param trainClass
	 */
	List<TrainTrip> GetTrainTrips(String originTrainStationId, String destTrainStationId, Date date, TrainTrip.TrainClasses trainClass);

	/**
	 * 
	 * @param originPortId
	 * @param date
	 * @param cruiseClass
	 */
	List<CruiseTrip> GetCruiseTrips(String originPortId, Date date, CruiseClasses cruiseClass);

}