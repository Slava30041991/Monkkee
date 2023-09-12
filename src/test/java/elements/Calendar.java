package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Calendar {
    WebDriver driver;
    public static By CALENDAR_LOCATOR = By.id("datepicker");
    public static By GET_MESSAGE_CALENDAR = By.xpath("//span[@class = 'ng-binding search-parameter']");
    String monthYearLocator = "//div[contains(@class ,'datepicker dropdown-menu')]//th[text() = '%s']";
    String dayLocator = "//div[contains(@class, 'datepicker')]//td[text() = '%s']";

    public Calendar selectDate(String monthYear, String day)  {

        driver.findElement(CALENDAR_LOCATOR).click();
        driver.findElement(By.xpath(String.format(monthYearLocator, monthYear))).getText();
        driver.findElement(By.xpath(String.format(dayLocator, day))).click();
        return this;
    }
        public String getMessageEntries () {
        String dataMessage = driver.findElement(GET_MESSAGE_CALENDAR).getText();
        return dataMessage;


        }


    public Calendar(WebDriver driver) {
        this.driver = driver;
    }
}
