package Views.components;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomSelect<T> extends JPanel {

    private DefaultComboBoxModel<T> model;

    public CustomSelect(String label, T[] items) {
        super();
        this.model = new DefaultComboBoxModel<T>(items);
        JComboBox<T> comboBox = new JComboBox<T>();
        comboBox.setModel(model);
        // comboBox.setSelectedIndex(0);
        JLabel labelComponent = new JLabel(label);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(labelComponent);
        add(comboBox);
    }

    public T getSelectedItem() {
        return (T)model.getSelectedItem();
    }

    public void setItems(T[] items) {
        model.removeAllElements();
        for (T item : items) {
            model.addElement(item);
        }
    }
}
