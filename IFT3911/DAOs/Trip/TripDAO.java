package DAOs.Trip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAOs.Company.DBCompany;
import Models.CruiseTripModel.CruiseTrip;
import Models.PlaneTripModel.PlaneTrip;
import Models.TrainTripModel.TrainTrip;
import Models.TripModel.Trip;

public class TripDAO {

    private List<DBTrip> trips;

    public TripDAO() {
        trips = new ArrayList<DBTrip>(Arrays.tolist(
            new DBTrip()
        ));
    }

    public List<PlaneTrip> getTrips(TripType tripType) {
        var res = new ArrayList<PlaneTrip>();
        for (var trip : trips) {
            if (trip.getType() == tripType) {
                res.add((PlaneTrip)ToAppModel(trip));
            }
        }
        return res;
    }

    public static Trip ToAppModel(DBTrip dbWrapper) {
        // TODO: Create Trip from DBTrip
        // check tryp type and create the right type
        // will need to fetch the company from the company DAO
        return null;
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