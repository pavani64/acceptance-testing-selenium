import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"}
        //      ,tags = {"@single"}
)
// -Dcucumber.options="--tags @single"
public class SeleniumCucumber {

}