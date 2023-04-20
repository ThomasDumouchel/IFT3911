package Models.PlaneTripModel;

import java.util.List;

import Models.TripModel.Section;

public abstract class PlaneSection extends Section<PlaneSeat, PlaneReservationOption, PlaneSectionType> {

	private final PlaneSectionLayoutType sectionLayout;
	private List<PlaneSeat> seats;

	public PlaneSection(
			PlaneSectionType sectionType,
			Double fullPriceMultiplier,
			PlaneSectionLayoutType sectionLayout) {
				super(sectionType, fullPriceMultiplier);
				this.sectionLayout = sectionLayout;
			}

	public PlaneSectionLayoutType getSectionLayout() {
		return this.sectionLayout;
	}

	// create seats, if plane already has seats, for example (A, B, C) and we want
	// to add more seats (D, E, F, G) depending on the layout chosen
	// we will add the new seats to the existing seats
	// if plane has no seats, we will create new seats
	public List<PlaneSeat> createSeats(Integer rowCount, PlaneSectionLayoutType layout) {
		for (int i = 0; i < rowCount; i++) {
			for (int j = 1; j < layout.getSeatCount(); j++) {
				if (j <=26) {
        			// String letter = (String) (j + 'A' - 1);
					PlaneSeat planeSeat = new PlaneSeat(0,"A");
					planeSeat.setRow(i);
					planeSeat.setCol(letter);  
					addSeat(planeSeat);
					seats.add(planeSeat);
				}
			}
		}
		return seats;
	}	

	// add seat to the section
	private void addSeat(PlaneSeat planeSeat) {
		seats.add(planeSeat);
	}

	public PlaneSection updatePlaneSection(String id, PlaneSection updatedPlaneSection){
		// return the old section and replace it with the new section
		PlaneSection oldSection = this;

		

		return oldSection;
	}

}