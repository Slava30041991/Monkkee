package page;

import elements.Calendar;
import elements.CheckBox;
import elements.Input;
import elements.InputTags;
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
        driver.findElement(BUTTON_CREATE_ENTRY).click();
        log.info("Click " + BUTTON_CREATE_ENTRY);
    }
    @Step("Click button icon home")
    public void clickButtonHome(){
        driver.findElement(BUTTON_ICON_HOME).click();
        log.info("Click " + BUTTON_ICON_HOME);
    }
    @Step("Text message records")
    public String textMessageRecords(String text) {
        driver.findElement(TEXT_MESSAGE_ENTER_USER).getText();
        log.info("Created record text");
    return text;
    }
    @Step("Select check box")
    public void selectCheckBox(String text){
        new CheckBox(driver,text).selectCheckBox();
        log.info("Select check box");
    }
    @Step("Search input")
    public void searchInput(String text){
        new Input(driver).searchInput(text);
        log.info("search records by text");
    }
    @Step("Select date calendar")
    public void selectDate(String monthYear,String day){
        new Calendar(driver).selectDate(monthYear, day);
        log.info("Search entries by date");
    }
    @Step("Message search date")
    public String getMessageCalendar(String text){
       new Calendar(driver).getMessageEntries();
        log.info("Message that the record was found by date");
        return text;
    }
    public void createTagPost(String text){
        new InputTags(driver,text).searchTags(text);
    }


    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}
