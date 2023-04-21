package Models.CruiseTripModel;
public class CruiseFamilyDeluxeSection extends CruiseSection {

    public CruiseFamilyDeluxeSection(int nbOfCabins) {
        super(
            CruiseSectionType.FAMILY_DELUXE, 
            0.8,
            nbOfCabins
        );
    }

}