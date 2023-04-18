package Models.TrainTripModel;
import Models.TripModel.Terminal;
import Models.TripModel.TerminalCreator;

public class TrainStationCreator extends TerminalCreator {

	private TrainStationCreator instance;

	/**
	 * 
	 * @param name
	 * @param city
	 */
	public Terminal createTerminal(String name, String city) {
		return new TrainStation(name, city);
	}


	public TrainStationCreator getInstance() {
		if (this.instance == null) {
			this.instance = new TrainStationCreator();
		}
		return this.instance;
	}

}