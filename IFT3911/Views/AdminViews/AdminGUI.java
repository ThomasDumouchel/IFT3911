package Views.AdminViews;

import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Views.TripEventListener;

public class AdminGUI extends JFrame implements TripEventListener {

    private CardLayout cardLayout;

	public AdminGUI() {
		// Set the title and size of the frame
        setTitle("Admin system");
        setSize(400, 400);

		var homePanel = new AdminHomePanel();
        homePanel.setListener(this);

		var searchTripsPanel = new AdminSearchTripsPanel();
        searchTripsPanel.setListener(this);

		JPanel createPlaneTripPanel = new JPanel();

        this.cardLayout = new CardLayout();
		setLayout(this.cardLayout);
		add(homePanel, "home");
		add(searchTripsPanel, "searchTrips");
		add(createPlaneTripPanel, "createPlaneTrip");

        // By default, the first panel shown is "home"
        this.cardLayout.show(this, "home");

        // Set the default close operation for the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
