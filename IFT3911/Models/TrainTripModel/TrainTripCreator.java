package Models.TrainTripModel;

import Models.TripModel.Company;
import Models.TripModel.Trip;
import Models.TripModel.TripCreator;

public class TrainTripCreator extends TripCreator {

	private TrainTripCreator instance;

	public TrainTripCreator getInstance() {
		if (this.instance == null) {
			this.instance = new TrainTripCreator();
		}
		return this.instance;
	}

	@Override
	public Trip createTrip(Company company) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createTrip'");
	}

}