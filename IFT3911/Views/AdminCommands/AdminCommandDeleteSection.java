package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Section;
import Views.AdminViews.AdminGUI;

public class AdminCommandDeleteSection extends AdminCommand<Section> {

    private String id;

    public AdminCommandDeleteSection(AdminGUI adminGUI, TripType tripType, String id) {
        super(adminGUI, tripType);
        this.id = id;
    }

    @Override
    public boolean execute() {
        Section section = getAdminGUI().getController().DeleteSection(getTripType(), id);
        saveBackup(section);
        return true;
    }

    @Override
    public void undo() {
        // getAdminGUI().getController().CreateSection(getTripType(), getBackup().getTripId(), getBackup().getSectionType());
    }
    
}
