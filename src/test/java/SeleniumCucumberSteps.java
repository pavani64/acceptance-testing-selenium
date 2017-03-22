import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumCucumberSteps {

    WebDriver driver;


    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    //Feature: Weather Report
    @Given("^the application is running$")
    public void theApllicationIsRunning() {
        driver.get("http://localhost:3000/");
    }

    @Given("^date is given$")
    public void dateIsGiven() {

    }

    @When("^I enter city name as: (.*)$")
    public void I_enter_city_name_as(String cityName) {
        WebElement city = driver.findElement(By.name("city"));
        city.clear();
        city.sendKeys(cityName, Keys.ENTER);


    }

    @Then("^the forecast should have (.*)$")
    public void fiveDayWeatherForecast(String day) {
        Assert.assertEquals(5, driver.findElements(By.className("summary")).size());
        Assert.assertNotNull(driver.findElement(By.xpath("//div[@class='summary']/span/span[text()='" + day + "']")));

    }

    @Then("^I should see error message")
    public void fiveDAyWeatherForecastFailedCase() {
        Assert.assertEquals("Error retrieving the forecast",
                driver.findElement(By.cssSelector("div[data-test='error']")).getText());
    }

    //Feature:Select day, get 3 hourly forecast

    @When("^user clicks on day1(?: again)?$")
    public void dayforecast() throws InterruptedException {
        driver.findElement(By.xpath("//span[@data-test='day-1']")).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        // Thread.sleep(2000L);


    }

    @Then("^user will be  able to see three hourly forecast$")
    public void threehourelyforecast() throws InterruptedException {
        Thread.sleep(200L);
        Assert.assertEquals(4, driver.findElements(By.xpath("//div[@id='root']/div/div[1]/div[@class='details']/div")).size());
    }

    @When("^user clicks on next day$")
    public void whenuserclicksonnextday() {
        driver.findElement(By.xpath("//span[@data-test='day-2']")).click();
    }

    @Then("^user will be  able to see three hourly forecast for next day$")
    public void threehourelyforecastfornextday() {
        Assert.assertEquals(8, driver.findElements(By.xpath("//div[@id='root']/div/div[2]/div[@class='details']/div[@class='detail']")).size());
    }

    //Feature3 :
    @Then("^the hourly forecast should be hidden$")
    public void hidethreehourlyforecast() {

        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='root']/div/div[1]/div[@class='details']/div[@class='detail']")));

    }

    @Then("^summary of all the   hourly  data should be displayed like below$")
    public void displaysummary(DataTable hourlydata) {
        List<List<String>> dataList = hourlydata.raw();
        List<WebElement> detailRowList = driver.findElements(By.cssSelector(".details")).get(0).findElements(By.className("detail"));
        for (int rowIndex = 0; rowIndex < dataList.size(); rowIndex++) {
            List<String> expectedDataRow = dataList.get(rowIndex);
            WebElement detailRow = detailRowList.get(rowIndex);
            Assert.assertEquals(expectedDataRow.get(0), detailRow.findElement(By.className("hour")).getText());
            Assert.assertEquals(expectedDataRow.get(1), detailRow.findElement(By.cssSelector("svg[aria-label]")).getAttribute("aria-label"));
            Assert.assertTrue(detailRow.findElement(By.className("max")).getText().contains(expectedDataRow.get(2)));
            Assert.assertTrue(detailRow.findElement(By.className("min")).getText().contains(expectedDataRow.get(3)));
            Assert.assertEquals(expectedDataRow.get(4), detailRow.findElement(By.className("speed")).getText());
            Assert.assertEquals(expectedDataRow.get(5), detailRow.findElement(By.className("rainfall")).getText());
            Assert.assertEquals(expectedDataRow.get(6), detailRow.findElement(By.className("pressure")).getText());
        }
    }


    @After
    public void afterTest() {

        if (driver != null) {
            driver.quit();
        }
    }

}