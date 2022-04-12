package com.configuration;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;

public class Log {

    private static Logger logger;
    private static String directoryName;

    public Log(String log4jFileName) {
        setLogger(log4jFileName);
    }

    private static void setLogger(String filename) {
        directoryName = "output/screenshots";
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File file = new File("src/test/resources/" + filename);
        context.setConfigLocation(file.toURI());

        logger = Logger.getLogger(Log.class.getName());
    }

    private static void logError(Exception e) {
        logger.error("<----------------Beginning of Error---------------->");
        logger.error(e, e);
        logger.error("<-------------------End of Error------------------->");
    }

    private static void logError(String message) {
        logger.error("<----------------Beginning of Error---------------->");
        logger.error(message);
        logger.error("<-------------------End of Error------------------->");
    }


    public static void startTestCase(String sTestCaseName) {
        logger.info("<===================Scenario Name==================>");
        logger.info(sTestCaseName);
    }

    public static void endTestCase() {
        logger.info("<===================End Test Case==================>\n\n");
    }

    public static void info(String message) {
        logger.info(message);
    }


    public static void logScenarioError(String errorLog) {
        logError(errorLog);
    }

    public static void logException(Exception e) {
        try {
            logError(e);
        } catch (Exception f) {
            logError(f);
        }
    }

    public static void attachScreenshot(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            String value = scenario.getUri().toString();
            String featureName = value.substring(value.lastIndexOf("/") + 1).replace(".feature", "");

            File screenshotFile = PlatformHelper.getCurrentPlatform().takeScreenshot();
            File directory = new File(directoryName);
            if (!directory.exists()) {
                directory.mkdir();
            }
            File destinationPath = new File("output/screenshots/" + featureName + "/" + screenshotName + ".png");
            destinationPath.getParentFile().mkdir();
            destinationPath.createNewFile();
            FileUtils.copyFile(screenshotFile, destinationPath);
            byte[] fileContent = FileUtils.readFileToByteArray(destinationPath);
            scenario.attach(fileContent,"image/png","");
        } catch (Exception e) {
            try {
                Log.logError(e);
                scenario.log("<font color='red'><bold>Unable to take a Screenshot</bold></font>");
            } catch (NullPointerException f) {
                Log.logError(f);
            }
        }
    }
}