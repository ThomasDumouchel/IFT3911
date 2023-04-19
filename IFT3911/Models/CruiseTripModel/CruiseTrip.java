package Models.CruiseTripModel;

import Models.TripModel.Company;
import Models.TripModel.Trip;
import Views.TripVisitors.TripVisitor;

public class CruiseTrip extends Trip<CruiseShip, Port> {

    protected CruiseTrip(Company company, Double fullPrice) {
        super(company, fullPrice);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String accept(TripVisitor visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }


}