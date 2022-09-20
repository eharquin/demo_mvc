package fr.utc.demo_mvc;

import java.util.*;
import javax.swing.event.*;
import javax.swing.*;

public class Controller implements ListSelectionListener{

	private Model model;

	public Controller(Model model){
		this.model = model;
	}

	@Override
	public void valueChanged(ListSelectionEvent e){
		ListSelectionModel lsm = ((JList)e.getSource()).getSelectionModel();
		String selectedColor = (String) ((JList)e.getSource()).getSelectedValue();

		if(!lsm.isSelectionEmpty()){
			this.model.setColor(selectedColor);
		}
	}
}