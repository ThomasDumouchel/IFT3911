package Controllers.Factories;

import Controllers.CreateSectionArgs;
import Models.TripModel.Company;
import Models.TripModel.ISectionType;
import Models.TripModel.Section;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;

public interface ITripFactory {

    public Terminal createTerminal(String terminal_code, String name, String city);

    public Company createCompany(String name, String prefix);

    public Section createSection(ISectionType sectionType, CreateSectionArgs args);
    
    public Trip createTrip(Company company, Double fullPrice);

}
