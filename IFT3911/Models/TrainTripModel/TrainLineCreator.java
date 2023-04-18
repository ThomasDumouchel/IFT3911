package Models.TrainTripModel;
import Models.TripModel.Company;
import Models.TripModel.CompanyCreator;

public class TrainLineCreator extends CompanyCreator {

	private TrainLineCreator instance;

	public TrainLineCreator getInstance() {
		if (this.instance == null) {
			this.instance = new TrainLineCreator();
		}
		return this.instance;
	}

	/**
	 * 
	 * @param name
	 * @param prefix
	 */
	public Company createCompany(String name, String prefix) {
		return new TrainLine(name, prefix);
	}

}