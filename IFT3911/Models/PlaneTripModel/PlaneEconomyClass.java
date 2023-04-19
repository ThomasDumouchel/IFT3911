package Models.PlaneTripModel;
public class PlaneEconomyClass extends PlaneSection {

    public PlaneEconomyClass(PlaneSectionLayoutType sectionLayout) {
        super(
            PlaneSectionType.ECONOMY, 
            0.5, 
            sectionLayout
        );
    }
}