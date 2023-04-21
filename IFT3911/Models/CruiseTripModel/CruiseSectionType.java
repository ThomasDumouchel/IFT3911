package Models.CruiseTripModel;

import Models.TripModel.ISectionType;

public enum CruiseSectionType implements ISectionType {
    INTERIOR("I"), 
    OCEAN_VIEW("O"), 
    SUITE("S"), 
    FAMILY("F"), 
    FAMILY_DELUXE("D");

    private final String code;

	private CruiseSectionType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
