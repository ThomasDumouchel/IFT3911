package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Trip;
import Views.AdminViews.AdminGUI;

public class AdminCommandUpdateTrip extends AdminCommand<Trip> {

    private String id;
    private Trip updatedTrip;

    public AdminCommandUpdateTrip(AdminGUI adminGUI, TripType tripType, String id, Trip updatedTrip) {
        super(adminGUI, tripType);
        this.id = id;
        this.updatedTrip = updatedTrip;
    }

    @Override
    public boolean execute() {
        Trip trip = getAdminGUI().getController().UpdateTrip(getTripType(), id, updatedTrip);
        saveBackup(trip);
        return true;
    }

    @Override
    public void undo() {
        getAdminGUI().getController().UpdateTrip(getTripType(), id, getBackup());
    }
    
}
