package Models.TripModel;
public class Available implements ReservableState {

	Reservable context;

    public Available(Reservable context) {
        this.context = context;
    }
        
    @Override
    public Boolean isAvailable() {
        return true;
    }

    @Override
    public Reservable book() {
        context.changeState(new Reserved(context));
        return context;
    }
}