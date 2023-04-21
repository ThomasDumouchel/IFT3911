package Views.TripVisitors;
import Models.CruiseTripModel.CruiseTrip;
import Models.PlaneTripModel.PlaneTrip;
import Models.TrainTripModel.TrainTrip;

public interface ITripVisitor {

	/**
	 * 
	 * @param p
	 */
	String visitPlaneTrip(PlaneTrip p);

	/**
	 * 
	 * @param c
	 */
	String visitCruiseTrip(CruiseTrip c);

	/**
	 * 
	 * @param t
	 */
	String visitTrainTrip(TrainTrip t);

}