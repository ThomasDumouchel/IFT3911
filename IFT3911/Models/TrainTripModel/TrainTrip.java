package Models.TrainTripModel;

import Models.TripModel.Company;
import Models.TripModel.Trip;
import Views.TripVisitors.ITripVisitor;

public class TrainTrip extends Trip<Train, TrainStation> {

    public TrainTrip(Company company, Double fullPrice) {
        super(company, fullPrice);
    }

    @Override
    public String accept(ITripVisitor visitor) {
        return visitor.visitTrainTrip(this);
    }

    @Override
    public TrainStation getOrigin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrigin'");
    }

    @Override
    public TrainStation getDestination() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDestination'");
    }

}