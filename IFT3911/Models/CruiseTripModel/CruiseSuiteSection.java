package Models.CruiseTripModel;
public class CruiseSuiteSection extends CruiseSection {
    public CruiseSuiteSection(int nbOfCabins) {
        super(
            CruiseSectionType.SUITE, 
            1.0,
            nbOfCabins
        );
    }
}