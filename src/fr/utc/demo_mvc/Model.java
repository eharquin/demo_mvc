package fr.utc.demo_mvc;

import java.util.*;
import java.beans.*;
import java.awt.Color;

public class Model{

	private PropertyChangeSupport support;

	private String selectedColorName;
	private Color selectedColor;
	private Map<String, Color> nameColorMap;

	public Model(Map<String, Color> nameColorMap){
		this.support = new PropertyChangeSupport(this);
		this.nameColorMap = nameColorMap;
	}

	public String[] GetColorNameArray()
	{
		return nameColorMap.keySet().toArray(new String[0]);
	}

	public void setColor(String colorName){
		this.selectedColorName = colorName;
		this.selectedColor = this.nameColorMap.get(this.selectedColorName);
		support.firePropertyChange("selectedColor", null, this.selectedColor);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}