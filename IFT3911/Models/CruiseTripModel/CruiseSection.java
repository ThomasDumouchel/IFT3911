package Models.CruiseTripModel;

import Models.TripModel.Section;

public class CruiseSection extends Section<CruiseReserveOption, CruiseCabin, CruiseSectionType> {

    public CruiseSection(CruiseSectionType sectionType, Double fullPriceMutliplier) {
        super(sectionType, fullPriceMutliplier);
        //TODO Auto-generated constructor stub
    }
}