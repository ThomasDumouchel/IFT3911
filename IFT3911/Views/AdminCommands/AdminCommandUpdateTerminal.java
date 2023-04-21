package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Terminal;
import Views.AdminViews.AdminGUI;

public class AdminCommandUpdateTerminal extends AdminCommand<Terminal> {

    private String terminalCode;
    private Terminal updatedTerminal;

    public AdminCommandUpdateTerminal(AdminGUI adminGUI, TripType tripType, String terminalCode, Terminal updatedTerminal) {
        super(adminGUI, tripType);
        this.terminalCode = terminalCode;
        this.updatedTerminal = updatedTerminal;
    }

    @Override
    public boolean execute() {
        Terminal terminal = getAdminGUI().getController().UpdateTerminal(getTripType(), terminalCode, updatedTerminal);
        saveBackup(terminal);
        return true;
    }

    @Override
    public void undo() {
        getAdminGUI().getController().UpdateTerminal(getTripType(), terminalCode, getBackup());
    }
    
}
