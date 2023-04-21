package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Section;
import Views.AdminViews.AdminGUI;

public class AdminCommandUpdateSection extends AdminCommand<Section> {

    private String id;
    private Section updatedSection;

    public AdminCommandUpdateSection(AdminGUI adminGUI, TripType tripType, String id, Section updatedSection) {
        super(adminGUI, tripType);
        this.id = id;
        this.updatedSection = updatedSection;
    }

    @Override
    public boolean execute() {
        Section section = getAdminGUI().getController().UpdateSection(getTripType(), this.id, this.updatedSection);
        saveBackup(section);
        return true;
    }

    @Override
    public void undo() {
        getAdminGUI().getController().UpdateSection(getTripType(), this.id, getBackup());
    }
    
}
