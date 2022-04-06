package com;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin =
        {
                "pretty",
                "json:output/Cucumber.json",
                "junit:output/Cucumber.xml",
                "html:output/cucumber-html-report.html",
                "step_definations.Hooks"
        },
        monochrome = true,
        features = "classpath:features",
        tags = "@test",
        glue = "step_definations",
        dryRun = false)
public class Runner {

}
