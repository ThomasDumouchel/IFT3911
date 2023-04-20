package Controllers.Factories;

import Controllers.CreateSectionArgs;
import Models.TrainTripModel.TrainLine;
import Models.TrainTripModel.TrainStation;
import Models.TrainTripModel.TrainTrip;
import Models.TripModel.Company;
import Models.TripModel.Section;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;

public class TrainTripFactory implements ITripFactory {

	private static TrainTripFactory instance;

	public static TrainTripFactory getInstance() {
		if (instance == null) {
			instance = new TrainTripFactory();
		}
		return instance;
	}

    @Override
    public Terminal createTerminal(String terminal_code, String name, String city) {
        return new TrainStation(name, terminal_code, city);
    }

    @Override
    public Company createCompany(String name, String prefix) {
        return new TrainLine(name, prefix);
    }

    @Override
    public Section createSection(CreateSectionArgs args) {
        CreateTrainSectionArgs planeSectionArgs = (CreateTrainSectionArgs)args;
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CreateSection'");
    }

    @Override
    public Trip createTrip(Company company, Double fullPrice) {
        return new TrainTrip((TrainLine)company, fullPrice);
    }
    
}
