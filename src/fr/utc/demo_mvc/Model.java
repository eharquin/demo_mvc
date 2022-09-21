package fr.utc.demo_mvc;

import java.util.*;
import java.beans.*;
import java.awt.Color;

/**
 * The model will store data and update the view when changing.
 */
public class Model {

    private PropertyChangeSupport support;
    private Map<String, Color> nameColorMap;

    public Model(Map<String, Color> nameColorMap) {
        this.support = new PropertyChangeSupport(this);
        this.nameColorMap = nameColorMap;
    }

    /**
     * Set the current color and updates the UI
     *
     * @param colorName Color value
     */
    public void setColor(String colorName) {
        Color selectedColor = this.nameColorMap.get(colorName);
        support.firePropertyChange("selectedColor", null, selectedColor);
    }

    /**
     * Adds a property change listener to update the view when data changes.
     *
     * @param pcl Listener
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    /**
     * Removes a previously set listener.
     *
     * @param pcl Listener
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}