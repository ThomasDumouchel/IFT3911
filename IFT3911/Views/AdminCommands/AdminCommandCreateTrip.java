package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Company;
import Models.TripModel.Trip;
import Views.AdminViews.AdminGUI;

public class AdminCommandCreateTrip extends AdminCommand<Trip> {

    private Company company;
    private Double fullPrice;

    public AdminCommandCreateTrip(AdminGUI adminGUI, TripType tripType, Company company, Double fullPrice) {
        super(adminGUI, tripType);
        this.company = company;
        this.fullPrice = fullPrice;
    }

    @Override
    public boolean execute() {
        Trip trip = getAdminGUI().getController().CreateTrip(getTripType(), company.getName(), fullPrice);
        saveBackup(trip);
        return true;
    }

    @Override
    public void undo() {
        getAdminGUI().getController().DeleteTrip(getTripType(), getBackup().getId());
    }
    
}
