package Views.AdminCommands;

import DAOs.Trip.TripType;
import Models.TripModel.Terminal;
import Views.AdminViews.AdminGUI;

public class AdminCommandCreateTerminal extends AdminCommand<Terminal>{

    private String terminalCode;
    private String name;
    private String city;

    public AdminCommandCreateTerminal(AdminGUI adminGUI, TripType tripType, String terminalCode, String name, String city) {
        super(adminGUI, tripType);
        this.terminalCode = terminalCode;
        this.name = name;
        this.city = city;
    }

    @Override
    public boolean execute() {
        saveBackup(null);
        Terminal terminal = getAdminGUI().getController().CreateTerminal(getTripType(), terminalCode, name, city);
        return true;
    }

    @Override
    public void undo() {
        getAdminGUI().getController().DeleteTerminal(getTripType(), terminalCode);
    }
    
}
