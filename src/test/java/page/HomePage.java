package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage{
    public static final By SING_AP_FREE = By.xpath("//a[@class = 'btn btn-primary home__register-btn']");
    public static final By MESSAGE_LOCATOR_REGISTRATION_TEXT = By.xpath("//h1[normalize-space(text()) = 'Registration']");
    public static final By HEADER_TEXT_MENU_ABOUT = By.xpath("//div[@id = 'about']//h2[normalize-space(text())]");
    public static final By HEADER_TEXT_MENU_FEATURES = By.xpath("//div[@id = 'features']//h2[normalize-space(text())]");
    public static final By HEADER_TEXT_MENU_SECURITY = By.xpath("//div[@id = 'security']//h2[normalize-space(text())]");
    public static final By HEADER_TEXT_MENU_DONATE = By.xpath("//div[@id = 'donate']//h2[normalize-space(text())]");
    String languageLocator = "//a[text() = '%s']";
    String menuSelection = "//a[normalize-space(text())]/ancestor::div[@class = 'header__menu']//a[text() = '%s']";



    @Step("Open home page")
    public HomePage open() {
        driver.get(BASE_URL);
        log.info("Homepage open");
        return this;
    }
    @Step("Button click")
    public void buttonClickSingUP() {
        driver.findElement(SING_AP_FREE).click();
        log.info("Click button " + SING_AP_FREE);
    }
    @Step("Text registration")
    public String getTextMessageRegistration(){

        return driver.findElement(MESSAGE_LOCATOR_REGISTRATION_TEXT).getText();
    }
    public void choiceLanguageClick(String language){
            driver.findElement(By.xpath(String.format(languageLocator, language))).click();
    }

    public void clickHeaderMenu (String menuName) {
    driver.findElement(By.xpath(String.format(menuSelection,menuName))).click();
    }

    public String getTextHomeRubricAbout(){
       return driver.findElement(HEADER_TEXT_MENU_ABOUT).getText();

    }
    public String getTextHomeRubricDonate() {
        return driver.findElement(HEADER_TEXT_MENU_DONATE).getText();
    }
    public String getTextHomeRubricFeatures() {
        return driver.findElement(HEADER_TEXT_MENU_FEATURES).getText();
    }
    public String getTextHomeRubricSecurity() {
        return driver.findElement(HEADER_TEXT_MENU_SECURITY).getText();
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
