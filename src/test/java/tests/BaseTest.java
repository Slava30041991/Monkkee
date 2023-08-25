package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;
import page.LoginPage;
import page.MainPage;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    String email, password;

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    MainPage mainPage;

    @Step("Setting up and opening the browser")
    @BeforeMethod
    public void setUp() {
        System.getenv().getOrDefault("MONKKEE_URL", PropertyReader.getProperty("monkkee.url"));
        email = System.getenv().getOrDefault("MONKKEE_EMAIL", PropertyReader.getProperty("monkkee.email"));
        password = System.getenv().getOrDefault("MONKKEE_PASSWORD", PropertyReader.getProperty("monkkee.password"));
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("-incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
}
    @Step("Exit the browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}