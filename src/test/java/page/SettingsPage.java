package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class SettingsPage extends BasePage {
    public static By BUTTON_SETTINGS = By.xpath("//button[@class = 'user-menu__btn']/ancestor::span[@class = 'ng-scope']//i[@class = 'icon-cog icon-light']");
    public static By LOGOUT_BUTTON = By.xpath("//button[@class = 'user-menu__btn']");
    public static By LIST_SETTINGS = By.xpath("//div[@id = 'settings-menu']//li");
    public static By LIST_LANGUAGE = By.xpath("//option[@value]/ancestor::div[@class = 'col-sm-4']//option");
    public static By BUTTON_OK = By.xpath("//div[@class = 'col-sm-4 col-sm-offset-3']/ancestor::div[@class = 'content-container clearfix ng-scope']//button");
    public static By TEXT_LANGUAGE = By.xpath("//div[@class = 'alert alert-success' and text()]");
    public static By NICKNAME_BUTTON = By.xpath("//input[@id = 'use-alias']/..");
    public static By NICKNAME_SELECT = By.xpath("//div//input[@id = 'alias']");
    public static By LIMIT_TIME_LIST = By.xpath("//option[@value]/ancestor::select[@name = 'autoLogout']/..//option[@value]");
    public static By LIMIT_TIME_BUTTON = By.xpath("//select[@name = 'autoLogout']");
    public static By MESSAGE_TEXT_ALIES_TIME = By.xpath("//div[@class = 'alert alert-success']");
    public static final By BUTTON_HOME_SETTING = By.xpath("//i[@class = 'icon-home icon-white']");

        @Step("Logout")
        public SettingsPage logout(){
            driver.findElement(LOGOUT_BUTTON);
            log.info("Logout");
            return this;
        }

        @Step("Click button setting")
        public SettingsPage clickSettingButton(){
             driver.findElement(BUTTON_SETTINGS).click();
             log.info("Click button setting");
            return this;
        }

        @Step("Click setting language")
        public void selectSettingLanguage () throws InterruptedException {
            Thread.sleep(600);
            List<WebElement> settings = driver.findElements(LIST_SETTINGS);
            log.info("Click setting language");
            settings.get(0).click();
        }

        @Step("Click setting alies")
        public SettingsPage selectSettingAlies () {
            List<WebElement> settings = driver.findElements(LIST_SETTINGS);
            log.info("Click setting alies");
            settings.get(3).click();
            return this;
        }

        @Step("Click setting timeout")
        public void selectSettingTimeout () {
        List<WebElement> settings = driver.findElements(LIST_SETTINGS);
        log.info("Click setting timeout");
        settings.get(4).click();
        }

        @Step("Select and click button language")
        public SettingsPage selectLanguage () {
            List<WebElement> language = driver.findElements(LIST_LANGUAGE);
            log.info("Select and click button language");
            language.get(1).click();
            return this;
        }


        @Step("Click button OK language")
        public void clickButtonOkLanguage () {
            driver.findElement(BUTTON_OK).click();
            log.info("Click button OK language");
        }


        @Step("Text message language")
        public String textMessageLanguage (String text){
            driver.findElement(TEXT_LANGUAGE).getText();
            log.info("Text message language " + text);
            return text;
        }

        @Step("Click checkBox ")
        public SettingsPage nicknameClickCheckBox(){
            driver.findElement(NICKNAME_BUTTON).click();
            log.info("Click checkBox");
            return this;
        }


        @Step("Select nickname")
        public String selectNickName(String text) {
            driver.findElement(NICKNAME_SELECT).sendKeys(text);
            log.info("Select nickname " + text);
            return text;
        }

    @Step("Delete nickname")
    public SettingsPage deleteNickName() {
        driver.findElement(NICKNAME_SELECT).clear();
        log.info("Delete nickname");
        return this;

    }

        @Step("Click button time")
        public SettingsPage clickButtonTime(){
            driver.findElement(LIMIT_TIME_BUTTON).click();
            log.info("Click button time");
            return this;
        }

        @Step("Page active time")
        public SettingsPage listTimeLimit(){
            List<WebElement> settings = driver.findElements(LIMIT_TIME_LIST);
            log.info("Page active time");
            settings.get(0).click();
            return this;
        }

        @Step("Click button time")
        public SettingsPage clickButtonOkTime () {
        driver.findElement(BUTTON_OK).click();
        log.info("Click button time");
        return this;
        }
    @Step("Text message time and alias")
    public String getMessageTextAliasAndTime(String text) {
        driver.findElement(MESSAGE_TEXT_ALIES_TIME).getText();
        log.info("Text message time and alias " + text);
        return text;
    }

    @Step("Click button home Settings")
    public SettingsPage clickButtonSettingsHome () throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(BUTTON_HOME_SETTING).click();
        log.info("Click button home Settings ");
        return this;
    }

        public SettingsPage(WebDriver driver) {
            super(driver);
        }

        @Override
        public boolean isPageOpen () {
            return isExist(PAGE_LOCATOR);
        }
    }