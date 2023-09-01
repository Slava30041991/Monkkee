package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class TextEditorPage extends BasePage {

    String buttonSave = ("//span[@class = 'cke_button_icon']");
    //todo
    String buttonSpecialCharacter = ("//a[@id = 'cke_637']"); //Smile,time stamp,horizontal line

    public static final By REDACTOR = By.xpath("//p/ancestor::div[@id = 'editable']/p");

    @Step("Enter text")
    public TextEditorPage enterText(String text) {
        log.info("Enter " + text);
        driver.findElement(REDACTOR).sendKeys(text);
        return this;

    }
    @Step("Click button save")
    public void clickButtonSave (){
        log.info("Click" + buttonSave);
        driver.findElement(By.xpath(String.format(buttonSave))).click();
    }

    public TextEditorPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }


}
