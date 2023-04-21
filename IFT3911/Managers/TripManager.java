package Managers;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Controllers.CreateSectionArgs;
import DAOs.Company.CompanyDAO;
import DAOs.Terminal.TerminalDAO;
import DAOs.Trip.DBTrip;
import DAOs.Trip.TripDAO;
import DAOs.Trip.TripType;
import Managers.Factories.ITripFactory;
import Managers.Factories.SelectTripFactoryStrategy;
import Models.Payment.PaymentInfo;
import Models.TripModel.Client;
import Models.TripModel.Company;
import Models.TripModel.ISectionType;
import Models.TripModel.Reservable;
import Models.TripModel.ReservationOption;
import Models.TripModel.Section;
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

    public Company createCompany(TripType tripType, String name, String prefix) {
        // TODO: Verify that there is no company with the same name for the trip type
        // 1. Choose the factory based on the trip type
        ITripFactory factory = selectTripFactoryStrategy.selectTripFactory(tripType);
        // 2. Create the terminal using the factory
        Company company = factory.createCompany(name, prefix);
        // 3. Add the terminal to the database
        companyDAO.addCompany(tripType, company);
        // 4. Return the terminal
        return company;
    }

    public Section createSection(TripType tripType, ISectionType sectionType, CreateSectionArgs createSectionArgs) {
        // 1. Choose the factory based on the trip type
        ITripFactory factory = selectTripFactoryStrategy.selectTripFactory(tripType);
        // 2. Create the terminal using the factory
        Section section = factory.createSection(sectionType, createSectionArgs);
        // 4. Return the terminal
        return section;
    }

    public Trip createTrip(TripType tripType, String company_name, Double fullPrice) {
        // TODO: Verify that there is no company with the same name for the trip type
        Company company = companyDAO.getCompany(tripType, company_name);
        // 1. Choose the factory based on the trip type
        ITripFactory factory = selectTripFactoryStrategy.selectTripFactory(tripType);
        // 2. Create the terminal using the factory
        Trip trip = factory.createTrip(company, fullPrice);
        // 3. Add the terminal to the database
        tripDAO.addTrip(tripType, trip);
        // 4. Return the terminal
        return trip;
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

    public List<Trip> getTrips(
        TripType tripType, 
        String originId,
        String destinationId, 
        Date date,
        ISectionType sectionType
    ) {
        List<DBTrip> dbTrips = tripDAO.getAllOfType(tripType);
        List<Trip> trips = new ArrayList<>();
        for (DBTrip dbTrip : dbTrips) {
            Trip trip = ToAppModel(dbTrip);
            if (trip.getOrigin().getId().equals(originId) && 
                trip.getDestination().getId().equals(destinationId) &&
                isSameDay(trip.getFirstTravel().getDepartureTime(), date) &&
                trip.getTransport().getSection(sectionType) != null) {
                    trips.add(trip);
            }
        }
        return trips;
    }

    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    public Trip ToAppModel(DBTrip dbTrip) {
        Trip trip = createTrip(dbTrip.getType(), dbTrip.getCompanyId(), dbTrip.getFullPrice());
        trip.setTranport(dbTrip.getTransport());
        trip.setTravels(dbTrip.getTravels());
        return trip;
    }

    public List<Terminal> getTerminals(TripType tripType) {
        return terminalDAO.getTerminals(tripType);
    }

    public List<Company> getCompanies(TripType tripType) {
        return companyDAO.getCompanies(tripType);
    }

    public Terminal updateTerminal(TripType tripType, String terminal_code, Terminal updated_terminal) {
        return this.terminalDAO.updateTerminal(tripType, terminal_code, updated_terminal);
    }

    public Terminal deleteTerminal(TripType tripType, String terminal_code) {
        return this.terminalDAO.deleteTerminal(tripType, terminal_code);
    }

    public Company updateCompany(TripType tripType, String name, Company updated_company) {
        return this.companyDAO.updateCompany(tripType, updated_company);
    }

    public Company deleteCompany(TripType tripType, String name) {
        return this.companyDAO.deleteCompany(tripType, name);
    }

    public Trip updateTrip(TripType tripType, String id, Trip updated_trip) {
        return ToAppModel(this.tripDAO.updateTrip(tripType, id, updated_trip));
    }

    public Trip deleteTrip(TripType tripType, String id) {
        return ToAppModel(this.tripDAO.deleteTrip(tripType, id));
    }

    public Section updateSection(TripType tripType, String id, Section updated_section) {
        return null;
    }

    public Section deleteSection(TripType tripType, String id) {
        return null;
    }

    public Reservable reserveTrip(TripType tripType, String tripId, ISectionType sectionType, ReservationOption option) {
        // 1. Get the trip from the database
        DBTrip dbTrip = tripDAO.getTrip(tripType, tripId);
        // 2. Convert the trip to the app model
        Trip trip = ToAppModel(dbTrip);
        // 3. Get the section from the trip
        Section section = trip.getTransport().getSection(sectionType);
        if (section == null) {
            throw new RuntimeException("The trip does not have a section of type " + sectionType);
        }
        // 4. Make a reservation
        Reservable reservable = section.reserve(option);
        // 5. Save the reservation
        updateTrip(tripType, tripId, trip);
        // 6. Return the reservable
        return reservable;
    }


    public Reservable confirm(String reservationId, PaymentInfo paymentInfo, Client client) {
        return null;
    }


    
}
