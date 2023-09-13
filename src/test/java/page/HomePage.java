package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
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
        log.info("Open home page " + BASE_URL);
        return this;
    }
    @Step("Click button sing up")
    public void clickButtonSingUP() {
        driver.findElement(SING_AP_FREE).click();
        log.info("Click button sing up ");
    }
    @Step("Text registration")
    public String getTextMessageRegistration(){
       return driver.findElement(MESSAGE_LOCATOR_REGISTRATION_TEXT).getText();
    }

    @Step("Choice and click by language")
    public HomePage choiceLanguageClick(String language){
            driver.findElement(By.xpath(String.format(languageLocator, language))).click();
            log.info("Choice and click by language " + language);
            return this;
    }
    @Step("Choice and click header menu")
    public void clickHeaderMenu (String menuName) {
    driver.findElement(By.xpath(String.format(menuSelection,menuName))).click();
    log.info("Choice and click header menu " + menuName );
    }

    @Step("Text home rubric about")
    public String getTextHomeRubricAbout() {
        List<WebElement> textAbout = driver.findElements(HEADER_TEXT_MENU);
        String text = textAbout.get(0).getText();
        log.info("Text home rubric about " + text);
        return text;
    }

    @Step("Text home rubric features")
    public String getTextHomeRubricFeatures() {
        List<WebElement> textAbout = driver.findElements(HEADER_TEXT_MENU);
        String text = textAbout.get(1).getText();
        log.info("Text home rubric features " + text);
        return text;
    }

    @Step("Text home rubric security")
    public String getTextHomeRubricSecurity() {
        List<WebElement> textAbout = driver.findElements(HEADER_TEXT_MENU);
        String text = textAbout.get(2).getText();
        log.info("Text home rubric security " + text);
        return text;
    }
    @Step("Text home rubric donate")
    public String getTextHomeRubricDonate() {
        List<WebElement> textAbout = driver.findElements(HEADER_TEXT_MENU);
        String text = textAbout.get(3).getText();
        log.info("Text home rubric donate " + text);
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
