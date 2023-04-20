package Views.AdminCommands;

import Controllers.CreateSectionArgs;
import DAOs.Trip.TripType;
import Models.TripModel.Section;
import Views.AdminViews.AdminGUI;

public class AdminCommandCreateSection extends AdminCommand<Section> {

    private CreateSectionArgs args;

    public AdminCommandCreateSection(AdminGUI adminGUI, TripType tripType, CreateSectionArgs args) {
        super(adminGUI, tripType);
        this.args = args;
    }

    @Override
    public boolean execute() {
        Section section = getAdminGUI().getController().CreateSection(getTripType(), args);
        saveBackup(section);
        return true;
    }

    @Override
    public void undo() {
        //getAdminGUI().getController().DeleteSection(getTripType(), getBackup().getId());
    }
    
}
