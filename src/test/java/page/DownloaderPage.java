package page;

import elements.Calendar;
import elements.Radiobutton;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class DownloaderPage extends BasePage{


    public DownloaderPage(WebDriver driver) {
        super(driver);
    }

    public void  fileClickRadiobutton(){
        new Radiobutton(driver).clickRadiobutton();
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}
