package Models.PlaneTripModel;

import Models.TripModel.Reservable;

public class PlaneSeat extends Reservable<PlaneReservationOption> {

	private static String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" };

	private Integer row;
	private String col;

	public PlaneSeat(Integer row, Integer col) {
		super();
		this.row = row;
		this.col = PlaneSeat.alphabet[col].toString();
	}

	public Integer getRow() {
		return this.row;
	}

	public String getCol() {
		return this.col;
	}

}