package com.module;

import com.module.interfaces.mobile.Mobile_Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.Assertion;

import java.io.File;

public abstract class MobilePlatform implements Mobile_Platform {
    protected AppiumDriver<MobileElement> driver;
    //private HomePage homePage;
    //private LoginPage loginPage;
    private Assertion assertion = new Assertion();

    public MobilePlatform() {
        driver = initDriver();
        initClasses(driver);
    }

    public void initClasses(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        //loginPage = new LoginPage(driver);
    }

    protected abstract AppiumDriver<MobileElement> initDriver();

    @Override
    public void logOut() {

    }

    @Override
    public File takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    @Override
    public void navigateToLogin() {

    }

    @Override
    public void quitDriver() {

    }

    @Override
    public void validateLogIn() {

    }

    @Override
    public void validateEndOfSession() {

    }

    @Override
    public void test() {
        assertion.assertEquals(2, 2);
    }

    @Override
    public void test2() {
        assertion.assertEquals(1, 2);
    }
}
