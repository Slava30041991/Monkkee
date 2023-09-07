package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenuPage extends BasePage {
    WebDriverWait wait;
    public static By BUTTON_DELETE = By.id("delete-entries");
    public static By BUTTON_DELETE_TEG = By.xpath("//a[@ng-click = 'deleteTag(tag)']") ;


    public void clickButtonDelete() {
        driver.findElement(BUTTON_DELETE).click();
    }
    public void clickButtonTeg(){
        driver.findElement(BUTTON_DELETE_TEG).click();
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
        return isExist(PAGE_LOCATOR) ;
    }
}
