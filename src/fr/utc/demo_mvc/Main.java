package fr.utc.demo_mvc;

import java.awt.*;
import java.util.*;

/**
 * Application entrypoint
 */
public class Main {

    /**
     * CSV file containing colors
     */
    private static final String colorsFile = "res/rgb.txt";

    /**
     * CLI application entrypoint, linking the model, view and controllers components
     * @param args CLI arguments
     */
    public static void main(String[] args) {

        Map<String, Color> nameColorMap = ColorFileReader.ReadColorFile(colorsFile);

        Model model = new Model(nameColorMap);

        Controller controller = new Controller(model);

        View view = new View(controller, nameColorMap.keySet().toArray(new String[0]));

        model.addPropertyChangeListener(view);

        view.setVisible(true);
    }
}