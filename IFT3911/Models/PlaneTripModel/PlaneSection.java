package Models.PlaneTripModel;

import Models.TripModel.Section;

public abstract class PlaneSection extends Section<PlaneSeat, PlaneReservationOption, PlaneSectionType> {

	private final PlaneSectionLayoutType sectionLayout;

	public PlaneSection(
		PlaneSectionType sectionType, 
		Double fullPriceMultiplier,
		PlaneSectionLayoutType sectionLayout,
		int nbOfows
	) {
		super(sectionType, fullPriceMultiplier);
		this.sectionLayout = sectionLayout;

		for (int i = 0; i < nbOfows; i++) {
			for (int j = 0; j < sectionLayout.getNbOfSeatsPerRow(); j++) {
				this.getReservables().add(new PlaneSeat(i, j));
			}
		}
	}

	public PlaneSectionLayoutType getSectionLayout() {
		return this.sectionLayout;
	}
}