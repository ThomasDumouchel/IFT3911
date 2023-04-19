package Models.PlaneTripModel;
import Models.TripModel.ReservationOption;

public class PlaneReservationOption extends ReservationOption {

	private PlaneSeatOptionEnum seatRowPosition;

	public PlaneReservationOption(PlaneSeatOptionEnum seatRowPosition) {
		this.seatRowPosition = seatRowPosition;
	}

	public PlaneSeatOptionEnum getSeatRowPosition() {
		return this.seatRowPosition;
	}

	@Override
	public Boolean equals(ReservationOption option) {
		if (option instanceof PlaneReservationOption) {
			PlaneReservationOption planeSeatOption = (PlaneReservationOption) option;
			if (planeSeatOption.getSeatRowPosition() == this.seatRowPosition) {
				return true;
			}
		}
		return false;
	}


}