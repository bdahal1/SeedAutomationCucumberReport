package com;

import com.configuration.PlatformHelper;
import exceptions.ProjectException;
import exceptions.UnknownErrorException;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;


@CucumberOptions(plugin = {
        "pretty", "json:output/Cucumber.json", "junit:output/Cucumber.xml",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "step_definations.Hooks"},
        monochrome = true,
        features = "classpath:features",
        tags = "@test",
        glue = "step_definations",
        dryRun = false)
public class Runner extends AbstractTestNGCucumberTests {
    @AfterClass
    public void teardown() throws ProjectException {
        try {
            PlatformHelper.getCurrentPlatform().quitDriver();
        } catch (Exception e) {
            throw new UnknownErrorException("Unknown error while generating log file.", e);
        }
    }
}
