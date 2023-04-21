package Controllers;

import java.sql.Date;
import java.util.List;

import DAOs.Trip.TripType;
import Managers.TripManager;
import Models.Payment.PaymentInfo;
import Models.TripModel.Client;
import Models.TripModel.Company;
import Models.TripModel.Reservable;
import Models.TripModel.ReservationOption;
import Models.TripModel.Section;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;

public class VacationSystem implements AdminController, ClientController {

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

	@Override
	public Reservable Confirm(String reservationId, PaymentInfo paymentInfo, Client client) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'Confirm'");
	}

	@Override
	public Reservable ReserveTrip(TripType tripType, String tripId, Enum<?> sectionType, ReservationOption option) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'ReserveTrip'");
	}

	@Override
	public List<Trip> GetTrips(TripType tripType, String originId, String destinationId, Date date,
			Enum<?> sectionType) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'GetTrips'");
	}

}