package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class HomePage extends BasePage{
    public static By BUTTON_LOGIN_HOME_PAGE = By.xpath(" //a[text() = 'Login']");
    public static final By SING_AP_FREE = By.xpath("//a[@class = 'btn btn-primary home__register-btn']");
    public static final By MESSAGE_LOCATOR_REGISTRATION_TEXT = By.xpath("//h1[normalize-space(text()) = 'Registration']");
    @Step("Open home page")
    public HomePage open() {
        driver.get(BASE_URL);
        log.info("Homepage open");
        return this;
    }
    @Step("button test")
    public String buttonTestSingUP() {
        driver.get(BASE_URL);
        log.info("Homepage open");
        driver.findElement(SING_AP_FREE).click();
        log.info("Click button " + SING_AP_FREE);
        return driver.findElement(MESSAGE_LOCATOR_REGISTRATION_TEXT).getText();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Step("Page open")
    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR) ;
    }
}
