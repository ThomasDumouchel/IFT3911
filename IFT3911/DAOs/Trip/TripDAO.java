package DAOs.Trip;

import java.util.ArrayList;
import java.util.List;

import Models.CruiseTripModel.CruiseTrip;
import Models.PlaneTripModel.PlaneTrip;
import Models.TrainTripModel.TrainTrip;
import Models.TripModel.Trip;

public class TripDAO {

    private List<DBTrip> trips;

    public TripDAO() {
        trips = new ArrayList<DBTrip>();
    }

    public List<DBTrip> getAllOfType(TripType tripType) {
        var res = new ArrayList<DBTrip>();
        for (var trip : trips) {
            if (trip.getType() == tripType) {
                res.add(trip);
            }
        }
        return res;
    }



    public static DBTrip ToDBModel(Trip company) {
        TripType type = null;
        if (company instanceof PlaneTrip) {
            type = TripType.PLANE;
        } else if (company instanceof TrainTrip) {
            type = TripType.TRAIN;
        } else if (company instanceof CruiseTrip) {
            type = TripType.CRUISE;
        }
        return new DBTrip(type, company);
    }


}