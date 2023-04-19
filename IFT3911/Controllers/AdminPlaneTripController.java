package Controllers;

import java.util.List;

import Models.PlaneTripModel.Airline;
import Models.PlaneTripModel.Airport;
import Models.PlaneTripModel.Plane;
import Models.PlaneTripModel.PlaneSection;
import Models.PlaneTripModel.PlaneSectionLayoutType;
import Models.PlaneTripModel.PlaneSectionType;
import Models.PlaneTripModel.PlaneTrip;
import Models.TripModel.Company;

public interface AdminPlaneTripController {

	/**
	 * 
	 * @param name
	 * @param city
	 */
	Airport CreateAirport(String name, String city);
	// Create an airport using factory and add it to the database

	/**
	 * 
	 * @param name
	 * @param updated_airport
	 */
	Airport UpdateAirport(String name, Airport updated_airport);
	// Update the airport and return the old airport

	/**
	 * 
	 * @param name
	 */
	Airport DeleteAirport(String name);
	// remove the airport from the database and return it

	/**
	 * 
	 * @param name
	 * @param prefix
	 */
	Airline CreateAirline(String name, String prefix);

	/**
	 * 
	 * @param id
	 * @param updated_airline
	 */
	Airline UpdateAirline(String id, Airline updated_airline);
	// return old

	/**
	 * 
	 * @param id
	 */
	Airline DeleteAirline(String id);
	// return old


	/**
	 * 
	 * @param company
	 */
	PlaneTrip CreatePlaneTrip(Airline company);
	// Will be called when user clicks on "Create Plane Trip".
	// Simply creates a new plane trip with and airline and empty
	// travels and empty transport.
	// Also using factory

	/**
	 * 
	 * @param id
	 * @param updatedPlaneTrip
	 */
	PlaneTrip UpdatePlaneTrip(String id, PlaneTrip updatedPlaneTrip);
	// Will be called during creation of plane trip:
	// to add the travels and the sections to the plane trip.

	/**
	 * 
	 * @param id
	 */
	PlaneTrip DeletePlaneTrip(String id);
	// Remove plane trip from the database

	/**
	 * 
	 * @param rowCount
	 * @param sectionType
	 * @param layout
	 */
	PlaneSection CreatePlaneSection(Integer rowCount, PlaneSectionType sectionType, PlaneSectionLayoutType layout);
	// Will create section and all the seats in the section.
	// Seats are determined by the rowCount and the layout.
	// TODO: figure out a logic to assign seats numbers (A, B, C) (D, E, F, G)

	/**
	 * 
	 * @param id
	 * @param updatedPlaneSection
	 */
	PlaneSection UpdatePlaneSection(String id, PlaneSection updatedPlaneSection);

	/**
	 * 
	 * @param id
	 */
	PlaneSection DeletePlaneSection(String id);

	/**
	 * 
	 * @param origin_id
	 * @param destination_id
	 */
	List<PlaneTrip> GetPlaneTrips(String origin_id, String destination_id);
	// using the plane trip manager, get all the plane trips and return those
	// that have the origin of origin_id and the destination of destination_id

	/**
	 * 
	 * @param company_id
	 */
	List<PlaneTrip> GetPlaneTrips(String companyName);

	// THOMAS WILL DO, and the data mockup for those ones
	List<Airport> GetAirports();

	List<Company> GetCompanies();
}