package com.configuration.run;

import java.util.HashMap;

public class RunConfig {

    private String platform;

    private HashMap<String, String> platformValues;

    private String log4jFile;

    private String outputFolder;

    public String getPlatform() {
        return platform;
    }

    public String getPlatformValue(String key) {
        return platformValues.get(key);
    }

    public String getLog4jFile() {
        return log4jFile;
    }
}
