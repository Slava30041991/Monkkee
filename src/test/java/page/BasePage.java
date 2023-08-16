package page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String BASE_URL = "https://monkkee.com";
    String languageLocator = "//span[contains (@class, 'active')]/..//a[text() = '%s']";
    public static final By PAGE_LANGUAGE = By.xpath("//div[contains(@class ,'uccess')]");
    public static final By PAGE_LOCATOR = By.xpath("//a[text() = 'Homepage']");

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
