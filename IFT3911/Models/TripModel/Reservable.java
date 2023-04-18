package Models.TripModel;

import java.util.UUID;

public abstract class Reservable<O extends ReserveOption> {

	String id;
	ReservableState state;

	public Reservable() {
		this.id = UUID.randomUUID().toString();
		this.state = new Available(this);
	}

	public Boolean isAvailable(){
		return state.isAvailable();
	}

	public abstract Boolean doesRespectOption(O option);

	public Reservable<O> book(){
		return state.book();
	}

	public void changeState(ReservableState state) {
		this.state = state;
	}

}