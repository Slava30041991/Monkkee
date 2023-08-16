package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{


    @Test
    public void userCreateEntry(){
        loginPage.open();
        loginPage.userEnterLoginAndPassword("balahenka30041991@gmail.com", "Valy270619");
        loginPage.userClickButton();
        mainPage.userCreateEntryClickButton();

        Assert.assertTrue(loginPage.isPageOpen());
    }

}
