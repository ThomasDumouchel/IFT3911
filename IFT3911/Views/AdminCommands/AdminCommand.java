package Views.AdminCommands;

import DAOs.Trip.TripType;
import Views.AdminViews.AdminGUI;

public abstract class AdminCommand<T> {

	private AdminGUI adminGUI;
	private TripType tripType;
	private T backup;

	public AdminCommand(AdminGUI adminGUI, TripType tripType) {
		this.adminGUI = adminGUI;
		this.tripType = tripType;
	}

	public AdminGUI getAdminGUI() {
		return adminGUI;
	}

	public TripType getTripType() {
		return tripType;
	}

	public T getBackup() {
		return backup;
	}

	public abstract boolean execute();

	public abstract void undo();

	public void saveBackup(T backup){
		this.backup = backup;
	}

}