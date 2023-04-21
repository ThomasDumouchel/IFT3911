package DAOs.Trip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAOs.TripObserver.TripEventManager;
import DAOs.TripObserver.TripEventType;
import Models.CruiseTripModel.CruiseTrip;
import Models.PlaneTripModel.PlaneTrip;
import Models.TrainTripModel.TrainTrip;
import Models.TripModel.Trip;

public class TripDAO {

    private List<DBTrip> trips;
    private TripEventManager tripEventManager;


    public TripDAO(TripEventManager tripEventManager) {
        this.tripEventManager = tripEventManager;
        trips = new ArrayList<DBTrip>(Arrays.asList(

        ));
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

    public void addTrip(TripType tripType, Trip trip) {
        trips.add(ToDBModel(trip));
    }

    public void deleteTrip(TripType tripType, String id) {
        for (var trip : getAllOfType(tripType)) {
            if (trip.getId().equals(id)) {
                trips.remove(trip);
                return;
            }
        }
        throw new RuntimeException("Trip not found");
    }

    public void updateTrip(TripType tripType, String id, Trip trip) {
        deleteTrip(tripType, id);
        trips.add(ToDBModel(trip));
        tripEventManager.notify(TripEventType.TRIP, trip);
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