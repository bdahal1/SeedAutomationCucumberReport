package step_definations;

import com.abstract_steps.AbstractApplicationStepDefinitions;
import exceptions.ProjectException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class StepFile extends AbstractApplicationStepDefinitions {

    @Given("^user opens the app$")
    public void openApp() throws ProjectException {
        platform.test();
    }

    @And("^user checks true app$")
    public void test1() throws ProjectException {
        platform.test();
    }

    @And("^user checks false app$")
    public void test2() throws ProjectException {
        platform.test2();
    }
}
