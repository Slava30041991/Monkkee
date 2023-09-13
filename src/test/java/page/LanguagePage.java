package page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class LanguagePage extends BasePage{

    @Step("Choose language page")
    public LanguagePage languageSelection(String language){
        driver.findElement(By.xpath(String.format(languageLocator, language))).click();
        log.info("Choose language page " + language);
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
