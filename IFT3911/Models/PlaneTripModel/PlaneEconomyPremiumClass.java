package Models.PlaneTripModel;
public class PlaneEconomyPremiumClass extends PlaneSection {

    public PlaneEconomyPremiumClass(PlaneSectionLayoutType sectionLayout, int nbOfRows) {
        super(
            PlaneSectionType.ECONOMY_PREMIUM, 
            0.6, 
            sectionLayout,
            nbOfRows
        );
    }
    
}