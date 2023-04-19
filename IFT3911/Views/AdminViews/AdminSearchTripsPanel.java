package Views.AdminViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.TripModel.Company;
import Models.TripModel.Terminal;
import Views.components.CustomSelect;

public class AdminSearchTripsPanel extends JPanel {

	private AdminGUI context;

	public AdminSearchTripsPanel(AdminGUI context) {
		super();
		this.context = context;

		// Set panel content
		JButton backButton = new JButton("Back");

		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		header.add(backButton);
		header.add(new JLabel("Search trips"));

		JPanel searchByTerminal = new JPanel();
		searchByTerminal.setLayout(new BoxLayout(searchByTerminal, BoxLayout.Y_AXIS));
		Terminal[] terminals = new Terminal[] { };
		CustomSelect<Terminal> originSelect = new CustomSelect<Terminal>("Origin", terminals);
		CustomSelect<Terminal> destinationSelect = new CustomSelect<Terminal>("Destination", terminals);
		searchByTerminal.add(originSelect);
		searchByTerminal.add(destinationSelect);
		searchByTerminal.setMaximumSize(searchByTerminal.getPreferredSize());


		JPanel searchByCompany = new JPanel();
		searchByCompany.setLayout(new BoxLayout(searchByCompany, BoxLayout.Y_AXIS));
		Company[] companies = new Company[] { };
		CustomSelect<Company> companySelect = new CustomSelect<Company>("Company", companies);
		searchByCompany.add(companySelect);
		searchByCompany.setMaximumSize(searchByCompany.getPreferredSize());

		JButton searchButton = new JButton("Search");

		// Set button listeners
		backButton.addActionListener(e -> {
			this.context.changeCard("home");
		});


		// Set final layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(header);
		add(searchByTerminal);
		add(new JLabel("Or"));
		add(searchByCompany);
		add(searchButton);

	}


}