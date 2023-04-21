package Views.AdminViews;

import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.AdminController;
import DAOs.Trip.TripType;
import DAOs.TripObserver.TripEventListener;
import Models.TripModel.Company;
import Models.TripModel.Terminal;
import Models.TripModel.Trip;
import Views.AdminCommands.AdminCommand;
import Views.AdminCommands.AdminCommandHistory;

public class AdminGUI extends JFrame implements TripEventListener {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private AdminHomePanel homePanel;
    private AdminSearchResultsPanel searchResultsPanel;
    private AdminSearchTripsPanel searchTripsPanel;
    private AdminController adminController;
    private AdminCommandHistory adminCommandHistory;

	public AdminGUI(
        AdminController adminController
    ) {
        super();
        this.adminController = adminController;
        this.adminCommandHistory = new AdminCommandHistory();

		// Set the title and size of the frame
        setTitle("Admin system");
        setSize(400, 400);

		this.homePanel = new AdminHomePanel(this);
		this.searchTripsPanel = new AdminSearchTripsPanel(this);
        this.searchResultsPanel = new AdminSearchResultsPanel(this);

		// JPanel createPlaneTripPanel = new JPanel();

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(this.cardLayout);

		this.cardPanel.add(homePanel, "home");
		this.cardPanel.add(searchTripsPanel, "searchTrips");
        this.cardPanel.add(searchResultsPanel, "searchResults");

        // Add the card panel to the frame
        setContentPane(this.cardPanel);

        // By default, the first panel shown is "home"
        this.goToHome();

        // Set the default close operation for the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add a key listener for Ctrl+Z
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
                    undo();
               }
            }
         });

        // Show the frame
        setLocationRelativeTo(null);
        setVisible(true);
	}

    private void changeCard(String cardName) {
        this.cardLayout.show(this.cardPanel, cardName);
    }

    public void goToHome(){
        changeCard("home");
    }

    public void goToSearchTrips(TripType tripType) {
        var airports = this.adminController.GetTerminals(tripType);
        this.searchTripsPanel.setTerminals(airports);
        var airlines = this.adminController.GetCompanies(tripType);
        this.searchTripsPanel.setCompanies(airlines);

        this.searchTripsPanel.setTripType(tripType);
        changeCard("searchTrips");
    }

    public void goToSearchResults(TripType tripType, Terminal origin, Terminal destination, Company company) {
        List<Trip> trips = new ArrayList<>();
        if (company != null){ // if company is selected, we default to company search
            trips = this.adminController.GetTrips(tripType, company.getId());
        }
        else if (origin != null && destination != null) { // if origin and destination are selected, we default to origin and destination search
            trips = this.adminController.GetTrips(tripType, origin.getId(), destination.getId());
        }
        else { // if no company, origin or destination are selected, we default to all trips
            
        }
        this.searchResultsPanel.setTrips(trips);
        this.searchResultsPanel.setTripType(tripType);
        changeCard("searchResults");
    }

    public AdminController getController() {
        return this.adminController;
    }

    public void executeCommand(AdminCommand<?> command) {
        command.execute();
        // TODO: maybe add a check to see if the command was successful
        this.adminCommandHistory.push(command);
    }

    public void undo() {
        AdminCommand<?> command = this.adminCommandHistory.pop();
        if (command != null) {
            command.undo();
        }
    }

    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
