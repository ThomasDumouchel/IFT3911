package Models.CruiseTripModel;

public enum CruiseSectionType {
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
