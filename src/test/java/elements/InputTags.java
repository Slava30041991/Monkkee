package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputTags {
    WebDriver driver;
    String value;



    public static By TAGS_INPUT = By.id("new-tag");
    public static By TAGS_INPUT_BUTTON = By.id("assign-new-tag");
   String messageTags = "//div[@class = 'tags']/span[normalize-space(text()) = '%s']";
   String buttonDeleteTag = "//td[normalize-space(text()) ='%s']/..//i[@class = 'icon-trash icon-white']/..";


    public void searchTags(String text){
        driver.findElement(TAGS_INPUT).sendKeys(text);
        driver.findElement(TAGS_INPUT_BUTTON).click();
    }
    public void getMessageTags(String text){
        driver.findElement(By.xpath(String.format(messageTags,text)));
    }
    public void selectRemoveTag(String text){
        driver.findElement(By.xpath(String.format(buttonDeleteTag,text))).click();

    }

    public InputTags(WebDriver driver, String value) {
        this.driver = driver;
        this.value = value;
    }


}
