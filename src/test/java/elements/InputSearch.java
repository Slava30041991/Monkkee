package elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class InputSearch {
    WebDriver driver;
    public static final By MESSAGE_SEARCH = By.xpath("//span[@class ='ng-binding search-parameter']");
    public static By SEARCH_INPUT = By.id("appendedInputButton");

    public void searchInput(String text){
        driver.findElement(SEARCH_INPUT).sendKeys(text,Keys.ENTER);
        log.info("Input search " + text);

    }
    public String messageSearch(){
       String text =  driver.findElement(MESSAGE_SEARCH).getText();
       log.info("Search messages by text" + text);
       return text;

    }
    public InputSearch(WebDriver driver) {
        this.driver = driver;

    }

}
