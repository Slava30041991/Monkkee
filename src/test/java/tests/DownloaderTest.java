package tests;

import org.testng.annotations.Test;

public class DownloaderTest extends BaseTest{
    @Test(description = "Download document")
    public void downloadDocumentFormat(){
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton();
        settingsPage.selectSettingExport();
        downloaderPage.fileClickRadiobutton();
        settingsPage.clickButtonOkExport();



    }
    }


