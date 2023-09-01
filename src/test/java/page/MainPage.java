package page;

import elements.CheckBox;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

@Log4j2
public class MainPage extends BasePage{

    public static final By BUTTON_CREATE_ENTRY = By.id("create-entry");
    public static final By BUTTON_ICON_HOME = By.id("back-to-overview");
    public static final By TEXT_MESSAGE_ENTER_USER = By.id("back-to-overview");
    public static By BUTTON_DELETE = By.id("delete-entries");



    @Step("Click button create entry")
    public void clickCreateButton() {
        log.info("Click " + BUTTON_CREATE_ENTRY);
        driver.findElement(BUTTON_CREATE_ENTRY).click();
    }
    @Step("Click button icon home")
    public void clickButtonHome(){
        log.info("Click " + BUTTON_ICON_HOME);
        driver.findElement(BUTTON_ICON_HOME).click();
    }
    @Step("Text message records")
    public String textMessageRecords(String text) {
        log.info("Created record text");
        driver.findElement(TEXT_MESSAGE_ENTER_USER).getText();
    return text;
    }
    public void selectCheckBox(String text){
        new CheckBox(driver,text).selectCheckBox();
    }
    public void clickButtonDelete() {
        driver.findElement(BUTTON_DELETE).click();

    }
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}
