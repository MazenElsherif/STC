package Utilties;

import Step_Difination.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
//generic actions/methods
public class CommonActions extends Hooks {
    // click on element
    public static void clickElement(By locator) {
        getDriver().findElement(locator).click();
    }
    // click on element with java script executor
    public static void clickElementWithJavaScript(By locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click();", getDriver().findElement(locator));
    }
// write in input field
    public static void enterText(By locator, String text) {
       getDriver().findElement(locator).sendKeys(text);
    }
//wait until visibility of element
    public static void waitForElement(By locator) {
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
//verify Expceted text
    public static void verifyText(By locator, String expectedText) {
        Assert.assertEquals(getDriver().findElement(locator).getText(), expectedText);
    }

    //verify that element is displayed
    public static void verifyDisplying(By locator) {
        Assert.assertTrue(getDriver().findElement(locator).isDisplayed());
    }
    // Select from dropdown list
    public static void selectByValue(By locator,String value) {
    Select select=new Select(getDriver().findElement(locator));
        select.selectByValue(value);
    }

    //Convert between currencies
    public static double convertCurrency(double amountInSAR, double exchangeRate) {
        if (exchangeRate <= 0) {
            throw new IllegalArgumentException("Exchange rate must be a positive value.");
        }

        return amountInSAR / exchangeRate;
    }
    // take only first decimal number
    public static double roundToDecimalPlace(double value, int decimalPlaces) {
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("Decimal places must be non-negative.");
        }

        double multiplier = Math.pow(10, decimalPlaces);
        double roundedValue = Math.round(value * multiplier) / multiplier;

        return roundedValue;
    }
}
