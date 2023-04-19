package Managers;

import java.util.ArrayList;
import java.util.List;

import DAOs.Company.CompanyDAO;
import DAOs.Company.CompanyType;
import DAOs.Trip.TripDAO;
import DAOs.Trip.TripType;
import Models.PlaneTripModel.Airline;
import Models.PlaneTripModel.PlaneTrip;

public class PlaneTripManager {

	private TripDAO tripDao;
	private CompanyDAO companyDao;

	public PlaneTripManager(
		TripDAO tripDao,
		CompanyDAO companyDao
	) {
		this.tripDao = tripDao;
		this.companyDao = companyDao;
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


}