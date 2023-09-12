package page;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LanguagePage extends BasePage{


    @Step("The user selects and changes the language")
    public LanguagePage languageSelection(String language){
        driver.findElement(By.xpath(String.format(languageLocator, language))).click();
        return this;
    }
    @Step("Language change message")
    public String languageMessage(){
        return driver.findElement(LANGUAGE_TEXT).getText();
    }

    public LanguagePage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}
