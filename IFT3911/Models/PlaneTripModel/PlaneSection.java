package Models.PlaneTripModel;

import Models.TripModel.Reservable;
import Models.TripModel.Section;

public abstract class PlaneSection<O extends PlaneSeatOption, R extends Reservable<O>, T extends PlaneSectionType> extends Section<O, R, T> {

	public final PlaneSectionType planeSectionType;
	private PlaneSectionLayoutType sectionLayout;

	public PlaneSection(PlaneSectionType sectionType, Double fullPriceMultiplier, PlaneSectionLayoutType sectionLayout) {
		super(sectionType, fullPriceMultiplier);
		
	}

	public PlaneSectionLayoutType getSectionLayout() {
		return this.sectionLayout;
	}


}