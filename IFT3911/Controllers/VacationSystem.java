package Controllers;

import java.util.List;

import DAOs.Trip.TripType;
import Managers.TripManager;
import Models.TripModel.Company;
import Models.TripModel.Section;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;

public class VacationSystem implements AdminController {

	private TripManager tripManager;

	public VacationSystem(TripManager tripManager) {
		this.tripManager = tripManager;
	}

	@Override
	public Terminal CreateTerminal(TripType tripType, String terminal_code, String name, String city) {
		return this.tripManager.createTerminal(tripType, terminal_code, name, city);
	}

	@Override
	public Terminal UpdateTerminal(TripType tripType, String terminal_code, Terminal updated_terminal) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'UpdateTerminal'");
	}

	@Override
	public Terminal DeleteTerminal(TripType tripType, String terminal_code) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'DeleteTerminal'");
	}

	@Override
	public Company CreateCompany(TripType tripType, String name, String prefix) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'CreateCompany'");
	}

	@Override
	public Company UpdateCompany(TripType tripType, String name, Company updated_company) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'UpdateCompany'");
	}

	@Override
	public Company DeleteCompany(TripType tripType, String name) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'DeleteCompany'");
	}

	@Override
	public Trip CreateTrip(TripType tripType, Company company) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'CreateTrip'");
	}

	@Override
	public Trip UpdateTrip(TripType tripType, String id, Trip updated_trip) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'UpdateTrip'");
	}

	@Override
	public Trip DeleteTrip(TripType tripType, String id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'DeleteTrip'");
	}

	@Override
	public Section CreateSection(TripType tripType, CreateSectionArgs createSectionArgs) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'CreateSection'");
	}

	@Override
	public Section UpdateSection(TripType tripType, String id, Section updated_section) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'UpdateSection'");
	}

	@Override
	public Section DeleteSection(TripType tripType, String id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'DeleteSection'");
	}

	@Override
	public List<Trip> GetTrips(TripType tripType, String origin_id, String destination_id) {
		return this.tripManager.getTrips(tripType, origin_id, destination_id);
	}

	@Override
	public List<Trip> GetTrips(TripType tripType, String companyId) {
		return this.tripManager.getTrips(tripType, companyId);
	}

	@Override
	public List<Terminal> GetTerminals(TripType tripType) {
		return this.tripManager.getTerminals(tripType);
	}

	@Override
	public List<Company> GetCompanies(TripType tripType) {
		return this.tripManager.getCompanies(tripType);
	}

	// @Override
	// public Airport CreateAirport(String name, String city) {
	// 	return planeTripManager.createAirport(name, city);
	// }

	// @Override
	// public Airport UpdateAirport(String name, Airport updated_airport) {
	// 	return planeTripManager.UpdateAirport(name, updated_airport);
	// }

	// @Override
	// public Airport DeleteAirport(String name) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'DeleteAirport'");
	// }

	// @Override
	// public Airline CreateAirline(String name, String prefix) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'CreateAirline'");
	// }

	// @Override
	// public Airline UpdateAirline(String id, Airline updated_airline) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'UpdateAirline'");
	// }

	// @Override
	// public Airline DeleteAirline(String id) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'DeleteAirline'");
	// }

	// @Override
	// public PlaneTrip CreatePlaneTrip(Airline company) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'CreatePlaneTrip'");
	// }

	// @Override
	// public PlaneTrip UpdatePlaneTrip(String id, PlaneTrip updatedPlaneTrip) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'UpdatePlaneTrip'");
	// }

	// @Override
	// public PlaneTrip DeletePlaneTrip(String id) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'DeletePlaneTrip'");
	// }

	// @Override
	// public PlaneSection CreatePlaneSection(Integer rowCount, PlaneSectionType sectionType,
	// 		PlaneSectionLayoutType layout) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'CreatePlaneSection'");
	// }

	// @Override
	// public PlaneSection UpdatePlaneSection(String id, PlaneSection updatedPlaneSection) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'UpdatePlaneSection'");
	// }

	// @Override
	// public PlaneSection DeletePlaneSection(String id) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'DeletePlaneSection'");
	// }


	// @Override
	// public List<PlaneTrip> GetPlaneTrips(String origin_id, String destination_id) {
	// 	TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'GetPlaneTrips'");
	// }

	// @Override
	// public List<PlaneTrip> GetPlaneTrips(String companyName) {
	// 	return planeTripManager.getPlaneTrips(companyName);
	// }

	// @Override
	// public List<Airport> GetAirports() {
	// 	return planeTripManager.getAirports();
	// }

	// @Override
	// public List<Airline> GetAirlines() {
	// 	return planeTripManager.getAirlines();
	// }
}