package tests;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Enter login and password  valid data")
    public void inputValidDateUserAndPassword () {
        loginPage.open()
                 .enterLoginAndPassword(email, password)
                 .userClickButton();

        Assert.assertTrue(mainPage.isPageOpen(),"Text does not match");
    }

    @Test(description = "Left the fields blank")
    public void noValidDateUserLeftFieldsBlank (){
        loginPage.open()
                 .enterLoginAndPassword("","")
                 .userClickButton();

        assertEquals(loginPage.errorMessageField(), "Mandatory field","Text does not match");

    }
    @Test(description = "Left field name empty")
    public void noValidDateUserEnteredOnlyPassword () {
        loginPage.open()
                 .enterLoginAndPassword("", "Valy27061")
                 .userClickButton();

        assertEquals(loginPage.errorMessageField(), "Mandatory field","Text does not match");

    }
    @Test(description = "Left field password empty")
    public void noValidDateUserEnteredOnlyName () {
        loginPage.open()
                 .enterLoginAndPassword("balahenka30041991@gmail.com", "")
                 .userClickButton();

        assertEquals(loginPage.errorMessageField(), "Mandatory field","Text does not match");

    }
    @Test(description = "Made a mistake in the name field")
    public void noValidDateUserEnteredNameWithError (){
        loginPage.open()
                 .enterLoginAndPassword("balahenka30041991@gmail.",password)
                 .userClickButton();

        assertEquals(loginPage.errorMessageLogin(), "Login failed","Text does not match");
    }

    @Test(description = "Made a mistake in the password field")
    public void noValidDateUserEnteredPasswordWithError(){
        loginPage.open()
                 .enterLoginAndPassword(email,"Valy2706331")
                 .userClickButton();

        assertEquals(loginPage.errorMessageLogin(), "Login failed","Text does not match");

        }
}