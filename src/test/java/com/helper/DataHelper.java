package com.helper;

import io.cucumber.core.feature.FeatureIdentifier;
import io.cucumber.core.gherkin.FeatureParser;
import io.cucumber.java.Scenario;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;

public class DataHelper {

    private static HashMap<String, HashMap<String,String>> data;

    private static HashMap<String, String> globalData;

    private static String currentScenarioKey;

	public static void setCurrentScenario(Scenario scenario) {
	    String value=scenario.getUri().toString();
	    String featureFileName=value.substring(value.lastIndexOf("/") + 1).replace(".feature","");
	    currentScenarioKey = getScenarioKey(featureFileName, scenario.getName());
    }

    public static HashMap<String, String> getGlobalData() {
	    if (globalData == null) {
            globalData = new HashMap<>();
        }

        return globalData;
    }

    private static String getScenarioKey(String featureFile, String scenarioName) {
	    return featureFile.toLowerCase().replace(' ', '-') + scenarioName.toLowerCase().replace(' ', '-');
    }
}
