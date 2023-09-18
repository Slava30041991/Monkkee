package elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import lombok.extern.log4j.Log4j2;
@Log4j2

public class InputTags {
    WebDriver driver;
    String label;

    public InputTags (WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    public static By TAGS_INPUT = By.id("new-tag");
    public static By TAGS_INPUT_BUTTON = By.id("assign-new-tag");
    public static By MESSAGE_TAGS = By.xpath("//a[@class = 'tag pointer ng-binding']");
    String textTag = "//td[normalize-space(text()) ='%s']/..//i[@class = 'icon-trash icon-white']/..";


    public void searchTags(String text){


        driver.findElement(TAGS_INPUT).sendKeys(text);

        log.info("Search for a tag by text " + text);
        driver.findElement(TAGS_INPUT_BUTTON).click();
        log.info("Click button tags");
    }

    public String getMessageTags(){
        List<WebElement> elements = driver.findElements(MESSAGE_TAGS);
        String text =  elements.get(0).getText();
        log.info("Text message " + text);
        return text;
    }

    public void selectTagText(String text){
        driver.findElement(By.xpath(String.format(textTag,text)));
        log.info("Select tag by text " + text);
    }

    public InputTags(WebDriver driver) {
        this.driver = driver;
    }

}
