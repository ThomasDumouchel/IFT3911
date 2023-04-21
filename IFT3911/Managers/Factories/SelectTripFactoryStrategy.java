package Managers.Factories;

import DAOs.Trip.TripType;

public class SelectTripFactoryStrategy {
    public ITripFactory selectTripFactory(TripType tripType) {
        switch (tripType) {
            case PLANE:
                return PlaneTripFactory.getInstance();
            case TRAIN:
                return TrainTripFactory.getInstance();
            case CRUISE:
                return CruiseTripFactory.getInstance();
            default:
                return null;
        }
    }
}
