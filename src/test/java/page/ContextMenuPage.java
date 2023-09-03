package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContextMenuPage extends BasePage {
    public static By BUTTON_DELETE = By.id("delete-entries");


    public void clickButtonDelete() {
        driver.findElement(BUTTON_DELETE).click();
    }

    public String getText(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    public void alertAccept(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isPageOpen() {
        return false;
    }
}
