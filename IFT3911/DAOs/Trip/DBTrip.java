package DAOs.Trip;

import java.util.List;

import Models.TripModel.Transport;
import Models.TripModel.Travel;
import Models.TripModel.Trip;

public class DBTrip {
    private TripType type;
    private String tripId;
    private String companyId;
    private List<Travel> travels;
    private Transport transport;
    
    public DBTrip(TripType type, Trip trip) {
        this.tripId = trip.getId();
        this.companyId = trip.getCompany().getId();
        this.travels = trip.getTravels();
        this.transport = trip.getTransport();
    }

    public TripType getType() {
        return this.type;
    }

    public String getCompanyId() {
        return this.companyId;
    }

}
