package Views.AdminViews;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAOs.Trip.TripType;
import Models.TripModel.Trip;
import Views.components.AdminTripResult;

public class AdminSearchResultsPanel extends JPanel {

    private AdminGUI context;
    private TripType tripType;
    private List<? extends Trip> trips;

    public AdminSearchResultsPanel(AdminGUI context) {
        super();
        this.context = context;
        this.trips = new ArrayList<>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JButton backButton = new JButton("Back");
		header.add(backButton);
		header.add(new JLabel("Search results"));

        add(header);

        // Set panel content
        for (Trip trip : trips) {
            add(new AdminTripResult(trip));
        }

        // Add listeners
        backButton.addActionListener(e -> {
			this.context.goToSearchTrips(tripType);
		});
    }

    public void setTrips(List<? extends Trip> trips) {
        this.trips = trips;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

}
