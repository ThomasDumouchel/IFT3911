package Models.TrainTripModel;

import Models.TripModel.Section;

public abstract class TrainSection extends Section<TrainSeat, TrainReservationOption, TrainSectionType> {

    public TrainSection(TrainSectionType sectionType, Double fullPriceMutliplier, int nbOfRows) {
        super(sectionType, fullPriceMutliplier);
        
        for (int i = 0; i < nbOfRows; i++) {
            for (int j = 0; j < 3; j++){
                this.getReservables().add(new TrainSeat(i, j));
            }
        }
    }
}