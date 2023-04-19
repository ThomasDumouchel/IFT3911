package Models.PlaneTripModel;

import Models.TripModel.Section;

public abstract class PlaneSection extends Section<PlaneSeat, PlaneReservationOption, PlaneSectionType> {

	private final PlaneSectionLayoutType sectionLayout;

	public PlaneSection(
		PlaneSectionType sectionType, 
		Double fullPriceMultiplier, 
		PlaneSectionLayoutType sectionLayout
	) {
		super(sectionType, fullPriceMultiplier);
		this.sectionLayout = sectionLayout;
	}

	public PlaneSectionLayoutType getSectionLayout() {
		return this.sectionLayout;
	}
}