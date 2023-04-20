
package Models.PlaneTripModel;

import Models.TripModel.Reservable;

public class PlaneSeat extends Reservable<PlaneReservationOption> {

	private Integer row;
	private String col;
	

	public PlaneSeat(Integer row, String col) {
		super();
		this.row = row;
		this.col = col;
	}

	public Integer getRow() {
		return this.row;
	}

	public String getCol() {
		return this.col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(String j) {
		this.col = j;
	}

}