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

	public int getNbOfSeatsPerRow() {
		switch (this) {
			case TIGHT:
				return 3;
			case MEDIUM:
				return 6;
			case COMFORT:
				return 4;
			case LARGE:
				return 10;
			default:
				throw new IllegalArgumentException("Invalid PlaneSectionLayoutType");
		}
	}
}
