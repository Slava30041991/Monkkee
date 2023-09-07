package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Radiobutton {
    WebDriver driver;
    public static By RADIOBUTTON = By.xpath("//div[@class = 'radio']/ancestor::div[@class = 'col-sm-9 radio-list']//div");

    public void clickRadiobutton(){
        List<WebElement> format = driver.findElements(RADIOBUTTON);
        format.get(3).click();

        }
    public Radiobutton (WebDriver driver) {
        this.driver = driver;
    }
}
