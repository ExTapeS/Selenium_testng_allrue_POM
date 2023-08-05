package Pages;

import com.google.common.base.Function;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
     public void open(String url){
        driver.get(url);
     }

     @Step("Wait for colour step...")
     public WebElement waitForColour(WebElement element, String colour, String cssValue){

         FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                 .withTimeout(Duration.ofSeconds(10))
                 .pollingEvery(Duration.ofSeconds(1))
                 .ignoring(NoSuchElementException.class);
         Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
         {
             public Boolean apply(WebDriver driver) {
                 WebElement element1 = element;
                 String color = element1.getCssValue(cssValue);
                 if(color.equals(colour))
                 {
                     return true;
                 }
                 return false;
             }
         };
         wait.until(function);
         return element;
     }

     @Step("Compare amount of elements on the page step...")
    public BasePage checkAmountOfElements(By locator, int expectedAmount){
        int amountOfElements = driver.findElements(locator).size();
        Assert.assertEquals(amountOfElements, expectedAmount);
        return this;
    }

}
