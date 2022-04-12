package com.helper;

import com.configuration.Platform;
import com.configuration.environment.AndroidEnvironment;
import com.configuration.environment.EnvironmentConfig;
import com.configuration.environment.IOSEnvironment;
import com.configuration.run.AndroidRunConfig;
import com.configuration.run.IOSRunConfig;
import com.configuration.run.RunConfig;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConfigurationHelper {

    private static EnvironmentConfig environmentConfig;

    private static RunConfig runConfig;

    public static Platform getPlatform() {
        return Platform.getPlatform(getRunConfig().getPlatform());
    }

    public static String getLog4jFile() {
        return getRunConfig().getLog4jFile();
    }

    public static AndroidEnvironment getAndroidEnvironment() {
        return getEnvironmentConfig().getAndroidEnvironment();
    }

    public static IOSEnvironment getIOSEnvironment() {
        return getEnvironmentConfig().getIOSEnvironment();
    }

    public static AndroidRunConfig getAndroidRunConfig() {
        return new AndroidRunConfig(getRunConfig());
    }

    public static IOSRunConfig getIOSRunConfig() {
        return new IOSRunConfig(getRunConfig());
    }

    private static RunConfig getRunConfig() {
        if (runConfig == null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/configs/Run.config"));
                Gson gson = new Gson();
                runConfig = gson.fromJson(reader, RunConfig.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to read Run.config");
            }
        }
        return runConfig;
    }

    private static EnvironmentConfig getEnvironmentConfig() {
        if (environmentConfig == null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/configs/Environment.config"));
                Gson gson = new Gson();
                environmentConfig = gson.fromJson(reader, EnvironmentConfig.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to read Environment.config");
            }
        }
        return environmentConfig;
    }
}