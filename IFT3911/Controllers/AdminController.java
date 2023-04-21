package Controllers;

import java.util.List;

import DAOs.Trip.TripType;

import Models.TripModel.Company;
import Models.TripModel.ISectionType;
import Models.TripModel.Section;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;

public interface AdminController {

	/**
	 * 
	 * @param name
	 * @param city
	 */
	Terminal CreateTerminal(TripType tripType, String terminal_code, String name, String city);
	// Create an airport using factory and add it to the database

	/**
	 * 
	 * @param name
	 * @param updated_airport
	 */
	Terminal UpdateTerminal(TripType tripType, String terminal_code, Terminal updated_terminal);
	// Update the airport and return the old airport

	/**
	 * 
	 * @param name
	 */
	Terminal DeleteTerminal(TripType tripType, String terminal_code);
	// remove the airport from the database and return it

	/**
	 * 
	 * @param name
	 * @param prefix
	 */
	Company CreateCompany(TripType tripType, String name, String prefix);

	/**
	 * 
	 * @param id
	 * @param updated_airline
	 */
	Company UpdateCompany(TripType tripType, String name, Company updated_company);
	// return old

	/**
	 * 
	 * @param id
	 */
	Company DeleteCompany(TripType tripType, String name);
	// return old


	/**
	 * 
	 * @param company
	 */
	Trip CreateTrip(TripType tripType, String company_name, Double fullPrice);
	// Will be called when user clicks on "Create Plane Trip".
	// Simply creates a new plane trip with and airline and empty
	// travels and empty transport.
	// Also using factory

	/**
	 * 
	 * @param id
	 * @param updatedPlaneTrip
	 */
	Trip UpdateTrip(TripType tripType, String id, Trip updated_trip);
	// Will be called during creation of plane trip:
	// to add the travels and the sections to the plane trip.

	/**
	 * 
	 * @param id
	 */
	Trip DeleteTrip(TripType tripType, String id);
	// Remove plane trip from the database


    // Need new object CreateSectionArgs
	/**
	 * 
	 * @param rowCount
	 * @param sectionType
	 * @param layout
	 */
	Section CreateSection(TripType tripType, ISectionType sectionType, CreateSectionArgs createSectionArgs);
	// Will create section and all the seats in the section.
	// Seats are determined by the rowCount and the layout.
	// TODO: figure out a logic to assign seats numbers (A, B, C) (D, E, F, G)

	/**
	 * 
	 * @param id
	 * @param updatedPlaneSection
	 */
	Section UpdateSection(TripType tripType, String id, Section updated_section);

	/**
	 * 
	 * @param id
	 */
	Section DeleteSection(TripType tripType, String id);

	/**
	 * 
	 * @param origin_id
	 * @param destination_id
	 */
	List<Trip> GetTrips(TripType tripType, String origin_id, String destination_id);
	// using the plane trip manager, get all the plane trips and return those
	// that have the origin of origin_id and the destination of destination_id

	/**
	 * 
	 * @param company_id
	 */
	List<Trip> GetTrips(TripType tripType, String companyName);

	// THOMAS WILL DO, and the data mockup for those ones
	List<Terminal> GetTerminals(TripType tripType);

	List<Company> GetCompanies(TripType tripType);
}