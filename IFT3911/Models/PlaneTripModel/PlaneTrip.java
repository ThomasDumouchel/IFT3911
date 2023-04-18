package Models.PlaneTripModel;


import Models.TripModel.Company;
import Models.TripModel.Trip;
import Views.TripVisitors.TripVisitor;

public class PlaneTrip extends Trip<Plane, Airport> {


    protected PlaneTrip(Company company, Double fullPrice) {
        super(company, fullPrice);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String accept(TripVisitor visitor) {
        return visitor.visitPlaneTrip(this);
    }




}