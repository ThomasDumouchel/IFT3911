package Managers;

import java.util.ArrayList;
import java.util.List;

import DAOs.Trip.TripDAO;
import DAOs.Trip.TripType;
import Models.TripModel.Trip;

public class TrainTripManager {

	private TripDAO tripDao;


	public List<TrainTrip> getTrainTrips(String companyName){
		List<TrainTrip> planeTrips = tripDao.getTrips(TripType.TRAIN);
		var res = new ArrayList<TrainTrip>();
		for (var trip : planeTrips) {
			if (trip.getCompany().getName().equals(companyName)) {
				res.add(trip);
			}
		}
		return res;
	}
}