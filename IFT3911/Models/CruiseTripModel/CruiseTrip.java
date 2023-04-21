package Models.CruiseTripModel;

import Models.TripModel.Company;
import Models.TripModel.Trip;
import Views.TripVisitors.ITripVisitor;

public class CruiseTrip extends Trip<CruiseShip, Port> {

    public CruiseTrip(Company company, Double fullPrice) {
        super(company, fullPrice);
    }

    @Override
    public String accept(ITripVisitor visitor) {
        return visitor.visitCruiseTrip(this);
    }


}