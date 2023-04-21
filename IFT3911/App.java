import Controllers.VacationSystem;
import DAOs.Company.CompanyDAO;
import DAOs.Terminal.TerminalDAO;
import DAOs.Trip.TripDAO;
import DAOs.TripObserver.TripEventManager;
import Managers.TripManager;

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

        // Create Controllers
        VacationSystem vacationSystem = new VacationSystem(
            tripManager
        );

        // Create Views
        HomeGUI homeGUI = new HomeGUI(vacationSystem);

        // Run
        homeGUI.run();
    }
}


