package Managers.Factories;

import Controllers.CreateSectionArgs;
import Models.CruiseTripModel.CruiseFamilyDeluxeSection;
import Models.CruiseTripModel.CruiseFamilySection;
import Models.CruiseTripModel.CruiseInteriorSection;
import Models.CruiseTripModel.CruiseLine;
import Models.CruiseTripModel.CruiseOceanVueSection;
import Models.CruiseTripModel.CruiseSectionType;
import Models.CruiseTripModel.CruiseSuiteSection;
import Models.CruiseTripModel.CruiseTrip;
import Models.CruiseTripModel.Port;


import Models.TripModel.Company;
import Models.TripModel.ISectionType;
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
    public Section createSection(ISectionType sectionType, CreateSectionArgs args) {
        CreateCruiseSectionArgs cruiseSectionArgs = (CreateCruiseSectionArgs)args;
        CruiseSectionType cruiseSectionType = (CruiseSectionType)sectionType;
        switch (cruiseSectionType) {
            case INTERIOR:
                return new CruiseInteriorSection(cruiseSectionArgs.getNbCabins());
            case OCEAN_VIEW:
                return new CruiseOceanVueSection(cruiseSectionArgs.getNbCabins());
            case SUITE:
                return new CruiseSuiteSection(cruiseSectionArgs.getNbCabins());
            case FAMILY:
                return new CruiseFamilySection(cruiseSectionArgs.getNbCabins());
            case FAMILY_DELUXE:
                return new CruiseFamilyDeluxeSection(cruiseSectionArgs.getNbCabins());
            default:
                throw new UnsupportedOperationException("Section type not supported");
        }
    }

    @Override
    public Trip createTrip(Company company, Double fullPrice) {
        return new CruiseTrip((CruiseLine)company, fullPrice);
    }
    
}
