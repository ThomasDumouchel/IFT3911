package Controllers;

import java.util.List;

import Models.PlaneTripModel.Airline;
import Models.PlaneTripModel.Airport;
import Models.PlaneTripModel.Plane;
import Models.PlaneTripModel.PlaneSection;
import Models.PlaneTripModel.PlaneSectionLayoutType;
import Models.PlaneTripModel.PlaneSectionType;
import Models.PlaneTripModel.PlaneTrip;

public interface AdminPlaneTripController {

	/**
	 * 
	 * @param name
	 * @param city
	 */
	Airport CreateAirport(String name, String city);

	/**
	 * 
	 * @param name
	 * @param updated_airport
	 */
	Airport UpdateAirport(String name, Airport updated_airport);

	/**
	 * 
	 * @param name
	 */
	Airport DeleteAirport(String name);

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

	/**
	 * 
	 * @param id
	 */
	Airline DeleteAirline(String id);

	/**
	 * 
	 * @param company
	 */
	PlaneTrip CreatePlaneTrip(Airline company);

	/**
	 * 
	 * @param id
	 * @param updatedPlaneTrip
	 */
	PlaneTrip UpdatePlaneTrip(String id, PlaneTrip updatedPlaneTrip);

	/**
	 * 
	 * @param id
	 */
	PlaneTrip DeletePlaneTrip(String id);

	/**
	 * 
	 * @param rowCount
	 * @param sectionType
	 * @param layout
	 */
	PlaneSection CreatePlaneSection(Integer rowCount, PlaneSectionType sectionType, PlaneSectionLayoutType layout);

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

	Plane createPlane();

	/**
	 * 
	 * @param origin_id
	 * @param destination_id
	 */
	List<PlaneTrip> GetPlaneTrips(String origin_id, String destination_id);

	/**
	 * 
	 * @param company_id
	 */
	List<PlaneTrip> GetPlaneTrips(String company_id);

}