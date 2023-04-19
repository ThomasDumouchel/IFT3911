package Views.HomeViews;

import javax.swing.*;

import Views.AdminViews.AdminGUI;
import Views.AdminViews.AdminHomePanel;

import java.awt.*;

public class HomeGUI {

    public static void main(String[] args) {
        // create a new JFrame to hold two buttons
        JFrame frame = new JFrame("Vacation system");

        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Set the location of the frame to the center of the screen
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

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
            AdminGUI adminGui = new AdminGUI();
            adminGui.setVisible(true);
        });
        
        // add buttons to panel
        panel.add(clientButton);
        panel.add(adminButton);


        // add panel to frame
        frame.add(panel);
        // set frame to be visible
        frame.setVisible(true);
    }

}