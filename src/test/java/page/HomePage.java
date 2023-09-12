package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class HomePage extends BasePage{
    public static final By SING_AP_FREE = By.xpath("//a[@class = 'btn btn-primary home__register-btn']");
    public static final By MESSAGE_LOCATOR_REGISTRATION_TEXT = By.xpath ("//h1[normalize-space(text()) = 'Registration']");
    public static final By HEADER_TEXT_MENU = By.xpath("//h2[@class]");
    String languageLocator = "//a[text() = '%s']";
    String menuSelection = "//a[normalize-space(text())]/ancestor::div[@class = 'header__menu']//a[text() = '%s']";



    @Step("Open home page")
    public HomePage open() {
        driver.get(BASE_URL);
        log.info("Homepage open");
        return this;
    }
    @Step("Button click")
    public void clickButtonSingUP() {
        driver.findElement(SING_AP_FREE).click();
        log.info("Click button " + SING_AP_FREE);
    }
    @Step("Text registration")
    public String getTextMessageRegistration(){
       return driver.findElement(MESSAGE_LOCATOR_REGISTRATION_TEXT).getText();

    }
    public HomePage choiceLanguageClick(String language){
            driver.findElement(By.xpath(String.format(languageLocator, language))).click();
            return this;
    }

    public void clickHeaderMenu (String menuName) {
    driver.findElement(By.xpath(String.format(menuSelection,menuName))).click();
    }

    public String getTextHomeRubricAbout() {
        List<WebElement> textAbout = driver.findElements(HEADER_TEXT_MENU);
        String text = textAbout.get(0).getText();
        return text;
    }
    public String getTextHomeRubricFeatures() {
        List<WebElement> textAbout = driver.findElements(HEADER_TEXT_MENU);
        String text = textAbout.get(1).getText();
        return text;
    }
    public String getTextHomeRubricSecurity() {
        List<WebElement> textAbout = driver.findElements(HEADER_TEXT_MENU);
        String text = textAbout.get(2).getText();
        return text;
    }
    public String getTextHomeRubricDonate() {
        List<WebElement> textAbout = driver.findElements(HEADER_TEXT_MENU);
        String text = textAbout.get(3).getText();
        return text;
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
