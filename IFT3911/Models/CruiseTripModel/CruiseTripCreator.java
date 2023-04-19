package Models.CruiseTripModel;

import Models.TripModel.Company;
import Models.TripModel.Trip;
import Models.TripModel.TripCreator;

public class CruiseTripCreator extends TripCreator {

	private CruiseTripCreator instance;

	public CruiseTripCreator getInstance() {
		if (this.instance == null) {
			this.instance = new CruiseTripCreator();
		}
		return this.instance;
	}

	@Override
	public Trip createTrip(Company company) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'CreateTrip'");
	}



}