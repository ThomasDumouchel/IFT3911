import Controllers.VacationSystem;
import DAOs.Company.CompanyDAO;
import Views.HomeViews.HomeGUI;

public class App {
    // main
    public static void main(String[] args) {
        // Create DAOS
        CompanyDAO companyDAO = new CompanyDAO();

        // Create Managers

        // Create Controllers
        VacationSystem vacationSystem = new VacationSystem(
            /* TODO: Add the managers */
        );

        // Create Views
        HomeGUI homeGUI = new HomeGUI(vacationSystem);

        // Run
        homeGUI.run();
    }
}
