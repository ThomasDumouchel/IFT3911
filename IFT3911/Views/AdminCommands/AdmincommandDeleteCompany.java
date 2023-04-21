package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Company;
import Views.AdminViews.AdminGUI;

public class AdmincommandDeleteCompany extends AdminCommand<Company>{

    private String name;

    public AdmincommandDeleteCompany(AdminGUI adminGUI, TripType tripType, String name) {
        super(adminGUI, tripType);
        this.name = name;
    }

    @Override
    public boolean execute() {
        Company company = getAdminGUI().getController().DeleteCompany(getTripType(), name);
        saveBackup(company);
        return true; // success
    }

    @Override
    public void undo() {
        getAdminGUI().getController().CreateCompany(getTripType(), getBackup().getName(), getBackup().getPrefix());
    }
    
}
