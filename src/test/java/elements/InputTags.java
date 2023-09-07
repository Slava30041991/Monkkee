package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputTags {
    WebDriver driver;

    public static By TAGS_INPUT = By.id("new-tag");
    public static By TAGS_INPUT_BUTTON = By.id("assign-new-tag");
   String messageTags = "//div[@class = 'tags']/span[normalize-space(text()) = '%s']";
   String textTag = "//td[normalize-space(text()) ='%s']/..//i[@class = 'icon-trash icon-white']/..";


    public void searchTags(String text){
        driver.findElement(TAGS_INPUT).sendKeys(text);
        driver.findElement(TAGS_INPUT_BUTTON).click();
    }
    public void getMessageTags(String text){
        driver.findElement(By.xpath(String.format(messageTags,text)));
    }
    public void selectTagText(String textT){
        driver.findElement(By.xpath(String.format(textTag,textT)));

    }



    public InputTags(WebDriver driver) {
        this.driver = driver;
    }


}
