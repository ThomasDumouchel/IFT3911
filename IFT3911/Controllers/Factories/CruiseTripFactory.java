package Controllers.Factories;

import Controllers.CreateSectionArgs;
import Models.CruiseTripModel.CruiseLine;
import Models.CruiseTripModel.CruiseTrip;
import Models.CruiseTripModel.Port;


import Models.TripModel.Company;
import Models.TripModel.Section;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;

public class CruiseTripFactory implements ITripFactory {

	private static CruiseTripFactory instance;

	public static CruiseTripFactory getInstance() {
		if (instance == null) {
			instance = new CruiseTripFactory();
		}
		return instance;
	}

    @Override
    public Terminal createTerminal(String terminal_code, String name, String city) {
        return new Port(name, terminal_code, city);
    }

    @Override
    public Company createCompany(String name, String prefix) {
        return new CruiseLine(name, prefix);
    }

    @Override
    public Section createSection(CreateSectionArgs args) {
        CreateCruiseSectionArgs planeSectionArgs = (CreateCruiseSectionArgs)args;
        throw new UnsupportedOperationException("Unimplemented method 'CreateSection'");
    }

    @Override
    public Trip createTrip(Company company, Double fullPrice) {
        return new CruiseTrip((CruiseLine)company, fullPrice);
    }
    
}
