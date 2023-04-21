package Views.AdminViews;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAOs.Trip.TripType;
import Views.AdminCommands.AdminCommandDeleteTrip;

public class AdminHomePanel extends JPanel {

    private AdminGUI context;

	public AdminHomePanel(AdminGUI context) {
		super();
		this.context = context;

		JButton searchPlaneTrips = new JButton("Plane");
		JButton searchTrainTrips = new JButton("Train");
		JButton searchCruiseTrips = new JButton("Cruise");
		JPanel searchTripsPanel = new JPanel();
		searchTripsPanel.setLayout(new BoxLayout(searchTripsPanel, BoxLayout.X_AXIS));
		searchTripsPanel.add(searchPlaneTrips);
		searchTripsPanel.add(searchTrainTrips);
		searchTripsPanel.add(searchCruiseTrips);


		JButton createPlaneTrip = new JButton("Plane");
		JButton createTrainTrip = new JButton("Train");
		JButton createCruiseTrip = new JButton("Cruise");
		JPanel createTripPanel = new JPanel();
		createTripPanel.setLayout(new BoxLayout(createTripPanel, BoxLayout.X_AXIS));
		createTripPanel.add(createPlaneTrip);
		createTripPanel.add(createTrainTrip);
		createTripPanel.add(createCruiseTrip);

		// Set button listeners
		searchPlaneTrips.addActionListener(e -> {
			this.context.goToSearchTrips(TripType.PLANE);
		});

		searchTrainTrips.addActionListener(e -> {
			this.context.goToSearchTrips(TripType.TRAIN);
		});

		searchCruiseTrips.addActionListener(e -> {
			this.context.goToSearchTrips(TripType.CRUISE);
		});

		createPlaneTrip.addActionListener(e -> {
			AdminCommandDeleteTrip command = new AdminCommandDeleteTrip(this.context, TripType.PLANE, "name");
			this.context.executeCommand(command);
		});

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("Search trips"));
		add(searchTripsPanel);
		add(new JLabel("Create a trip"));
		add(createTripPanel);


	}

}