package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteSymptomDataToFile implements ISymptomWriter {
		public void writeSymptoms(Map<String, Integer> symptoms) {
			File file = new File(System.getProperty("user.dir")+"/Guittoun-Thibault-debug-java/Project02Eclipse/result.out");
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
	                writer.write(entry.getKey() + ": " + entry.getValue());
	                writer.newLine();
	            }
	            System.out.println("Les symptômes ont été écrits avec succès.");
	        } catch (IOException e) {
	            System.out.println("Erreur lors de l'écriture des symptômes dans le fichier : " + e.getMessage());
	        }
}

}
	

