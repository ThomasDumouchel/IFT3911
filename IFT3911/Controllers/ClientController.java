package Controllers;


import java.sql.Date;
import java.util.List;

import DAOs.Trip.TripType;
import Models.Payment.PaymentInfo;

import Models.TripModel.Client;
import Models.TripModel.ISectionType;
import Models.TripModel.Reservable;
import Models.TripModel.ReservationOption;
import Models.TripModel.Trip;

public interface ClientController {

	/**
	 * 
	 * @param reservationId
	 * @param paymentInfo
	 * @param client
	 */
	Reservable Confirm(String reservationId, PaymentInfo paymentInfo, Client client);

	/**
	 * @param tripType
	 * @param planeTripId
	 * @param planeClass
	 * @param option
	 */
	Reservable ReserveTrip(TripType tripType, String tripId, ISectionType sectionType, ReservationOption option);

	/**
	 * 
	 * @param originAirportId
	 * @param destAirportId
	 * @param date
	 * @param planeClass
	 */
	List<Trip> GetTrips(TripType tripType, String originId, String destinationId, Date date, ISectionType sectionType);
	// Note... for the TripType.CRUISE, destinationId is going to be null


}