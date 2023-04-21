package Controllers;

import java.sql.Date;
import java.util.List;

import DAOs.Trip.TripType;
import Managers.TripManager;
import Managers.PaymentManager;
import Models.Payment.Payment;
import Models.Payment.PaymentInfo;
import Models.TripModel.Client;
import Models.TripModel.Company;
import Models.TripModel.ISectionType;
import Models.TripModel.Reservable;
import Models.TripModel.ReservationOption;
import Models.TripModel.Section;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;

public class VacationSystem implements AdminController, ClientController {

	private TripManager tripManager;
	private Managers.PaymentManager paymentManager;

	public VacationSystem(TripManager tripManager, PaymentManager paymentManager) {
		this.tripManager = tripManager;
		this.paymentManager = paymentManager;
	}

	@Override
	public Terminal CreateTerminal(TripType tripType, String terminal_code, String name, String city) {
		return this.tripManager.createTerminal(tripType, terminal_code, name, city);
	}

	@Override
	public Terminal UpdateTerminal(TripType tripType, String terminal_code, Terminal updated_terminal) {
		return this.tripManager.updateTerminal(tripType, terminal_code, updated_terminal);
	}

	@Override
	public Terminal DeleteTerminal(TripType tripType, String terminal_code) {
		return this.tripManager.deleteTerminal(tripType, terminal_code);
	}

	@Override
	public Company CreateCompany(TripType tripType, String name, String prefix) {
		return this.tripManager.createCompany(tripType, name, prefix);
	}

	@Override
	public Company UpdateCompany(TripType tripType, String name, Company updated_company) {
		return this.tripManager.updateCompany(tripType, name, updated_company);
	}

	@Override
	public Company DeleteCompany(TripType tripType, String name) {
		return this.tripManager.deleteCompany(tripType, name);
	}

	@Override
	public Trip CreateTrip(TripType tripType, String company_name, Double fullPrice) {
		return this.tripManager.createTrip(tripType, company_name, fullPrice);
	}

	@Override
	public Trip UpdateTrip(TripType tripType, String id, Trip updated_trip) {
		return this.tripManager.updateTrip(tripType, id, updated_trip);
	}

	@Override
	public Trip DeleteTrip(TripType tripType, String id) {
		return this.tripManager.deleteTrip(tripType, id);
	}

	@Override
	public Section CreateSection(TripType tripType, ISectionType sectionType, CreateSectionArgs createSectionArgs) {
		return this.tripManager.createSection(tripType, sectionType, createSectionArgs);
	}

	@Override
	public Section UpdateSection(TripType tripType, String id, Section updated_section) {
		return this.tripManager.updateSection(tripType, id, updated_section);
	}

	@Override
	public Section DeleteSection(TripType tripType, String id) {
		return this.tripManager.deleteSection(tripType, id);
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
		// First make payment
		Payment payment = this.paymentManager.makePayment(paymentInfo);
		// Then confirm reservation
		return this.tripManager.confirm(reservationId, paymentInfo, client);
	}

	@Override
	public Reservable ReserveTrip(TripType tripType, String tripId, ISectionType sectionType, ReservationOption option) {
		return this.tripManager.reserveTrip(tripType, tripId, sectionType, option);
	}

	@Override
	public List<Trip> GetTrips(TripType tripType, String originId, String destinationId, Date date,
			ISectionType sectionType) {
		return this.tripManager.getTrips(tripType, originId, destinationId, date, sectionType);
	}

}