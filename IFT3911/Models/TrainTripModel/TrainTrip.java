package Models.TrainTripModel;

import Models.TripModel.Company;
import Models.TripModel.Trip;
import Views.TripVisitors.TripVisitor;

public class TrainTrip extends Trip<Train, TrainStation> {

    protected TrainTrip(Company company, Double fullPrice) {
        super(company, fullPrice);
    }

    @Override
    public String accept(TripVisitor visitor) {
        return visitor.visitTrainTrip(this);
    }

}