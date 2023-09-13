package page;


import elements.Radiobutton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
@Log4j2

public class DownloaderPage extends BasePage{
    public static By BUTTON_OK = By.xpath("//div[@class = 'col-sm-4 col-sm-offset-3']/ancestor::div[@class = 'content-container clearfix ng-scope']//button");
    boolean fileIsNotReady = true;
    int wait = 10000;
    String downLoadNameFile;
    DownloaderPage downloaderPage;


    public void selectFileDownload(){
        new Radiobutton(driver).clickRadiobutton();
    }
    public DownloaderPage clickDownloadOk () {
        driver.findElement(BUTTON_OK).click();
        return this;
    }

    public DownloaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}
