package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InputTags {
    WebDriver driver;

    public static By TAGS_INPUT = By.id("new-tag");
    public static By TAGS_INPUT_BUTTON = By.id("assign-new-tag");
    public static By MESSAGE_TAGS = By.xpath("//span[@class = 'tag ng-binding ng-scope']");

    //String messageTags = "//div[@class = 'tags']";
   String textTag = "//td[normalize-space(text()) ='%s']/..//i[@class = 'icon-trash icon-white']/..";


    public void searchTags(String text){
        driver.findElement(TAGS_INPUT).sendKeys(text);
        driver.findElement(TAGS_INPUT_BUTTON).click();
    }
    public String getMessageTags(){
        List<WebElement> elements = driver.findElements(MESSAGE_TAGS);
        String text =  elements.get(0).getText();
        return text;
    }
    public void selectTagText(String text){
        driver.findElement(By.xpath(String.format(textTag,text)));

    }



    public InputTags(WebDriver driver) {
        this.driver = driver;
    }


}
