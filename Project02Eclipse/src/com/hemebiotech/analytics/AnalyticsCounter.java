package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		 // create a File object
        File file = new File(System.getProperty("user.dir")+"/Guittoun-Thibault-debug-java/Project02Eclipse/symptoms.txt");
        try {
            if (!file.exists()) {
                System.out.println("Erreur : Le fichier n'a pas été trouvé.");
                return;
            }

            if (file.length() == 0) {
                System.out.println("Erreur : Le fichier est vide.");
                return;
            }

            BufferedReader reader = new BufferedReader (new FileReader(file.toString()));
            String line = reader.readLine();

            int i = 0;
    		while (line != null) {
    			i++;
    			System.out.println("symptom from file: " + line);
    			if (line.equals("headache")) {
    				headacheCount++;
    				System.out.println("number of headaches: " + headacheCount);
    			}
    			else if (line.equals("rush")) {
    				rashCount++;
    			}
    			else if (line.contains("pupils")) {
    				pupilCount++;
    			}
    			line = reader.readLine();
    			
    		}
    		FileWriter writer = new FileWriter (System.getProperty("user.dir")+"/Guittoun-Thibault-debug-java/Project02Eclipse/result.out");
    		writer.write("headache: " + headacheCount + "\n");
    		writer.write("rash: " + rashCount + "\n");
    		writer.write("dialated pupils: " + pupilCount + "\n");
    		writer.close();

            reader.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }		
	}
