import Controllers.VacationSystem;
import DAOs.Company.CompanyDAO;
import DAOs.Trip.TripDAO;
import Managers.PlaneTripManager;
import Views.HomeViews.HomeGUI;

public class App {
    // main
    public static void main(String[] args) {
        // Create DAOS
        CompanyDAO companyDAO = new CompanyDAO();
        TripDAO tripDAO = new TripDAO();

        // Create Managers
        PlaneTripManager planeTripManager = new PlaneTripManager(
            tripDAO,
            companyDAO
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


