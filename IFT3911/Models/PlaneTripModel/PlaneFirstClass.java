package Models.PlaneTripModel;

public class PlaneFirstClass extends PlaneSection {

    public PlaneFirstClass(PlaneSectionLayoutType sectionLayout, int nbOfRows) {
        super(
            PlaneSectionType.FIRST, 
            1.0, 
            sectionLayout,
            nbOfRows
        );
    }
    
}