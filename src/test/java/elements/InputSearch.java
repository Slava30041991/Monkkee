package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputSearch {
    public static final By MESSAGE_SEARCH = By.xpath("//span[@class ='ng-binding search-parameter']");

    WebDriver driver;

    public static By SEARCH_INPUT = By.id("appendedInputButton");

    public void searchInput(String text){
        driver.findElement(SEARCH_INPUT).sendKeys(text,Keys.ENTER);
    }
    public String messageSearch(){
       String text =  driver.findElement(MESSAGE_SEARCH).getText();
       return text;


    }
    public InputSearch(WebDriver driver) {
        this.driver = driver;

    }

}
