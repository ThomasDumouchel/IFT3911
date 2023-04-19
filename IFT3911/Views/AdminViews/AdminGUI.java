package Views.AdminViews;

import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.AdminPlaneTripController;
import Views.TripEventListener;

public class AdminGUI extends JFrame implements TripEventListener {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private AdminHomePanel homePanel;
    private AdminSearchTripsPanel searchTripsPanel;
    private AdminPlaneTripController planeTripController;
    // private JPanel createPlaneTripPanel;

	public AdminGUI(
        AdminPlaneTripController planeTripController
    ) {
        super();
        this.planeTripController = planeTripController;

		// Set the title and size of the frame
        setTitle("Admin system");
        setSize(400, 400);

		this.homePanel = new AdminHomePanel(this);

		this.searchTripsPanel = new AdminSearchTripsPanel(this);

		// JPanel createPlaneTripPanel = new JPanel();

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(this.cardLayout);

		this.cardPanel.add(homePanel, "home");
		this.cardPanel.add(searchTripsPanel, "searchTrips");
		// add(createPlaneTripPanel, "createPlaneTrip");

        // Add the card panel to the frame
        setContentPane(this.cardPanel);

        // By default, the first panel shown is "home"
        this.changeCard("home");

        // Set the default close operation for the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Show the frame
        // pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}

    public void changeCard(String cardName) {
        this.cardLayout.show(this.cardPanel, cardName);
    }

    public void onClicked(String action) {
        switch (action) {
            case "searchTrips":
                this.cardLayout.show(this, "searchTrips");
                break;
            case "createPlaneTrip":
                this.cardLayout.show(this, "createPlaneTrip");
                break;
            default:
                break;
        }
    }

    @Override
    public void update(String objectId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }



}
