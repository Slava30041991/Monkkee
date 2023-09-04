package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputTags {
    WebDriver driver;

    public static By TAGS_INPUT = By.id("new-tag");
    public static By TAGS_INPUT_BUTTON = By.id("assign-new-tag");
    String tagsInput = "new-tag";
    String tagsButtonLocator = "assign-new-tag";
    public void searchTags(String text){
        driver.findElement(TAGS_INPUT).sendKeys(text);
        driver.findElement(TAGS_INPUT_BUTTON).click();

    }


    public InputTags(WebDriver driver, String text) {
        this.driver = driver;
    }
}
