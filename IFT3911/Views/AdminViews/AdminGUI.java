package Views.AdminViews;

import Views.EventListener;
import Views.AdminCommands.*;

public abstract class AdminGUI implements EventListener {

	/**
	 * 
	 * @param command
	 */
	public void executeCommand(AdminCommand command) {
		// TODO - implement AdminGUI.executeCommand
		throw new UnsupportedOperationException();
	}

	public void undo() {
		// TODO - implement AdminGUI.undo
		throw new UnsupportedOperationException();
	}

}