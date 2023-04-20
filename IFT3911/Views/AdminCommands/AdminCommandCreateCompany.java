package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Company;
import Views.AdminViews.AdminGUI;

public class AdminCommandCreateCompany extends AdminCommand<Company> {

    private String name;
    private String prefix;

    public AdminCommandCreateCompany(AdminGUI adminGUI, TripType tripType, String name, String prefix) {
        super(adminGUI, tripType);
        this.name = name;
        this.prefix = prefix;
    }

    @Override
    public boolean execute() {
        saveBackup(null);
        Company company = getAdminGUI().getController().CreateCompany(this.getTripType(), name, prefix);
        // Make a call to update the GUI

        return true;
    }

    @Override
    public void undo() {
        getAdminGUI().getController().DeleteCompany(getTripType(), name);
    }

    
}
