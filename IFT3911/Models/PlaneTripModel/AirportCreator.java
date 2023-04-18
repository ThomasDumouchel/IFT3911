
package Models.PlaneTripModel;

import Models.TripModel.Terminal;
import Models.TripModel.TerminalCreator;

public class AirportCreator extends TerminalCreator {

	private AirportCreator instance;

	/**
	 * 
	 * @param name
	 * @param city
	 */
	public Terminal createTerminal(String name, String city) {
		return new Airport(name, city);
	}

	public AirportCreator getInstance() {
		if (this.instance == null) {
			this.instance = new AirportCreator();
		}
		return this.instance;
	}


}