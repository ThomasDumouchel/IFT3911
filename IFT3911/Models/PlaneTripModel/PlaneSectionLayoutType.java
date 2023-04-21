package Models.PlaneTripModel;

public enum PlaneSectionLayoutType {
	TIGHT("S"),
	MEDIUM("M"),
	COMFORT("C"),
	LARGE("L");

	private final String code;

	private PlaneSectionLayoutType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
