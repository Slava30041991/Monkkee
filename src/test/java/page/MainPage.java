package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class MainPage extends BasePage{

    public static final By BUTTON_CREATE_ENTRY = By.id("create-entry");
    public static final By REDACTORY = By.id("editable");


    @Step("Click button create entry")
    public MainPage userCreateEntryClickButton(){
        driver.findElement(BUTTON_CREATE_ENTRY).click();
        log.info("Click " + BUTTON_CREATE_ENTRY);
        driver.findElement(REDACTORY).sendKeys("bttvvvvvvvvvvvvvvvvvvvvvvvvvvdggggggggg");
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
