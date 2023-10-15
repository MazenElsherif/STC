package Runners;

import Step_Difination.Hooks;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources",
        glue = {"Step_Difination"},
        plugin = {"pretty", "html:target/cucumber-html-report"},
        tags = "@Arabic or @English",
        monochrome = true,
        dryRun = false
)
        public class TestRunner extends Hooks {


}
