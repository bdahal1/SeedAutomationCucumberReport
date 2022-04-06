package step_definations;

import com.helper.ConfigurationHelper;
import com.configuration.Log;
import com.configuration.PlatformHelper;
import com.helper.DataHelper;
import com.module.interfaces.ClientPlatform;

import exceptions.UnknownErrorException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.TestCaseFinished;

public class Hooks implements ConcurrentEventListener {

    String log4fFilename = ConfigurationHelper.getLog4jFile();

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        new Log(log4fFilename);
        DataHelper.setCurrentScenario(scenario);
        ClientPlatform platform = PlatformHelper.getCurrentPlatform();
        try {
            String platformStr = platform.toString();
            PlatformHelper.getCurrentPlatform().launch();
            Log.startTestCase(scenario.getName());
        } catch (Exception e) {
            throw new Exception("Unknown Error while launching automation platform", e);
        }
    }

    @After
    public void afterScenario(Scenario scenario) throws Exception {
        try {
            if (scenario.isFailed()) {
                Log.attachScreenshot(scenario);
                PlatformHelper.getCurrentPlatform().logOut();
            } else {
                Log.endTestCase();
            }
            ClientPlatform platform = PlatformHelper.getCurrentPlatform();
            if (platform.toString().contains("ios") || platform.toString().contains("Android")) {
                PlatformHelper.getCurrentPlatform().quitDriver();
            }
        } catch (Exception e) {
            throw new UnknownErrorException("Unknown error while handling execution result of a scenario");
        }
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        Result result = event.getResult();
        if (result.getError() != null) {
            Log.logScenarioError(result.getError().toString());
            Log.endTestCase();
        }
    }
}
