package Models.CruiseTripModel;
public class CruiseOceanVueSection extends CruiseSection {
    public CruiseOceanVueSection(int nbOfCabins) {
        super(
            CruiseSectionType.OCEAN_VIEW, 
            0.9,
            nbOfCabins
        );
    }
}