package Models.TrainTripModel;

import Models.TripModel.Section;

public abstract class TrainSection extends Section<TrainSeat, TrainReservationOption, TrainSectionType> {

    public TrainSection(TrainSectionType sectionType, Double fullPriceMutliplier) {
        super(sectionType, fullPriceMutliplier);
        //TODO Auto-generated constructor stub
    }
}