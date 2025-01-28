package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		ISymptomReader reader = new ReadSymptomDataFromFile(System.getProperty("user.dir")+"/Guittoun-Thibault-debug-java/Project02Eclipse/symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile(System.getProperty("user.dir")+"/Guittoun-Thibault-debug-java/Project02Eclipse/result.out");
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		List<String> symptomList = analyticsCounter.getSymptoms();
		Map<String, Integer> symptomMap = analyticsCounter.countSymptoms(symptomList);
        Map<String, Integer> sortedMap = analyticsCounter.sortSymptoms(symptomMap);
        analyticsCounter.writeSymptoms(sortedMap);
	}

}