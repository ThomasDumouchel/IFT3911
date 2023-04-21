package Models.CruiseTripModel;
public class CruiseInteriorSection extends CruiseSection {

    public CruiseInteriorSection(int nbOfCabins) {
        super(
            CruiseSectionType.INTERIOR, 
            0.5,
            nbOfCabins
        );
    }
}