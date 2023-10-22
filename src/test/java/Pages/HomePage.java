package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;

import java.util.List;

public  class HomePage  {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
   public By StcLogo =By.xpath("//a[@id='jawwy-logo-web']");
    public By selectCountryArrow=By.xpath("//span[@id='country-name']");
    public  By chooseYourPlanHeader=By.xpath("//h2[@class='mobile-hidden']");
public By discoveryRow=By.xpath("(//div[contains(@class,'plan-names')])[3]");
    public By videoQuality=By.xpath("(//div[contains(@class,'plan-names')])[5]");
    public By devicesAcesss=By.xpath("(//div[contains(@class,'plan-names')])[6]");
    public By Rewind=By.xpath("(//div[contains(@class,'plan-names')])[7]");
    public By changeToArabic=By.xpath("//a[@id='translation-btn']");
    public  By changeToEnglish=By.xpath("(//a[@dir='rtl'][contains(.,'English')])[1]");
    public By arabicCountry=By.xpath("(//span[contains(.,'السعودية')])[1]");
    public By support=By.xpath("//button[contains(.,'Support')]");

    public WebElement getSubscribePlanName( String packageName){
        String xpathSubscribePlan="//strong[@id='name-" + packageName + "']";
   return driver.findElement(By.xpath(xpathSubscribePlan));
    }
    public WebElement getSubscribePlanPrice( String packageName){
        String xpathSubscribePlan="//div[@id='currency-" + packageName + "']/b";
        return driver.findElement(By.xpath(xpathSubscribePlan));

    }
    public WebElement getSubscribePlanCurrency( String packageName){
        String xpathSubscribePlan="//div[@id='currency-" + packageName + "']/i";
        return driver.findElement(By.xpath(xpathSubscribePlan));
    }
    public By getSelectCountry(String country){
        String xpathSelectCountry="//span[contains(.,'"+country+"')]";
        return By.xpath(xpathSelectCountry);
    }


    //return list of strings
    public List<String> getDiscovery(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> textList = new ArrayList<String>();

        for (WebElement element : elements) {
            String text = element.getText().trim();
            String[] splitStrings = text.split("\\n");
            textList.addAll(Arrays.asList(splitStrings));
        }
        return textList;
    }}