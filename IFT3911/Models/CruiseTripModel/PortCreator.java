package Models.CruiseTripModel;
import Models.TripModel.Terminal;
import Models.TripModel.TerminalCreator;

public class PortCreator extends TerminalCreator {

	private PortCreator instance;

	/**
	 * 
	 * @param name
	 * @param city
	 */
	public Terminal createTerminal(String name, String city) {
		return new Port(name, city);
	}

	public PortCreator getInstance() {
		if (this.instance == null) {
			this.instance = new PortCreator();
		}
		return this.instance;
	}


}