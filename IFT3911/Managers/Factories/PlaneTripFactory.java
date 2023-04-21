package Managers.Factories;

import Controllers.CreateSectionArgs;
import Models.PlaneTripModel.Airline;
import Models.PlaneTripModel.Airport;
import Models.PlaneTripModel.PlaneBusinessClass;
import Models.PlaneTripModel.PlaneEconomyClass;
import Models.PlaneTripModel.PlaneEconomyPremiumClass;
import Models.PlaneTripModel.PlaneFirstClass;
import Models.PlaneTripModel.PlaneSectionType;
import Models.PlaneTripModel.PlaneTrip;
import Models.TripModel.Company;
import Models.TripModel.ISectionType;
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
    public Section createSection(ISectionType sectionType, CreateSectionArgs args) {
        CreatePlaneSectionArgs planeSectionArgs = (CreatePlaneSectionArgs)args;
        PlaneSectionType planeSectionType = (PlaneSectionType)sectionType;
        switch (planeSectionType) {
            case ECONOMY:
                return new PlaneEconomyClass(planeSectionArgs.getLayoutType(), planeSectionArgs.getRows());
            case ECONOMY_PREMIUM:
                return new PlaneEconomyPremiumClass(planeSectionArgs.getLayoutType(), planeSectionArgs.getRows());
            case BUSINESS:
                return new PlaneBusinessClass(planeSectionArgs.getLayoutType(), planeSectionArgs.getRows());
            case FIRST:
                return new PlaneFirstClass(planeSectionArgs.getLayoutType(), planeSectionArgs.getRows());
            default:
                throw new UnsupportedOperationException("Section type not supported");
        }
    }

    @Override
    public Trip createTrip(Company company, Double fullPrice) {
        return new PlaneTrip((Airline)company, fullPrice);
    }
    
}
