package Models.PlaneTripModel;

import Models.TripModel.Company;
import Models.TripModel.Trip;
import Models.TripModel.TripCreator;

public class PlaneTripCreator extends TripCreator {

	private PlaneTripCreator instance;

	public PlaneTripCreator getInstance() {
		if (this.instance == null) {
			this.instance = new PlaneTripCreator();
		}
		return this.instance;
	}

	@Override
	public Trip createTrip(Company company) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createTrip'");
	}


}