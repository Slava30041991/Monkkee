package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class DownloaderTest extends BaseTest{

    @Test(description = "Download document")
    public void downloadDocumentFormat() throws IOException, InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton();
        settingsPage.selectSettingExport();
        downloaderPage.selectFileDownload();
        downloaderPage.fileClickRadiobutton(".PDF");

    }

    }


