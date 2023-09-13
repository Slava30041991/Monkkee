package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import lombok.extern.log4j.Log4j2;
@Log4j2

public class Calendar {
    WebDriver driver;
    public static By CALENDAR_LOCATOR = By.id("datepicker");
    public static By GET_MESSAGE_CALENDAR = By.xpath("//span[@class = 'ng-binding search-parameter']");
    String monthYearLocator = "//div[contains(@class ,'datepicker dropdown-menu')]//th[text() = '%s']";
    String dayLocator = "//div[contains(@class, 'datepicker')]//td[text() = '%s']";

    public Calendar selectDate(String monthYear, String day) throws InterruptedException {
        Thread.sleep(600);
        driver.findElement(CALENDAR_LOCATOR).click();
        log.info("Сlick on the calendar field ");
        driver.findElement(By.xpath(String.format(monthYearLocator, monthYear))).getText();
        log.info("Enter date and year " + monthYear);
        driver.findElement(By.xpath(String.format(dayLocator, day))).click();
        log.info("Select and click on the day " + day);
        return this;
    }
        public String getMessageEntries () {
        String dataMessage = driver.findElement(GET_MESSAGE_CALENDAR).getText();
        log.info("Receive a message about a found record");
        return dataMessage;

        }

    public Calendar(WebDriver driver) {
        this.driver = driver;
    }
}
