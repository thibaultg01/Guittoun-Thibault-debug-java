package com.hemebiotech.analytics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	ISymptomReader reader;
	ISymptomWriter writer;
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();

        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }

        return symptomCounts;
    }
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
        return sortedSymptoms;
    }
	
			
	}
