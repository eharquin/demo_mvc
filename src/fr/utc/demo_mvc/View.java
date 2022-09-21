package fr.utc.demo_mvc;

import javax.swing.*;
import java.awt.*;
import javax.swing.JScrollPane.*;
import java.util.*;
import java.beans.*;

/**
 * The view constitutes the interface shown to the user.
 */
public class View extends JFrame implements PropertyChangeListener {

    private static final long serialVersionUID = 1234567L;

    private JPanel panel;

    /**
     * The view constructor assigns a controller to that view.
     * @param controller Controller handling changes to the view
     * @param colors The list of colors that will be displayed to users.
     */
    public View(Controller controller, String[] colors) {

        this.setLayout(new GridLayout(1, 2));

        JList<String> list = new JList<String>(colors);
        list.addListSelectionListener(controller);

        JScrollPane dropdownList = new JScrollPane(list);
        dropdownList.setPreferredSize(new Dimension(300, 300));
        this.add(dropdownList);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(100, 100));
        this.add(panel);

        this.pack();
    }

    /**
     * Logic behind a property change event.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        this.panel.setBackground((Color) evt.getNewValue());
    }
}