package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class Alert {
    public static By BUTTON_DELETE = By.id("delete-entries");
    WebDriver driver;

    public void clickButtonDelete(){
        driver.findElement(BUTTON_DELETE).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.getText();

        alert.accept();
    }

    public Alert(WebDriver driver) {
        this.driver = driver;
    }
}
