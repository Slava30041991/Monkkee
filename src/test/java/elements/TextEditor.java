package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextEditor {

    WebDriver driver;
    String buttonSave = ("//span[@class = 'cke_button_icon']");
    String buttonSpecialCharacter = ("//a[@id = 'cke_637']"); //Smile,time stamp,horizontal line


    public TextEditor(WebDriver webDriver) {
        this.driver = webDriver;


    }
    public void clickButtonSave (){
        driver.findElement(By.xpath(String.format(buttonSave))).click();

    }
}
