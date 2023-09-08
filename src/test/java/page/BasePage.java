package page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

public abstract class BasePage {
    static WebDriver driver;
    WebDriverWait wait;

    public static final String BASE_URL = "https://monkkee.com";
    String languageLocator = "//span[contains (@class, 'active')]/..//a[text() = '%s']";
    public static final By DE_LANGUAGE_TEXT = By.xpath("//div[contains(text() ,'Sprache temporär geändert.')]");
    public static final By FR_LANGUAGE_TEXT = By.xpath("//div[contains(text() ,'Langue temporairement changée. ')]");
    public static final By PT_LANGUAGE_TEXT = By.xpath("//div[contains(text() ,'Idioma alterado temporariamente.')]");
    public static final By PAGE_LOCATOR = By.xpath("//a[text() = 'Homepage']");
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait =new WebDriverWait(driver,20);
        System.getenv().getOrDefault("MONKKEE_URL", PropertyReader.getProperty("monkkee.url"));

    }



    public abstract boolean isPageOpen();

    public static boolean isExist(By locator){
        try
        {return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}