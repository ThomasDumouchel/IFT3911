package Models.CruiseTripModel;
import Models.TripModel.Company;
import Models.TripModel.CompanyCreator;

public class CruiseLineCreator extends CompanyCreator {

	private CruiseLineCreator instance;

	@Override
	public Company createCompany(String name, String prefix) {
		return new CruiseLine(name, prefix);
	}

	public CruiseLineCreator getInstance() {
		if (this.instance == null) {
			this.instance = new CruiseLineCreator();
		}
		return this.instance;
	}


}