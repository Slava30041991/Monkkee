package page;

import elements.Calendar;
import elements.CheckBox;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;

@Log4j2
public class MainPage extends BasePage{

    public static final By BUTTON_CREATE_ENTRY = By.id("create-entry");
    public static final By BUTTON_ICON_HOME = By.id("back-to-overview");
    public static final By TEXT_MESSAGE_ENTER_USER = By.id("back-to-overview");


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
    public void searchInput(String text){
        new Input(driver).searchInput(text);
    }
    public void selectDate(String monthYear,String day){
        new Calendar(driver).selectDate(monthYear, day);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}
