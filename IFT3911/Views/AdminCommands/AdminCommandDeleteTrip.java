package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Trip;
import Views.AdminViews.AdminGUI;

public class AdminCommandDeleteTrip extends AdminCommand<Trip> {

    private String id;

    public AdminCommandDeleteTrip(AdminGUI adminGUI, TripType tripType, String id) {
        super(adminGUI, tripType);
        this.id = id;
    }

    @Override
    public boolean execute() {
        Trip trip = getAdminGUI().getController().DeleteTrip(getTripType(), id);
        saveBackup(trip);
        return true;
    }

    @Override
    public void undo() {
        getAdminGUI().getController().CreateTrip(getTripType(), getBackup().getCompany().getName(), getBackup().getFullPrice());
        getAdminGUI().getController().UpdateTrip(getTripType(), getBackup().getId(), getBackup());
    }
    
}
