package tests;

import Pages.BasePage;
import Pages.PracticeForm;
import Pages.SubmitionForm;
import common.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    protected WebDriver driver = Setup.driverCreation();
    protected BasePage basePage = new BasePage(driver);
    protected PracticeForm practiceForm = new PracticeForm(driver);

    protected SubmitionForm submitionForm = new SubmitionForm(driver);


    @AfterSuite
    public void closure(){
        driver.quit();
    }
}
