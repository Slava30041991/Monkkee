package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SettingsPage extends BasePage {

    public static By BUTTON_SETTINGS = By.xpath("//button[@class = 'user-menu__btn']/ancestor::span[@class = 'ng-scope']//i[@class = 'icon-cog icon-light']");
    public static By LOGOUT_BUTTON = By.xpath("//button[@class = 'user-menu__btn']");
    public static By LIST_SETTINGS = By.xpath("//div[@id = 'settings-menu']//li");
    public static By LIST_LANGUAGE = By.xpath("//option[@value]/ancestor::div[@class = 'col-sm-4']//option");
    public static By BUTTON_OK = By.xpath("//div[@class = 'col-sm-4 col-sm-offset-3']/ancestor::div[@class = 'content-container clearfix ng-scope']//button");
    public static By TEXT_LANGUAGE = By.xpath("//div[@class = 'alert alert-success' and text()]");


        public void logout(){
            driver.findElement(LOGOUT_BUTTON);
        }
        public void clickSettingButton(){
             driver.findElement(BUTTON_SETTINGS).click();
        }
        public void selectSetting () {
            List<WebElement> settings = driver.findElements(LIST_SETTINGS);
            settings.get(0).click();
        }
        public void selectLanguage () {
            List<WebElement> language = driver.findElements(LIST_LANGUAGE);
            language.get(3).click();
        }
        public void clickButtonOkLanguage () {
            driver.findElement(BUTTON_OK).click();
        }
        public String textMessageLanguage (String text){
            driver.findElement(TEXT_LANGUAGE).getText();
            return text;
        }

        public SettingsPage(WebDriver driver) {
            super(driver);
        }
        @Override
        public boolean isPageOpen () {
            return isExist(PAGE_LOCATOR);
        }
    }