package Models.TripModel;

import java.util.UUID;

public abstract class Reservable<O extends ReservationOption> {

	private String id;
	private ReservableState state;
	private O reserveOption;

	public Reservable() {
		this.id = UUID.randomUUID().toString();
		this.state = new Available(this);
	}

	public Boolean isAvailable(){
		return state.isAvailable();
	}

	public Boolean doesRespectOption(O option){
		return this.reserveOption == option;
	}

	public Reservable<O> book(){
		return state.book();
	}

	public void changeState(ReservableState state) {
		this.state = state;
	}

}