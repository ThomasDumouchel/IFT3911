package Views.AdminViews;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAOs.Trip.TripType;
import Models.TripModel.Company;
import Models.TripModel.Terminal;
import Views.components.CustomSelect;

public class AdminSearchTripsPanel extends JPanel {

	private AdminGUI context;
	private TripType tripType;
	private Terminal[] terminals;
	private Company[] companies;
	private CustomSelect<Terminal> originSelect;
	private CustomSelect<Terminal> destinationSelect;
	private CustomSelect<Company> companySelect;

	public void setTripType(TripType tripType) {
		this.tripType = tripType;
	}

	public void setTerminals(List<? extends Terminal> terminals) {
		this.terminals = terminals.toArray(new Terminal[terminals.size()]);
		originSelect.setItems(this.terminals);
		destinationSelect.setItems(this.terminals);
	}

	public void setCompanies(List<? extends Company> companies) {
		this.companies = companies.toArray(new Company[companies.size()]);
		companySelect.setItems(this.companies);
	}

	public AdminSearchTripsPanel(AdminGUI context) {
		super();
		this.context = context;
		this.tripType = TripType.PLANE;
		this.terminals = new Terminal[0];
		this.companies = new Company[0];

		// Set panel content
		JButton backButton = new JButton("Back");

		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		header.add(backButton);
		header.add(new JLabel("Search trips"));

		JPanel searchByTerminal = new JPanel();
		searchByTerminal.setLayout(new BoxLayout(searchByTerminal, BoxLayout.Y_AXIS));
		this.originSelect = new CustomSelect<Terminal>("Origin", terminals);
		this.destinationSelect = new CustomSelect<Terminal>("Destination", terminals);
		searchByTerminal.add(originSelect);
		searchByTerminal.add(destinationSelect);
		searchByTerminal.setMaximumSize(searchByTerminal.getPreferredSize());

		JPanel searchByCompany = new JPanel();
		searchByCompany.setLayout(new BoxLayout(searchByCompany, BoxLayout.Y_AXIS));
		this.companySelect = new CustomSelect<Company>("Company", companies);
		searchByCompany.add(companySelect);
		searchByCompany.setMaximumSize(searchByCompany.getPreferredSize());

		JButton searchButton = new JButton("Search");

		// Set button listeners
		backButton.addActionListener(e -> {
			this.context.goToHome();
		});

		searchButton.addActionListener(e -> {
			this.context.goToSearchResults(
				tripType,
				originSelect.getSelectedItem(),
				destinationSelect.getSelectedItem(),
				companySelect.getSelectedItem()
			);
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