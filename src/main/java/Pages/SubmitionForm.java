package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v114.systeminfo.model.Size;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitionForm extends BasePage {

    WebDriver driver;
    public SubmitionForm(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody/tr[9]/td[2]")
    public WebElement addressSbmtInf;

    @FindBy(xpath = "//tbody/tr[7]/td[2]")
    public WebElement hobbySbmtInf;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement stdntNameInf;

    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    public WebElement mailSbmtInf;

    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    public WebElement usrNmbrSbmtInf;






}
