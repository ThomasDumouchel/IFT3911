package Models.TripModel;
public class Confirmed implements ReservableState {

    Reservable context;
    Client client;

    public Confirmed(Reservable context) {
        this.context = context;
    }

    @Override
    public Boolean isAvailable() {
        return false;
    }

    @Override
    public Reservable book() {
        // Don't do anything
        return null;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}