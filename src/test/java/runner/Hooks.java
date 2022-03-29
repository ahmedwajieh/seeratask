package runner;


import io.cucumber.java.Before;
import steps.commons.CommonSteps;
import utils.ITestContext;

public class Hooks{

    @Before
    public void beforeScenario() throws Throwable {

        ITestContext.CONTEXT.reset();

    }

}
