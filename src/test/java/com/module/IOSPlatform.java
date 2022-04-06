package com.module;

import com.helper.ConfigurationHelper;
import com.configuration.environment.IOSEnvironment;
import com.configuration.run.IOSRunConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOSPlatform extends MobilePlatform {
    private AppiumDriver driver;

    public IOSPlatform() {
        super();
    }

    public AppiumDriver initDriver() {
        try {
            if (driver == null) {
                IOSEnvironment iosEnvironment = ConfigurationHelper.getIOSEnvironment();
                IOSRunConfig runConfig = ConfigurationHelper.getIOSRunConfig();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("app", runConfig.getApp());
                capabilities.setCapability("device", runConfig.getDevice());
                capabilities.setCapability("platformVersion", runConfig.getPlatformVersion());
                capabilities.setCapability("appPackage", iosEnvironment.getBundleId());
                capabilities.setCapability("appActivity", runConfig.getAppActivity());
                capabilities.setCapability("automationName", runConfig.getAutomationName());
                driver = new IOSDriver(new URL(runConfig.getUrl()), capabilities);
                return driver;
            }
        } catch (MalformedURLException e) {

        }
        return null;
    }

    @Override
    public void launch() throws Exception{
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
