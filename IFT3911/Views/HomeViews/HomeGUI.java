package Views.HomeViews;

import javax.swing.*;

import Controllers.VacationSystem;
import Views.AdminViews.AdminGUI;

import java.awt.*;

public class HomeGUI extends JFrame {

    private VacationSystem vacationSystem;

    public HomeGUI(VacationSystem vacationSystem) {
        this.vacationSystem = vacationSystem;
        setTitle("Vacation System");

        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Set the location of the frame to the center of the screen
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        // create a panel to hold all other components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // create buttons Client and Admin. Make them 200x100 and
        // center them in the panel
        JButton clientButton = new JButton("Client");
        clientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clientButton.setMaximumSize(new Dimension(200, 100));

        JButton adminButton = new JButton("Admin");
        adminButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminButton.setMaximumSize(new Dimension(200, 100));

        // add action listeners to buttons that will open 
        // a new window when clicked.
        clientButton.addActionListener(e -> {

        });

        adminButton.addActionListener(e -> {
            AdminGUI adminGui = new AdminGUI(vacationSystem);
            adminGui.setVisible(true);
        });
        
        // add buttons to panel
        panel.add(clientButton);
        panel.add(adminButton);

        // add panel to frame
        add(panel);

        // Set the default close operation for the frame
        // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void run() {
        // make frame visible
        setVisible(true);
    }

}