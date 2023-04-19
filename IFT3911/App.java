import Controllers.VacationSystem;
import DAOs.Company.CompanyDAO;
import DAOs.Terminal.TerminalDAO;
import DAOs.Trip.TripDAO;
import Managers.PlaneTripManager;
import Models.PlaneTripModel.AirportCreator;
import Views.HomeViews.HomeGUI;

public class App {
    // main
    public static void main(String[] args) {
        // Create DAOS
        CompanyDAO companyDAO = new CompanyDAO();
        TripDAO tripDAO = new TripDAO();
        TerminalDAO terminalDAO = new TerminalDAO();

        // Create Factories
        AirportCreator airportCreator = new AirportCreator();

        // Create Managers
        PlaneTripManager planeTripManager = new PlaneTripManager(
            tripDAO,
            companyDAO,
            terminalDAO,
            airportCreator
        );

        // Create Controllers
        VacationSystem vacationSystem = new VacationSystem(
            planeTripManager
        );

        // Create Views
        HomeGUI homeGUI = new HomeGUI(vacationSystem);

        // Run
        homeGUI.run();
    }
}


