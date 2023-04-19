package Models.CruiseTripModel;

import Models.TripModel.Section;

public class CruiseSection extends Section<CruiseCabin, CruiseReservationOption, CruiseSectionType> {

    public CruiseSection(CruiseSectionType sectionType, Double fullPriceMutliplier) {
        super(sectionType, fullPriceMutliplier);
        //TODO Auto-generated constructor stub
    }
}