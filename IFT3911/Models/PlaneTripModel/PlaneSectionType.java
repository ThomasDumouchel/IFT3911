package Models.PlaneTripModel;

import Models.TripModel.ISectionType;

public enum PlaneSectionType implements ISectionType {
	ECONOMY("E"),
	ECONOMY_PREMIUM("P"),
	BUSINESS("B"), 
	FIRST("P");

	private final String code;

	private PlaneSectionType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}