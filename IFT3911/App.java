import Controllers.VacationSystem;
import DAOs.Company.CompanyDAO;
import DAOs.Terminal.TerminalDAO;
import DAOs.Trip.TripDAO;
import Managers.TripManager;

import Views.HomeViews.HomeGUI;

public class App {
    // main
    public static void main(String[] args) {
        // Create DAOS
        TerminalDAO terminalDAO = new TerminalDAO();
        CompanyDAO companyDAO = new CompanyDAO();
        TripDAO tripDAO = new TripDAO();

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


