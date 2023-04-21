package Models.PlaneTripModel;
public class PlaneEconomyClass extends PlaneSection {

    public PlaneEconomyClass(PlaneSectionLayoutType sectionLayout, int nbOfRows) {
        super(
            PlaneSectionType.ECONOMY,
            0.5,
            sectionLayout,
            nbOfRows
        );
    }
}