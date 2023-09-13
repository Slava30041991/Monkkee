package tests;


import org.testng.annotations.Test;

import java.io.IOException;


public class DownloaderTest extends BaseTest {
    String fileLocator = "";

    @Test(description = "Download document")
    public void downloadDocumentFormat() throws IOException, InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton();
        settingsPage.selectSettingExport();
        downloaderPage.selectFileDownload();
        downloaderPage.clickDownloadOk();
        downloader("//div[@class = 'col-sm-4 col-sm-offset-3']/ancestor::div[@class = 'content-container clearfix ng-scope']//button","r");


    }

    }


