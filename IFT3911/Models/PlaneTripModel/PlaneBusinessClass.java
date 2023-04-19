package Models.PlaneTripModel;

public class PlaneBusinessClass extends PlaneSection {

    public PlaneBusinessClass(PlaneSectionLayoutType sectionLayout) {
        super(
            PlaneSectionType.BUSINESS, 
            0.8, 
            sectionLayout
        );
    }
    
}
