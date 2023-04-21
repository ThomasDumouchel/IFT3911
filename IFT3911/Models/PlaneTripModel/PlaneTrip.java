package Models.PlaneTripModel;


import Models.TripModel.Company;
import Models.TripModel.Trip;
import Views.TripVisitors.ITripVisitor;

public class PlaneTrip extends Trip<Plane, Airport> {


    public PlaneTrip(Company company, Double fullPrice) {
        super(company, fullPrice);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String accept(ITripVisitor visitor) {
        return visitor.visitPlaneTrip(this);
    }



}