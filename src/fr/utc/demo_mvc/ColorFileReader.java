package fr.utc.demo_mvc;

import java.awt.*;
import java.util.*;
import java.io.*;

public class ColorFileReader{

    public static Map<String, Color> ReadColorFile(String filePath)
	{
		HashMap<String, Color> nameColorMap = new HashMap<String, Color>();
		String ligne;

		try {
		  	BufferedReader lecture = new BufferedReader(new FileReader(filePath));

		  	try {
		    	while((ligne = lecture.readLine()) != null) {
		    		String red0 = ligne.substring(0,4).trim();
		    		String green0 = ligne.substring(4,8).trim();
		    		String blue0 = ligne.substring(8,12).trim();

		    		int red = Integer.parseInt(red0);
		    		int green = Integer.parseInt(green0);
		    		int blue = Integer.parseInt(blue0);
		    		
		    		String name = ligne.substring(13,ligne.length());

		    		nameColorMap.put(name, new Color(red,green,blue));
				}
			} 
			catch(IOException e) {
				System.err.println("Erreur de lecture dans rgb.txt !");
			}

			try {
				lecture.close();
			} 
			catch(IOException e) {
				System.err.println("Erreur de fermeture de rgb.txt !");
			}
		}
		catch(FileNotFoundException e) {
		  	System.err.println("Erreur d'ouverture de rgb.txt !");
		}
		return nameColorMap;
	}
}