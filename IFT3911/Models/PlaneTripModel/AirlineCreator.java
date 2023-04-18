package Models.PlaneTripModel;

import Models.TripModel.Company;
import Models.TripModel.CompanyCreator;

public class AirlineCreator extends CompanyCreator {

	private AirlineCreator instance;

	/**
	 * 
	 * @param name
	 * @param prefix
	 */
	public Company createCompany(String name, String prefix) {
		return new Airline(name, prefix);
	}

	public AirlineCreator getInstance() {
		if (this.instance == null) {
			this.instance = new AirlineCreator();
		}
		return this.instance;
	}
}