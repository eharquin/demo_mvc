package fr.utc.demo_mvc;

import java.util.*;
import javax.swing.event.*;
import javax.swing.*;

/**
 * The controller class will implement the logic between interface changes
 * and changes to the model data.
 */
public class Controller implements ListSelectionListener {

    private Model model;

    /**
     * The controller constructor assigns a model to that controller.
     * @param model
     */
    public Controller(Model model) {
        this.model = model;
    }

    /**
     * This function gets called everytime the user changes an input
     * on the GUI, and is responsible for updating the interface accordingly.
     *
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = ((JList) e.getSource()).getSelectionModel();
        String selectedColor = (String) ((JList) e.getSource()).getSelectedValue();

        if (!lsm.isSelectionEmpty()) {
            this.model.setColor(selectedColor);
        }
    }
}