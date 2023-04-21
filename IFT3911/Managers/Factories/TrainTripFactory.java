package Managers.Factories;

import Controllers.CreateSectionArgs;
import Models.TrainTripModel.TrainEconomyClass;
import Models.TrainTripModel.TrainFirstClass;
import Models.TrainTripModel.TrainLine;
import Models.TrainTripModel.TrainSectionType;
import Models.TrainTripModel.TrainStation;
import Models.TrainTripModel.TrainTrip;
import Models.TripModel.Company;
import Models.TripModel.ISectionType;
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
    public Section createSection(ISectionType sectionType, CreateSectionArgs args) {
        CreateTrainSectionArgs planeSectionArgs = (CreateTrainSectionArgs)args;
        TrainSectionType trainSectionType = (TrainSectionType)sectionType;
        switch (trainSectionType) {
            case FIRST:
                return new TrainFirstClass(planeSectionArgs.getRows());
            case ECONOMY:
                return new TrainEconomyClass(planeSectionArgs.getRows());
            default:
                throw new UnsupportedOperationException("Section type not supported");
        }
    }

    @Override
    public Trip createTrip(Company company, Double fullPrice) {
        return new TrainTrip((TrainLine)company, fullPrice);
    }
    
}
