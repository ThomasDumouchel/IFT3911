package Views.AdminViews;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Views.TripEventListener;

public class AdminHomePanel extends JPanel {

    private AdminGUI listener;

	public AdminHomePanel() {
		super(new BorderLayout());
		// fill jpanel with 1 label and 3 buttons underneath it
		JLabel label = new JLabel("My Panel");
		add(label, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

		JButton searchTripsButton = new JButton("Search trips");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");

		// Set button listeners
		searchTripsButton.addActionListener(e -> {
			listener.onClicked("searchTrips");
		});

		buttonPanel.add(searchTripsButton);
		buttonPanel.add(button2);
		buttonPanel.add(button3);

		add(buttonPanel, BorderLayout.CENTER);

	}

	public void setListener(AdminGUI listener) {
		this.listener = listener;
	}

}