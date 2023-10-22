package Step_Difination;


import Pages.HomePage;
import Utilties.CommonActions;
import Utilties.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class SubscriptionPackages extends Hooks{
HomePage homePageObject=new HomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust the timeout as needed

    Actions actions = new Actions(getDriver());
public  double liteSar;
public double classicSar;
public  double premuimSar;
    @Before
    public void setup() {
        getDriver();
    }
    @Given("I am on the subscription service website")
    public void visitSubscribPage() throws InterruptedException {
        CommonActions.waitForElement(homePageObject.StcLogo);
        CommonActions.verifyDisplying(homePageObject.chooseYourPlanHeader);
    }
    @Then("Verify That language is changed {string}")
    public void verify_that_language_is_changed(String arabicLanguage) {

        Assert.assertEquals(getDriver().findElement(homePageObject.arabicCountry).getText().trim(),arabicLanguage);

    }
    @Then("I should see the following subscription packages:")
    public void i_should_see_the_following_subscription_packages_for_sa(DataTable expectedData) {
        List<Map<String, String>> data = expectedData.asMaps(String.class, String.class);
        List<String> discoveryList = homePageObject.getDiscovery(homePageObject.discoveryRow);
        List<String> quiltyList = homePageObject.getDiscovery(homePageObject.videoQuality);
        List<String> devicesAccessList = homePageObject.getDiscovery(homePageObject.devicesAcesss);
        List<String> rewindList = homePageObject.getDiscovery(homePageObject.Rewind);

        for (Map<String, String> row : data) {
            String packageType = row.get("Package Type");
            String price = row.get("Price");
            String currency = row.get("Currency");
            String Discovery=row.get("Discovery").trim();
            String videoQuality=row.get("Video quality").trim();
            String devicesAccess=row.get("Device access").trim();
            String Rewind=row.get("ReWind").trim();
            String actualDiscovery = discoveryList.get(data.indexOf(row)).trim();
            String actualQuality = quiltyList.get(data.indexOf(row)).trim();
            String actualDevicesAccess = devicesAccessList.get(data.indexOf(row)).trim();
            String actualRewind = rewindList.get(data.indexOf(row)).trim();

            Assert.assertEquals(homePageObject.getSubscribePlanName(packageType).getText().trim().toLowerCase(),packageType);
            Assert.assertEquals(homePageObject.getSubscribePlanPrice(packageType).getText().trim(),price);
            Assert.assertEquals(homePageObject.getSubscribePlanCurrency(packageType).getText().trim(),currency);
            Assert.assertEquals(actualDiscovery,Discovery);
            Assert.assertEquals(actualQuality,videoQuality);
            Assert.assertEquals(actualDevicesAccess,devicesAccess);
            Assert.assertEquals(actualRewind,Rewind);



        }
}
    @When("I select {string} as the country")
    public void i_select_as_the_country(String string) throws InterruptedException {
        CommonActions.clickElementWithJavaScript(homePageObject.selectCountryArrow);
        CommonActions.clickElementWithJavaScript(homePageObject.getSelectCountry(string));
    }
    @When("should see the correct converted prices based on exchange rates From SAR to KWD")
    public void should_see_the_correct_converted_prices_based_on_exchange_rates_from_sar_to_kwd() {
       liteSar=Double.valueOf(homePageObject.getSubscribePlanPrice("lite").getText());
       classicSar=Double.valueOf(homePageObject.getSubscribePlanPrice("classic").getText());
       premuimSar=Double.valueOf(homePageObject.getSubscribePlanPrice("premium").getText());
        CommonActions.clickElementWithJavaScript(homePageObject.selectCountryArrow);
        CommonActions.clickElementWithJavaScript(homePageObject.getSelectCountry("Kuwait"));
        double liteKwd=Double.valueOf(homePageObject.getSubscribePlanPrice("lite").getText());
      double  classicKwd=Double.valueOf(homePageObject.getSubscribePlanPrice("classic").getText());
       double premuimKwd=Double.valueOf(homePageObject.getSubscribePlanPrice("premium").getText());
       Assert.assertEquals(CommonActions.roundToDecimalPlace(CommonActions.convertCurrency(liteSar, Constants.exchangeRateFromSarToKwd),1),liteKwd);
        Assert.assertEquals(CommonActions.roundToDecimalPlace(CommonActions.convertCurrency(classicSar, Constants.exchangeRateFromSarToKwd),1),classicKwd);
        Assert.assertEquals(CommonActions.roundToDecimalPlace(CommonActions.convertCurrency(premuimSar, Constants.exchangeRateFromSarToKwd),1),premuimKwd);

    }
    @Then("I should see the correct converted prices based on exchange rates From SAR to BHD")
    public void i_should_see_the_correct_converted_prices_based_on_exchange_rates_from_sar_to_bhd() {
        liteSar=Double.valueOf(homePageObject.getSubscribePlanPrice("lite").getText());
        classicSar=Double.valueOf(homePageObject.getSubscribePlanPrice("classic").getText());
        premuimSar=Double.valueOf(homePageObject.getSubscribePlanPrice("premium").getText());
        CommonActions.clickElementWithJavaScript(homePageObject.selectCountryArrow);
        CommonActions.clickElementWithJavaScript(homePageObject.getSelectCountry("Bahrain"));
        double liteKBhd=Double.valueOf(homePageObject.getSubscribePlanPrice("lite").getText());
        double  classicBhd=Double.valueOf(homePageObject.getSubscribePlanPrice("classic").getText());
        double premuimBhd=Double.valueOf(homePageObject.getSubscribePlanPrice("premium").getText());
        Assert.assertEquals(CommonActions.roundToDecimalPlace(CommonActions.convertCurrency(liteSar, Constants.exchangeRateFromSarToBhd),1),liteKBhd);
        Assert.assertEquals(CommonActions.roundToDecimalPlace(CommonActions.convertCurrency(classicSar, Constants.exchangeRateFromSarToBhd),1),classicBhd);
        Assert.assertEquals(CommonActions.roundToDecimalPlace(CommonActions.convertCurrency(premuimSar, Constants.exchangeRateFromSarToBhd),1),premuimBhd);
    }
    @Given("Change Langauge To Arabic")
    public void change_langauge_to_arabic() throws InterruptedException {
        CommonActions.clickElement(homePageObject.changeToArabic);
    }

    @After
    public void teardown() {
       quitDriver();
    }
}
