package Models.TrainTripModel;

public enum TrainSectionType {
    FIRST("P"), 
    ECONOMY("E");

    private final String code;

	private TrainSectionType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
