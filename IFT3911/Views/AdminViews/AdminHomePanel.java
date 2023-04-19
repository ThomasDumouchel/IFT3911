package Views.AdminViews;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Views.TripEventListener;

public class AdminHomePanel extends JPanel {

    private AdminGUI context;

	public AdminHomePanel(AdminGUI context) {
		super();
		this.context = context;

		JButton searchTripsButton = new JButton("Plane");
		JButton button2 = new JButton("Train");
		JButton button3 = new JButton("Cruise");
		JPanel searchTripsPanel = new JPanel();
		searchTripsPanel.setLayout(new BoxLayout(searchTripsPanel, BoxLayout.X_AXIS));
		searchTripsPanel.add(searchTripsButton);
		searchTripsPanel.add(button2);
		searchTripsPanel.add(button3);


		JButton createPlaneTrip = new JButton("Plane");
		JButton createTrainTrip = new JButton("Train");
		JButton createCruiseTrip = new JButton("Cruise");
		JPanel createTripPanel = new JPanel();
		createTripPanel.setLayout(new BoxLayout(createTripPanel, BoxLayout.X_AXIS));
		createTripPanel.add(createPlaneTrip);
		createTripPanel.add(createTrainTrip);
		createTripPanel.add(createCruiseTrip);

		// Set button listeners
		searchTripsButton.addActionListener(e -> {
			this.context.changeCard("searchTrips");
		});

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("Search trips"));
		add(searchTripsPanel);
		add(new JLabel("Create a trip"));
		add(createTripPanel);


	}

}