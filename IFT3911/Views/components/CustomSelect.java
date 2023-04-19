package Views.components;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomSelect<T> extends JPanel {
    public CustomSelect(String label, T[] items) {
        super();

        JComboBox<T> comboBox = new JComboBox<T>(items);
        // comboBox.setSelectedIndex(0);
        JLabel labelComponent = new JLabel(label);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(labelComponent);
        add(comboBox);
    }
}
