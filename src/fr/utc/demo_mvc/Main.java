package fr.utc.demo_mvc;

import java.awt.*;
import java.util.*;

public class Main{

	public static final String ressourcePath = "res/rgb.txt";
	
	public static void main(String[] args) {

		Map<String, Color> nameColorMap = ColorFileReader.ReadColorFile(ressourcePath);

		Model model = new Model(nameColorMap);

		Controller controller = new Controller(model);

		View view = new View(nameColorMap.keySet().toArray(new String[0]));
		view.addController(controller);

		model.addPropertyChangeListener(view);

		view.setVisible(true);
	}
}