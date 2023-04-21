package Models.PlaneTripModel;

public enum PlaneSectionType {
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