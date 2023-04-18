package Views.TripVisitors;

import Models.CruiseTripModel.CruiseTrip;
import Models.PlaneTripModel.PlaneTrip;
import Models.TrainTripModel.TrainTrip;

public class ClientTripVisitor implements TripVisitor {

	private SectionType sectionName;

	@Override
	public String visitPlaneTrip(PlaneTrip p) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visitPlaneTrip'");
	}

	@Override
	public String visitCruiseTrip(CruiseTrip c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visitCruiseTrip'");
	}

	@Override
	public String visitTrainTrip(TrainTrip t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visitTrainTrip'");
	}

	/*
	 * trip = GetTrip(...)
	 * trip.accept(clientVisitor)	
	 */

}