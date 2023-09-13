package page;

import elements.Calendar;
import elements.CheckBox;
import elements.InputSearch;
import elements.InputTags;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

@Log4j2
public class MainPage extends BasePage{

    public static final By BUTTON_CREATE_ENTRY = By.id("create-entry");
    public static final By BUTTON_ICON_HOME = By.id("back-to-overview");
    public static final By TEXT_MESSAGE_ENTER_USER = By.id("back-to-overview");
    public static final By TEXT_BUTTON_TAGS = By.xpath("//a[text() = 'Manage tags']");

    @Step("Click button create entry")
    public MainPage clickCreateButton() {
        driver.findElement(BUTTON_CREATE_ENTRY).click();
        log.info("Click button entry");
        return this;
    }
    @Step("Click button home")
    public MainPage clickButtonHome() {
        driver.findElement(BUTTON_ICON_HOME).click();
        log.info("Click button home ");
        return this;
    }
    @Step("Text message records")
    public String textMessageRecords(String text) {
        driver.findElement(TEXT_MESSAGE_ENTER_USER).getText();
        log.info("Created record text " +text);
        return this.toString();
    }
    @Step("Select check box")
    public void selectCheckBox(){
        new CheckBox(driver).selectCheckBox();
        log.info("Select check box");
    }
    @Step("Search input")
    public MainPage searchInput(String text){
        new InputSearch(driver).searchInput(text);
        log.info("Search records by text " + text);
        return this;
    }
    @Step("Search message")
    public String messageSearch(){
       return new InputSearch(driver).messageSearch();
    }

    @Step("Select date calendar")
    public MainPage selectDate(String monthYear, String day) throws InterruptedException {
        new Calendar(driver).selectDate(monthYear, day);
        log.info("Search entries by date " + monthYear  +  day);
        return this;
    }
    @Step("Message search date")
    public String getMessageCalendar(){
      String date =  new Calendar(driver).getMessageEntries();
        log.info("Message that the record was found by date " + date);
        return date;
    }

    @Step("Create a message tag")
    public void createTagPost(String text){
        new InputTags(driver).searchTags(text);
        log.info("Create a message tag" + text);
    }

    @Step("Get create a message tag")
    public String getMessageTags(){
     String text = new InputTags(driver).getMessageTags();
     log.info("Get create a message tag " + text);
     return text;
    }

    @Step("Click button tag")
    public MainPage clickButtonTextTag(){
        driver.findElement(TEXT_BUTTON_TAGS).click();
        log.info("Click button tag");
        return this;
    }

    @Step("Select tag name")
    public MainPage selectingTagName(String text){
        new InputTags(driver).selectTagText(text);
        log.info("Select tag name " + text);
        return this;
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}
