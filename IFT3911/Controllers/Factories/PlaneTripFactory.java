package Controllers.Factories;

import Controllers.CreateSectionArgs;
import Models.PlaneTripModel.Airline;
import Models.PlaneTripModel.Airport;
import Models.PlaneTripModel.PlaneTrip;
import Models.TripModel.Company;
import Models.TripModel.Section;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;

public class PlaneTripFactory implements ITripFactory {

	private static PlaneTripFactory instance;

	public static PlaneTripFactory getInstance() {
		if (instance == null) {
			instance = new PlaneTripFactory();
		}
		return instance;
	}

    @Override
    public Terminal createTerminal(String terminal_code, String name, String city) {
        return new Airport(name, terminal_code, city);
    }

    @Override
    public Company createCompany(String name, String prefix) {
        return new Airline(name, prefix);
    }

    @Override
    public Section createSection(CreateSectionArgs args) {
        CreatePlaneSectionArgs planeSectionArgs = (CreatePlaneSectionArgs)args;
        throw new UnsupportedOperationException("Unimplemented method 'CreateSection'");
    }

    @Override
    public Trip createTrip(Company company, Double fullPrice) {
        return new PlaneTrip((Airline)company, fullPrice);
    }
    
}
