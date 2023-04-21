package Models.TrainTripModel;

import Models.TripModel.ISectionType;

public enum TrainSectionType implements ISectionType {
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
