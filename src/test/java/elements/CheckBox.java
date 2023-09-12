package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {

    WebDriver driver;


    public static By CHECK_BOX_LOCATOR = By.xpath("//input[@type = 'checkbox']");


    public CheckBox selectCheckBox() {
        List<WebElement> entry = driver.findElements(CHECK_BOX_LOCATOR);
        entry.get(0).click();
        return this;

    }

    public CheckBox(WebDriver driver) {
        this.driver = driver;

    }
}
