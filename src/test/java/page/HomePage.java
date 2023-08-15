package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    @Step("Open home page")
    public HomePage open() {
        driver.get(BASE_URL);
        return this;
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Step("Page open")
    @Override
    public boolean isPageOpen() {
        return isExist(SING_AP_FREE) ;
    }
}
