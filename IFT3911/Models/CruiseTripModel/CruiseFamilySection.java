package Models.CruiseTripModel;
public class CruiseFamilySection extends CruiseSection {

    public CruiseFamilySection(int nbOfCabins) {
        super(
            CruiseSectionType.FAMILY, 
            0.7,
            nbOfCabins
        );
    }
}