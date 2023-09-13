package page;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.util.List;
@Log4j2

public class TextEditorPage extends BasePage {
    public static By BUTTON_SAVE = By.xpath("//span[@class = 'cke_button_icon']");
    public static By TOOL_GROUP_BUTTON= By.xpath("//span[@class ='cke_toolgroup']/ancestor::span[@id = 'cke_30']//a");
    public static final By REDACTOR = By.xpath("//p/ancestor::div[@id = 'editable']/p");
    public static final By SELECT_FILE_BUTTON = By.xpath("//input[@name= 'txtUpload']");
    public static final By UPLOAD_BUTTON_OK = By.xpath("//span[@class = 'cke_dialog_ui_button']");



    @Step("Enter text")
    public TextEditorPage enterText(String text) {
        driver.findElement(REDACTOR).sendKeys(text);
        log.info("Enter text" + text);
        return this;

    }
    @Step("Click button save")
    public void clickButtonSave () throws InterruptedException {
        Thread.sleep(600);
        driver.findElement(BUTTON_SAVE).click();
        log.info("Click button save");
    }

    @Step("Click button emage")
    public TextEditorPage buttonBlockEmage(){
        List<WebElement> button = driver.findElements(TOOL_GROUP_BUTTON);
        button.get(2).click();
        log.info("Select button block");
        return this;
    }
    @Step("Select file loading ")
    public TextEditorPage selectFileLoading () throws InterruptedException {
        Thread.sleep(400);
        WebElement element = driver.findElement(By.xpath("//iframe[@title = 'Upload']"));
        driver.switchTo().frame(element);
        File file = new File("src/test/resources/SQL-SELECT.png");
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(file.getAbsolutePath());
        log.info("Uploading a picture");
        driver.switchTo().defaultContent();
        List<WebElement> elements = driver.findElements(UPLOAD_BUTTON_OK);
        elements.get(0).click();
        log.info("Click button ok");
        return this;
    }

    public TextEditorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}