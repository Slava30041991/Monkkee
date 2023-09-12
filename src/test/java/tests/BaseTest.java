package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import page.*;
import utils.PropertyReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    String email, password;
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    MainPage mainPage;
    TextEditorPage textEditorPage;
    ContextMenuPage contextMenuPage;
    SettingsPage settingsPage;
    DownloaderPage downloaderPage;
    LanguagePage languagePage;
    String patchToDownload = System.getProperty("user dir") + "src/test/downloads";
    String downLoadNameFile;



    @Parameters({"browser"})
    @BeforeMethod

    @Step("Setting up and opening the browser")
    public void setUp(@Optional("chrome")String browser, ITestContext testContext) {

        if (browser.equals("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.prompt_for_download", "false");
            chromePrefs.put("download.default_directory", patchToDownload);

            options.setExperimentalOption("prefs", chromePrefs);


//            HashMap<String, Object> chromePrefs = new HashMap<>();
//            chromePrefs.put("profile.default_content_settings.popups", 0);
//            chromePrefs.put("download.default_directory", patchToDownload);
//            options.setExperimentalOption("prefs", chromePrefs);

            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        } else {

            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();

    }






        email = System.getenv().getOrDefault("MONKKEE_EMAIL", PropertyReader.getProperty("monkkee.email"));
        password = System.getenv().getOrDefault("MONKKEE_PASSWORD", PropertyReader.getProperty("monkkee.password"));

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        textEditorPage = new TextEditorPage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        settingsPage = new SettingsPage(driver);
        downloaderPage = new DownloaderPage(driver);
        languagePage = new LanguagePage(driver);
    }

            @Step("Exit the browser")
            @AfterMethod(alwaysRun = true)
            public void tearDown() {
                driver.quit();
            }
    public void downloader (String fileLocator, String nameDownloadedFile) throws IOException, InterruptedException {
        WebElement ourFile = driver.findElement(By.xpath(fileLocator));
        FileUtils.cleanDirectory(new File(downLoadNameFile));
        File folder = new File(downLoadNameFile);
        File[] listOfFiles = folder.listFiles();

        ourFile.click();
   }}

