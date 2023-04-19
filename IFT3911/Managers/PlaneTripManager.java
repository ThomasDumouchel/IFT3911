package Managers;

import java.util.ArrayList;
import java.util.List;

import DAOs.Company.CompanyDAO;
import DAOs.Company.CompanyType;
import DAOs.Terminal.TerminalDAO;
import DAOs.Terminal.TerminalType;
import DAOs.Trip.TripDAO;
import DAOs.Trip.TripType;
import Models.PlaneTripModel.Airline;
import Models.PlaneTripModel.Airport;
import Models.PlaneTripModel.AirportCreator;
import Models.PlaneTripModel.PlaneTrip;

public class PlaneTripManager {

	private TripDAO tripDao;
	private CompanyDAO companyDao;
	private TerminalDAO terminalDao;
	private AirportCreator airportCreator;

	public PlaneTripManager(
		TripDAO tripDao,
		CompanyDAO companyDao,
		TerminalDAO terminalDao,
		AirportCreator airportCreator
	) {
		this.tripDao = tripDao;
		this.companyDao = companyDao;
		this.terminalDao = terminalDao;
		this.airportCreator = airportCreator;
	}

	public List<Airline> getAirlines() {
		List<Airline> airlines = new ArrayList<Airline>();
		return companyDao.GetCompanies(CompanyType.AIRLINE);
	}

	public List<PlaneTrip> getPlaneTrips(String companyName){
		List<PlaneTrip> planeTrips = tripDao.getTrips(TripType.PLANE);
		var res = new ArrayList<PlaneTrip>();
		for (var trip : planeTrips) {
			if (trip.getCompany().getName().equals(companyName)) {
				res.add(trip);
			}
		}
		return res;
	}

	public Airport createAirport(String name, String city) {
		var airport = airportCreator.createTerminal(name, city);
		terminalDao.add(TerminalType.AIRPORT, airport);
		return (Airport)airport;
	}

	public Airport UpdateAirport(String name, Airport updated_airport) {
		return (Airport)terminalDao.update(TerminalType.AIRPORT, name, updated_airport);
	}


}