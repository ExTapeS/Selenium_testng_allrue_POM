package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeForm extends BasePage {

    public PracticeForm(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String PRACTICE_FORM = "https://demoqa.com/automation-practice-form";

    @FindBy(tagName = "html")
    public WebElement theDoc;

    @FindBy(id = "submit")
    public WebElement sbmtBtn;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lstNameFld;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement frstNameFld;

    @FindBy(xpath = "//input[@id='userNumber']")
    public WebElement usrNumbrFld;

    @FindBy(xpath = "//label[contains(text(),'Male')]")
    public WebElement genderMaleBtn;

    @FindBy(xpath = "//label[contains(text(),'Female')]")
    public WebElement genderFmaleBtn;

    @FindBy(xpath = "//label[contains(text(),'Other')]")
    public WebElement genderOtherBtn;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    public WebElement dateOfBirthFld;

    @FindBy(xpath = "//select[contains(@class,'month-select')]")
    public WebElement monthSelect;

    @FindBy(xpath = "//select[contains(@class,'year-select')]")
    public WebElement yearSelect;

    @FindBy(xpath = "//div[contains(@aria-label,'June 29th')]")
    public WebElement June29th;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement usrMailFld;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    public WebElement addressFld;

    @FindBy(id = "uploadPicture")
    public WebElement uploadBtn;


    @Step("Click on submit button step...")
    public PracticeForm clckSbmt(){
        sbmtBtn.click();
        return this;
    }

    @Step("Filling the first name: {0} step...")
    public PracticeForm fillInFrstName(String name){
        frstNameFld.sendKeys(name);
        return this;
    }

    @Step("Filling the last name: {0} step...")
    public PracticeForm fillInLstName(String lstname){
        lstNameFld.sendKeys(lstname);
        return this;
    }

    @Step("Filling email: {0} step...")
    public PracticeForm fillInMail(String mail){
        usrMailFld.sendKeys(mail);
        return this;
    }

    @Step("Choosing a gender: {0} step...")
    public PracticeForm chooseGender(WebElement element){
        element.click();
        return this;
    }

    @Step("Filling a phone number: {0} step...")
    public PracticeForm fillInPhnNumber(String phnNum){
        usrNumbrFld.sendKeys(phnNum);
        return this;
    }

    @Step("Filling the address: {0} step...")
    public PracticeForm fillInAddress(String address){
        addressFld.sendKeys(address);
        return this;
    }

    @Step("Choosing the date of birth step...")
    public PracticeForm chooseTheDateOfBirth(int month, int year, WebElement day){
        dateOfBirthFld.click();
        Select yearOfBirth = new Select(yearSelect);
        String realYear = Integer.toString(year);
        yearOfBirth.selectByValue(realYear);
        Select monthOfBirth = new Select(monthSelect);
        int actMonth = month-1;
        String realMonth = Integer.toString(actMonth);
        monthOfBirth.selectByValue(realMonth);
        day.click();
        return this;
    }

    @Step("Uploading a {0} picture step...")
    public PracticeForm upldAPctr(String fileNameInResources){
        String usrDirectory = System.getProperty("user.dir");
        uploadBtn.sendKeys(usrDirectory+"\\src\\main\\resources\\"+fileNameInResources);
        return this;

    }

    @Step("Zooming out to {0} percents step...")
    public PracticeForm zoomOut(int percents){
        String percentage = Integer.toString(percents);
        String perc = percentage+"%';";
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='"+perc);
/*       for(int i = 1; i==5; i++){
        theDoc.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        }*/
        return this;
    }

    @Step("Delete page footer step...")
    public PracticeForm deleteFooter(){
        ((JavascriptExecutor)driver).executeScript("document.getElementsByTagName('footer')[0].remove();");
        return this;
    }

    @Step("Delete an element that blocks the submit button step ...")
    public PracticeForm deleteDiv(){
        ((JavascriptExecutor)driver).executeScript("document.getElementsByTagName('div')[2].remove();");
        return this;
    }
    @Step("Scroll Down {0} pixels down step...")
    public PracticeForm scrollDown(int amountOfPixels){
        String pixels = Integer.toString(amountOfPixels);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, -"+pixels+");");
        return this;
    }

}
