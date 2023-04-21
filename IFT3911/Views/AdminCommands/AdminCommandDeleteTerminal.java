package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Terminal;
import Views.AdminViews.AdminGUI;

public class AdminCommandDeleteTerminal extends AdminCommand<Terminal> {

    private String terminalCode;

    public AdminCommandDeleteTerminal(AdminGUI adminGUI, TripType tripType, String terminalCode) {
        super(adminGUI, tripType);
        this.terminalCode = terminalCode;
    }

    @Override
    public boolean execute() {
        Terminal terminal = getAdminGUI().getController().DeleteTerminal(getTripType(), terminalCode);
        saveBackup(terminal);
        return true;
    }

    @Override
    public void undo() {
        getAdminGUI().getController().CreateTerminal(getTripType(), getBackup().getCode(), getBackup().getName(), getBackup().getCity());
    }
    
}
