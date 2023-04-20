package Managers;

import java.util.ArrayList;
import java.util.List;

import Controllers.Factories.ITripFactory;
import Controllers.Factories.SelectTripFactoryStrategy;
import DAOs.Company.CompanyDAO;
import DAOs.Terminal.TerminalDAO;
import DAOs.Trip.DBTrip;
import DAOs.Trip.TripDAO;
import DAOs.Trip.TripType;
import Models.TripModel.Company;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;

public class TripManager {

    private SelectTripFactoryStrategy selectTripFactoryStrategy;
    private TerminalDAO terminalDAO;
    private CompanyDAO companyDAO;
    private TripDAO tripDAO;

    public TripManager(TerminalDAO terminalDAO, CompanyDAO companyDAO, TripDAO tripDAO) {
        selectTripFactoryStrategy = new SelectTripFactoryStrategy();
        this.terminalDAO = terminalDAO;
        this.companyDAO = companyDAO;
    }

    public Terminal createTerminal(TripType tripType, String terminal_code, String name, String city) {
        // TODO: Verify that there is no terminal with the same terminal_code for the trip type

        // 1. Choose the factory based on the trip type
        ITripFactory factory = selectTripFactoryStrategy.selectTripFactory(tripType);
        // 2. Create the terminal using the factory
        Terminal terminal = factory.createTerminal(terminal_code, name, city);
        // 3. Add the terminal to the database
        terminalDAO.addTerminal(tripType, terminal);
        // 4. Return the terminal
        return terminal;
    }

    public List<Trip> getTrips(TripType tripType, String origin_id, String destination_id) {
        // First call the TripDAO to get all the trips of a certain type that
        // have have origin and destination with the given ids
        List<DBTrip> dbTrips = tripDAO.getAllOfType(tripType);
        List<Trip> trips = new ArrayList<>();
        for (DBTrip dbTrip : dbTrips) {
            Trip trip = ToAppModel(dbTrip);
            if (trip.getOrigin().getId().equals(origin_id) && trip.getDestination().getId().equals(destination_id)) {
                trips.add(trip);
            }
        }
        return trips;
    }

    public List<Trip> getTrips(TripType tripType, String companyId) {
        List<DBTrip> dbTrips = tripDAO.getAllOfType(tripType);
        List<Trip> trips = new ArrayList<>();
        for (DBTrip dbTrip : dbTrips) {
            Trip trip = ToAppModel(dbTrip);
            if (trip.getCompany().getId().equals(companyId)) {
                trips.add(trip);
            }
        }
        return trips;
    }

    public static Trip ToAppModel(DBTrip dbWrapper) {
        //TODO:
        // 1. Find the company of this trip
        // Company company = companyDAO.getCompany(tripType, dbTrip.getCompanyId());
        // // 2. Generate the trip with the company
        // Trip trip = factory.createTrip(dbTrip);
        return null;
    }

    public List<Terminal> getTerminals(TripType tripType) {
        return terminalDAO.getTerminals(tripType);
    }

    public List<Company> getCompanies(TripType tripType) {
        return companyDAO.getCompanies(tripType);
    }


    
}
