package fr.utc.demo_mvc;

import javax.swing.*;
import java.awt.*;
import javax.swing.JScrollPane.*;
import java.util.*;
import java.beans.*;

public class View extends JFrame implements PropertyChangeListener{

	private static final long serialVersionUID = 1234567L;

	private JPanel panel;

	public View(Controller controller, String[] colors){

		this.setLayout(new GridLayout(1,2));

		JList<String> list = new JList<String>(colors);
		list.addListSelectionListener(controller);

		JScrollPane dropdownList = new JScrollPane(list);
		dropdownList.setPreferredSize(new Dimension(300,300));
		this.add(dropdownList);

		this.panel = new JPanel();
		this.panel.setPreferredSize(new Dimension(100,100));
		this.add(panel);

		this.pack();
	}

	public void propertyChange(PropertyChangeEvent evt) {
        this.panel.setBackground( (Color) evt.getNewValue());
    }
}