package tests;

import Pages.PracticeForm;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Pages.PracticeForm.PRACTICE_FORM;
import static common.Constants.BTM_CLR;
import static common.Constants.RED_CLR;

public class PracticeFormTest extends BaseTest {

    @Test(priority = 1, description = "Color changes after hitting Submit button with empty fields")
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking whether address field's borders are red")
    @Story("Story name: checking the colour of the field after hitting submit button with empty fields")
    public void WaitForColorTest(){
        basePage.open(PRACTICE_FORM);
        practiceForm
                .deleteFooter()
                .deleteDiv()
                .clckSbmt()
                .waitForColour(practiceForm.addressFld, RED_CLR, BTM_CLR);
    }

    @Test(priority = 2, description = "The user is registered")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Creating a new user")
    @Story("Story name: creating a new user with Name, Last Name, address, number, gender, date of birth")
    public void userIsRegistered(){
        practiceForm
                .fillInAddress("city city")
                .fillInFrstName("Petr")
                .fillInLstName("Petrov")
                .fillInMail("mail@mail.com")
                .fillInPhnNumber("8999999999")
                .chooseGender(practiceForm.genderMaleBtn)
                .chooseTheDateOfBirth(6, 1994, practiceForm.June29th)
                .upldAPctr("pic.png")
                .clckSbmt();

        basePage.checkAmountOfElements(By.tagName("tr"), 11);
    }
}
