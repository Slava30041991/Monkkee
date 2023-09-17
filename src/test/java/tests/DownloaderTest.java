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

        downloader("//button[@class='btn btn-default']","monkkee-20230915204824");


    }

    }


