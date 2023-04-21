package Models.CruiseTripModel;

import Models.TripModel.Section;

public class CruiseSection extends Section<CruiseCabin, CruiseReservationOption, CruiseSectionType> {

    public CruiseSection(CruiseSectionType sectionType, Double fullPriceMutliplier, int nbOfCabins) {
        super(sectionType, fullPriceMutliplier);
        
        for (int i = 0; i < nbOfCabins; i++) {
            this.getReservables().add(new CruiseCabin());
        }
    }
}