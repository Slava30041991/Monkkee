package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
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
import utils.TestListener;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


import static org.testng.Assert.assertEquals;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    String email, password;
    public static String downloadPath = System.getProperty("user.dir") + "\\src\\test\\resources\\filesForUploading";
    int wait = 150000;
    boolean fileIsNotReady = true;
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
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {

        if (browser.equals("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.prompt_for_download", "false");
            chromePrefs.put("download.default_directory", patchToDownload);

            options.setExperimentalOption("prefs", chromePrefs);


            options.addArguments("--start-maximized");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        } else if (browser.equals("edge")) {

            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        } else if (browser.equals("opera")) {

            WebDriverManager.operadriver().setup();
            OperaOptions options = new OperaOptions();
            driver = new OperaDriver(options);
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


    public void downloader(String fileLocator, String nameDownloadedFile) throws IOException, InterruptedException {
        WebElement ourFile = driver.findElement(By.xpath(fileLocator));
        FileUtils.cleanDirectory(new File(downloadPath));
        File folder = new File(downloadPath);
        File[] listOfFiles = folder.listFiles();


        ourFile.click();

        while (wait != 0 && fileIsNotReady) {
            listOfFiles = folder.listFiles();
            Thread.sleep(100);
            wait -= 100;
            if ((listOfFiles.length != 0 && listOfFiles[0].getName().contains("crdownload"))) {
                fileIsNotReady = false;
            }
        }
        assertEquals(listOfFiles[0].getName(), nameDownloadedFile.contains("monkkee"));


    }
    public void deleteAllFilesFromDirectory() {
        File file = new File(downloadPath);
        String[] currentFiles;
        if (file.isDirectory()) {
            currentFiles = file.list();
            for (String currentFile : currentFiles) {
                File myFile = new File(file, currentFile);
                myFile.delete();
            }
        }
    }
}

