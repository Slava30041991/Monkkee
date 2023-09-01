package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {

    WebDriver driver;
    String value;

    String checkBoxLocator = "//div[normalize-space(text()) = '%s']/ancestor::div[@class = 'checkbox-datetime-wrapper']/div/input";

    public void selectCheckBox(){
        driver.findElement(By.xpath(String.format(checkBoxLocator,this.value))).click();
    }
    public CheckBox(WebDriver driver, String value) {
        this.driver = driver;
        this.value = value;
    }
}
