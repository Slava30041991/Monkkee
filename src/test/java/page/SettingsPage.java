package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class SettingsPage extends BasePage {
    public static By BUTTON_SETTINGS = By.xpath("//button[@class = 'user-menu__btn']/ancestor::span[@class = 'ng-scope']//i[@class = 'icon-cog icon-light']");
    public static By LOGOUT_BUTTON = By.xpath("//button[@class = 'user-menu__btn']");
    public static By LIST_SETTINGS = By.xpath("//div[@id = 'settings-menu']//li");
    public static By LIST_LANGUAGE = By.xpath("//option[@value]/ancestor::div[@class = 'col-sm-4']//option");
    public static By BUTTON_OK = By.xpath("//div[@class = 'col-sm-4 col-sm-offset-3']/ancestor::div[@class = 'content-container clearfix ng-scope']//button");
    public static By TEXT_LANGUAGE = By.xpath("//div[@class = 'alert alert-success' and text()]");
    public static By NICKNAME_BUTTON = By.xpath("//input[@id = 'use-alias']/..");
    public static By NICKNAME_INPUT = By.xpath("//input[@id = 'alias']/..");
    public static By NICKNAME_SELECT = By.xpath("//div//input[@id = 'alias']");
    public static By LIMIT_TIME_LIST = By.xpath("//option[@value]/ancestor::select[@name = 'autoLogout']/..//option[@value]");
    public static By LIMIT_TIME_BUTTON = By.xpath("//select[@name = 'autoLogout']");
    public static By MESSAGE_TEXT_TIME = By.xpath("//div[normalize-space(text()) = 'Suas configurações foram salvas com sucesso']");


        public void logout(){
            driver.findElement(LOGOUT_BUTTON);
        }
        public void clickSettingButton(){
             driver.findElement(BUTTON_SETTINGS).click();
        }
        public void selectSettingLanguage () {
            List<WebElement> settings = driver.findElements(LIST_SETTINGS);
            settings.get(0).click();
        }
        public void selectSettingAlies () {
            List<WebElement> settings = driver.findElements(LIST_SETTINGS);
            settings.get(3).click();
        }
        public void selectSettingTimeout () {
        List<WebElement> settings = driver.findElements(LIST_SETTINGS);
        settings.get(4).click();

        }
        public void selectLanguage () {
            List<WebElement> language = driver.findElements(LIST_LANGUAGE);
            language.get(3).click();
        }
        public void selectSettingExport () {
        List<WebElement> file = driver.findElements(LIST_SETTINGS);
        file.get(6).click();
        }
        public void clickButtonOkLanguage () {
            driver.findElement(BUTTON_OK).click();
        }
         public void clickButtonOkExport () {
        driver.findElement(BUTTON_OK).click();
        }
        public String textMessageLanguage (String text){
            driver.findElement(TEXT_LANGUAGE).getText();
            return text;
        }
        public void nicknameClickCheckBox(){
            driver.findElement(NICKNAME_BUTTON).click();
        }

        public void clickNickname(){
            driver.findElement(NICKNAME_INPUT).click();
        }
        public void selectNickName(String text){
            driver.findElement(NICKNAME_SELECT).sendKeys(text);
        }


        public void clickButtonTime(){
            driver.findElement(LIMIT_TIME_BUTTON).click();
        }

        public void listTimeLimit(){
            List<WebElement> settings = driver.findElements(LIMIT_TIME_LIST);
            settings.get(0).click();
        }
        public void clickButtonOkTime () {
        driver.findElement(BUTTON_OK).click();
    }
        public String getMessageTextTime(String text){
            driver.findElement(MESSAGE_TEXT_TIME).getText();
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