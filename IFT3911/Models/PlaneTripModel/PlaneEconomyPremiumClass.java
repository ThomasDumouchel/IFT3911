package Models.PlaneTripModel;
public class PlaneEconomyPremiumClass extends PlaneSection {

    public PlaneEconomyPremiumClass(PlaneSectionLayoutType sectionLayout) {
        super(
            PlaneSectionType.ECONOMY_PREMIUM, 
            0.6, 
            sectionLayout
        );
    }
    
}