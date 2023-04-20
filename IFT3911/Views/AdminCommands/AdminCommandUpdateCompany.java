package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Company;
import Views.AdminViews.AdminGUI;

public class AdminCommandUpdateCompany extends AdminCommand<Company> {

    private String name;
    private Company updatedCompany;

    public AdminCommandUpdateCompany(AdminGUI adminGUI, TripType tripType, String name, Company updatedCompany) {
        super(adminGUI, tripType);
        this.name = name;
        this.updatedCompany = updatedCompany;
    }

    @Override
    public boolean execute() {
        Company company = getAdminGUI().getController().UpdateCompany(getTripType(), name, updatedCompany);
        saveBackup(company);
        return true;
    }

    @Override
    public void undo() {
        getAdminGUI().getController().UpdateCompany(getTripType(), name, getBackup());
    }
    
}
