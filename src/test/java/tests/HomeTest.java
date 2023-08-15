package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest{
     @Test(description = "User open website")
    public void userOpensWebsite(){
        homePage.open();
        homePage.isPageOpen();

        assertTrue(homePage.isPageOpen());

    }


}
