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
        this.trips = new ArrayList<>();
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

    public DBTrip deleteTrip(TripType tripType, String id) {
        for (var trip : getAllOfType(tripType)) {
            if (trip.getId().equals(id)) {
                trips.remove(trip);
                return trip;
            }
        }
        throw new RuntimeException("Trip not found");
    }

    public DBTrip updateTrip(TripType tripType, String id, Trip updated_trip) {
        var deleted_trip = deleteTrip(tripType, id);
        trips.add(ToDBModel(updated_trip));
        tripEventManager.notify(TripEventType.TRIP, updated_trip);
        return deleted_trip;
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

    public DBTrip getTrip(TripType tripType, String tripId) {
        for (var trip : getAllOfType(tripType)) {
            if (trip.getId().equals(tripId)) {
                return trip;
            }
        }
        throw new RuntimeException("Trip not found");
    }


}