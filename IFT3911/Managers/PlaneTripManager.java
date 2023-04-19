package Managers;

import java.util.ArrayList;
import java.util.List;

import DAOs.TripDAO;
import DAOs.Company.CompanyDAO;
import DAOs.Company.CompanyType;
import Models.PlaneTripModel.Airline;

public class PlaneTripManager {

	private TripDAO tripDao;
	private CompanyDAO companyDao;

	public List<Airline> getAirlines() {
		List<Airline> airlines = new ArrayList<Airline>();
		return companyDao.GetCompanies(CompanyType.AIRLINE);
	}


}