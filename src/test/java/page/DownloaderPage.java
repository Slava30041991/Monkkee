package page;


import elements.Radiobutton;

import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;
import static org.testng.Assert.assertEquals;
import static page.SettingsPage.BUTTON_OK;

public class DownloaderPage extends BasePage{
    public static By BUTTON_OK = By.xpath("//div[@class = 'col-sm-4 col-sm-offset-3']/ancestor::div[@class = 'content-container clearfix ng-scope']//button");

    boolean fileIsNotReady = true;
    int wait = 10000;
    String downLoadNameFile;
    DownloaderPage downloaderPage;
    String patchToDownload = System.getProperty("user dir") + "src/test/downloads";

    public void selectFileDownload(){
        new Radiobutton(driver).clickRadiobutton();
    }

    public void  fileClickRadiobutton(String nameDownloadedFile) throws IOException, InterruptedException {

            driver.findElement(BUTTON_OK).click();
            FileUtils.cleanDirectory(new File(patchToDownload));
            File folder = new File(patchToDownload);
            File[]listOfFile = folder.listFiles();


            while (wait != 0 && fileIsNotReady) {
                listOfFile = folder.listFiles();
                Thread.sleep(100);
                wait -= 100;
                if (listOfFile.length != 0 && listOfFile[0].getName().equals(nameDownloadedFile)) {
                    fileIsNotReady = false;


                    assertEquals(listOfFile[0].getName(), nameDownloadedFile);
                }
            }

    }

    public DownloaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}
