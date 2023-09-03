package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;

    public static By SEARCH_INPUT = By.id("appendedInputButton");

    public void searchInput(String text){
        driver.findElement(SEARCH_INPUT).sendKeys(text,Keys.ENTER);

    }





    public Input(WebDriver driver) {
        this.driver = driver;

    }

}
