package Models.CruiseTripModel;

import Models.TripModel.Company;
import Models.TripModel.Trip;
import Views.TripVisitors.ITripVisitor;

public class CruiseTrip extends Trip<CruiseShip, Port> {

    public CruiseTrip(Company company, Double fullPrice) {
        super(company, fullPrice);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String accept(ITripVisitor visitor) {
        return visitor.visitCruiseTrip(this);
    }

    @Override
    public Port getOrigin() {
        return this.getTravels().get(0).getFrom();
    }

    @Override
    public Port getDestination() {
        return this.getTravels().get(this.getTravels().size() - 1).getTo();
    }


}