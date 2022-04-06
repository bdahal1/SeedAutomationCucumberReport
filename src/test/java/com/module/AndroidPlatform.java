package com.module;

import com.helper.ConfigurationHelper;
import com.configuration.environment.AndroidEnvironment;
import com.configuration.run.AndroidRunConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidPlatform extends MobilePlatform {

    private AppiumDriver<MobileElement> driver;

    public AndroidPlatform() {
        super();
    }

    public AppiumDriver<MobileElement> initDriver() {
        try {
            if (driver == null) {
                AndroidEnvironment androidEnvironment = ConfigurationHelper.getAndroidEnvironment();
                AndroidRunConfig runConfig = ConfigurationHelper.getAndroidRunConfig();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("app", runConfig.getApp());
                capabilities.setCapability("device", runConfig.getDevice());
                capabilities.setCapability("platformVersion", runConfig.getPlatformVersion());
                capabilities.setCapability("appPackage", androidEnvironment.getAppPackage());
                capabilities.setCapability("appActivity", runConfig.getAppActivity());
                capabilities.setCapability("automationName", runConfig.getAutomationName());
                driver = new AndroidDriver<>(new URL(runConfig.getUrl()), capabilities);
                return driver;
            }
        } catch (MalformedURLException e) {

        }
        return null;
    }

    @Override
    public void launch() throws Exception {
        try {
            if (driver != null && driver.getSessionId() == null) {
                driver = null;
                initClasses(initDriver());
            }
            assert driver != null;
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new Exception("Unable to connect to the Appium server.");
        }
    }

}
