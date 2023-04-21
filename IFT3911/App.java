import java.sql.Date;
import java.text.SimpleDateFormat;

import Controllers.VacationSystem;
import DAOs.Company.CompanyDAO;
import DAOs.Terminal.TerminalDAO;
import DAOs.Trip.TripDAO;
import DAOs.Trip.TripType;
import DAOs.TripObserver.TripEventManager;
import Managers.PaymentManager;
import Managers.TripManager;
import Managers.Factories.CreatePlaneSectionArgs;
import Managers.Factories.PlaneTripFactory;
import Models.CruiseTripModel.CruiseLine;
import Models.CruiseTripModel.Port;
import Models.PlaneTripModel.Airport;
import Models.PlaneTripModel.PlaneSectionLayoutType;
import Models.PlaneTripModel.PlaneSectionType;
import Models.PlaneTripModel.Airline;
import Models.TrainTripModel.TrainLine;
import Models.TrainTripModel.TrainStation;
import Models.TripModel.Company;
import Models.TripModel.Terminal;
import Models.TripModel.Travel;
import Models.TripModel.Trip;
import Views.HomeViews.HomeGUI;

public class App {
    // main
    public static void main(String[] args) {        

        // Create observer manager
        TripEventManager tripEventManager = new TripEventManager();

        // Create DAOS
        TerminalDAO terminalDAO = new TerminalDAO(tripEventManager);
        CompanyDAO companyDAO = new CompanyDAO(tripEventManager);
        TripDAO tripDAO = new TripDAO(tripEventManager);

        // Create Managers
        TripManager tripManager = new TripManager(
            terminalDAO,
            companyDAO,
            tripDAO
        );

        PaymentManager paymentManager = new PaymentManager();

        // Create Controllers
        VacationSystem vacationSystem = new VacationSystem(
            tripManager,
            paymentManager
        );

        // Mock some data
        // Terminals
        vacationSystem.CreateTerminal(TripType.PLANE, "ABC", "Aeroport 1", "Buenos Aires");
        vacationSystem.CreateTerminal(TripType.PLANE, "DEF", "Aeroport 2", "Montreal");
        vacationSystem.CreateTerminal(TripType.PLANE, "NAG", "Aeroport 3", "CHina");
        vacationSystem.CreateTerminal(TripType.TRAIN, "XYZ", "Train station 1", "Buenos Aires");
        vacationSystem.CreateTerminal(TripType.TRAIN, "MUJ", "Train station 2", "Culcota");
        vacationSystem.CreateTerminal(TripType.TRAIN, "LPU", "Train station 3", "Damas");
        vacationSystem.CreateTerminal(TripType.CRUISE, "LYQ", "Port 1", "There");
        vacationSystem.CreateTerminal(TripType.CRUISE, "BJA", "Port 2", "Here");
        vacationSystem.CreateTerminal(TripType.CRUISE, "PIU", "Port 3", "Youpy");

        // Companies
        vacationSystem.CreateCompany(TripType.PLANE, "Air Canada", "AC");
        vacationSystem.CreateCompany(TripType.PLANE, "Delta Air Lines", "DL");
        vacationSystem.CreateCompany(TripType.PLANE, "United Airlines", "UA");
        vacationSystem.CreateCompany(TripType.TRAIN, "ChouChouTrain", "CC");
        vacationSystem.CreateCompany(TripType.TRAIN, "Eurostar", "ES");
        vacationSystem.CreateCompany(TripType.TRAIN, "Amtrak", "AM");
        vacationSystem.CreateCompany(TripType.CRUISE, "Carnival Cruise Line", "CC");
        vacationSystem.CreateCompany(TripType.CRUISE, "Royal Caribbean International", "RC");
        vacationSystem.CreateCompany(TripType.CRUISE, "Princess Cruises", "PC");

        // Trips
        /*
         * Charles. This is the order of calls that needs to be made 
         * to create a  trip.
         *  1. Create a trip
         *  2. Create travels and add them to the trip
         *  3. Create sections and add them to the trip 
         *  4. Update the trip
         */
        var trip = vacationSystem.CreateTrip(TripType.PLANE, "Air Canada", 1000.0);
        Travel<Airport> travel = new Travel<>(
            new Airport("ABC", "Aeroport 1", "Buenos Aires"),
            new Airport("DEF", "Aeroport 2", "Montreal"), 
            new Date(202012100000L),
            new Date(202012200000L)
        );
        trip.setTravel(travel);
        var planeSectionArgs1 = new CreatePlaneSectionArgs(10, PlaneSectionLayoutType.MEDIUM);
        var planeSection = vacationSystem.CreateSection(TripType.PLANE, PlaneSectionType.BUSINESS, planeSectionArgs1);
        var planeSectionArgs2 = new CreatePlaneSectionArgs(10, PlaneSectionLayoutType.MEDIUM);
        var planeSection2 = vacationSystem.CreateSection(TripType.PLANE, PlaneSectionType.ECONOMY, planeSectionArgs2);
        trip.getTransport().addSection(planeSection);
        trip.getTransport().addSection(planeSection2);
        vacationSystem.UpdateTrip(TripType.PLANE, trip.getId(), trip);

        var trip2 = vacationSystem.CreateTrip(TripType.PLANE, "Delta Air Lines", 900.0);
        Travel<Airport> travel2 = new Travel<>(
            new Airport("ABC", "Aeroport 1", "Buenos Aires"),
            new Airport("DEF", "Aeroport 2", "Montreal"), 
            new Date(202012400000L),
            new Date(202012500000L)
        );
        ((Trip) trip2).setTravel(travel2);
        var planeSectionArgs3 = new CreatePlaneSectionArgs(10, PlaneSectionLayoutType.TIGHT);
        var planeSection3 = vacationSystem.CreateSection(TripType.PLANE, PlaneSectionType.FIRST, planeSectionArgs3);
        var planeSectionArgs4 = new CreatePlaneSectionArgs(10, PlaneSectionLayoutType.MEDIUM);
        var planeSection4 = vacationSystem.CreateSection(TripType.PLANE, PlaneSectionType.BUSINESS, planeSectionArgs4);
        var planeSectionArgs5 = new CreatePlaneSectionArgs(10, PlaneSectionLayoutType.LARGE);
        var planeSection5 = vacationSystem.CreateSection(TripType.PLANE, PlaneSectionType.ECONOMY, planeSectionArgs5);
        ((Trip) trip2).getTransport().addSection(planeSection3);
        ((Trip) trip2).getTransport().addSection(planeSection4);
        ((Trip) trip2).getTransport().addSection(planeSection5);

        var trip3 = vacationSystem.CreateTrip(TripType.PLANE, "United Airlines", 800.0);
        Travel<Airport> travel3 = new Travel<>(
            new Airport("ABC", "Aeroport 1", "Buenos Aires"),
            new Airport("DEF", "Aeroport 2", "Montreal"), 
            new Date(202012600000L),
            new Date(202012700000L)
        );
        ((Trip) trip3).setTravel(travel3);
        var planeSectionArgs6 = new CreatePlaneSectionArgs(10, PlaneSectionLayoutType.TIGHT);
        var planeSection6 = vacationSystem.CreateSection(TripType.PLANE, PlaneSectionType.FIRST, planeSectionArgs6);
        var planeSectionArgs7 = new CreatePlaneSectionArgs(10, PlaneSectionLayoutType.MEDIUM);
        var planeSection7 = vacationSystem.CreateSection(TripType.PLANE, PlaneSectionType.BUSINESS, planeSectionArgs7);
        var planeSectionArgs8 = new CreatePlaneSectionArgs(10, PlaneSectionLayoutType.LARGE);
        var planeSection8 = vacationSystem.CreateSection(TripType.PLANE, PlaneSectionType.ECONOMY, planeSectionArgs8);
        ((Trip) trip3).getTransport().addSection(planeSection6);
        ((Trip) trip3).getTransport().addSection(planeSection7);
        ((Trip) trip3).getTransport().addSection(planeSection8); 


        // Create Views
        HomeGUI homeGUI = new HomeGUI(vacationSystem);

        // Run
        homeGUI.run();
    }
}


