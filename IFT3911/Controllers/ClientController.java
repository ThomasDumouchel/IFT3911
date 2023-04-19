package Controllers;

import Models.PlaneTripModel.PlaneReservationOption;
import Models.TripModel.Client;
import Models.TripModel.Reservable;

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
	Reservable ReservePlaneTrip(String planeTripId, String planeClass, PlaneReservationOption option, Client client);

	/**
	 * 
	 * @param trainId
	 * @param trainClass
	 * @param option
	 * @param client
	 */
	Reserved ReserveTrainTrip(String trainId, String trainClass, TrainReservationOption option, Client client);

	/**
	 * 
	 * @param cruiseId
	 * @param cruiseSection
	 * @param option
	 * @param client
	 */
	Reserved ReserveCruiseTrip(String cruiseId, String cruiseSection, CruiseReservationOption option, Client client);

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