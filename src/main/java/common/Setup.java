package common;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import common.Constants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;

import static common.Constants.*;


public class Setup {

    @Step("Initializing the driver step...")
    public static WebDriver driverCreation () {

        WebDriver driver = null;
        switch (OS_BROW) {
            case "win_chr":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "win_moz":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "lin_chr":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            case "lin_moz":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("OS and Browser are not indicated or are incorrect. Please check " +
                        "/src/main/java/common/Constants");

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IM_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_WAIT));
        return driver;

    }
}
