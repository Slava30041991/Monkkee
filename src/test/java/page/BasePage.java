package page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String BASE_URL = "https://monkkee.com";
    public static final String BASE_URL_LOGIN_PAGE = BASE_URL + "/app/#/";
    public static final By SING_AP_FREE = By.xpath("//a[@class = 'btn btn-primary home__register-btn']");
    public static final By MAIN_PAGE = By.id("create-entry");

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait =new WebDriverWait(driver,20);

    }
    public abstract boolean isPageOpen();

    public boolean isExist(By locator){
        try
        {return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
