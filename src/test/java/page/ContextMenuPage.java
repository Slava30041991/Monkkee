package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class ContextMenuPage extends BasePage {
    public static By BUTTON_DELETE = By.id("delete-entries");
    public static By BUTTON_DELETE_TEG = By.xpath("//a[@ng-click = 'deleteTag(tag)']") ;

    public ContextMenuPage clickButtonDelete() {
        driver.findElement(BUTTON_DELETE).click();
        return this;
    }
    @Step("Click button teg")
    public void clickButtonTeg(){
        driver.findElement(BUTTON_DELETE_TEG).click();
        log.info("Click button teg");
    }
    @Step("Get text alert")
    public String getText(){
        Alert alert = driver.switchTo().alert();
        log.info("Get text alert " + alert);
        return alert.getText();
    }

    @Step("Alert accept")
    public void alertAccept(){
        Alert alert = driver.switchTo().alert();
        log.info("Alert text " + alert);
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
