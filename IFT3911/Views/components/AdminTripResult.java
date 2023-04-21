package Views.components;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.TripModel.Trip;
import Views.TripVisitors.AdminTripVisitor;

public class AdminTripResult extends JPanel {

    private Trip trip;

    public AdminTripResult(Trip trip) {
        super();
        this.trip = trip;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JLabel tripVisit = new JLabel(this.trip.accept(new AdminTripVisitor()));
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        add(tripVisit);
        add(editButton);
        add(deleteButton);

        // Add listeners
        editButton.addActionListener(e -> {

        });

        deleteButton.addActionListener(e -> {

        });

    }
    
}
