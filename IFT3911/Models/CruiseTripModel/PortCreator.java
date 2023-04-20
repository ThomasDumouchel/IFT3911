package Models.CruiseTripModel;
import Models.TripModel.Terminal;
import Models.TripModel.TerminalCreator;

public class PortCreator extends TerminalCreator {

	private static PortCreator instance;

	/**
	 * 
	 * @param name
	 * @param city
	 */
	public Terminal createTerminal(String name, String code, String city) {
		return new Port(name, code, city);
	}

	public static PortCreator getInstance() {
		if (instance == null) {
			instance = new PortCreator();
		}
		return instance;
	}


}