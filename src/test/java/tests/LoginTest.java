package tests;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
@Log4j2
public class LoginTest extends BaseTest{

    @Test(description = "User login and password  valid data")
    public void inputValidDateUserAndPassword () {
        loginPage.open()
                 .enterLoginAndPassword(email, password)
                 .userClickButton();

        Assert.assertTrue(mainPage.isPageOpen(),"Text does not match");
    }
    @Test(description = "User left the fields blank")
    public void noValideDateUserLeftFieldsBlank (){
        loginPage.open()
                 .enterLoginAndPassword("","")
                 .userClickButton();

        assertEquals(loginPage.errorMessageField(), "Mandatory field","Text does not match");

    }
    @Test(description = "User left field name empty")
    public void noValideDateUserEnteredOnlyPassword () {
        loginPage.open()
                 .enterLoginAndPassword("", "Valy27061")
                 .userClickButton();

        assertEquals(loginPage.errorMessageField(), "Mandatory field","Text does not match");
    }
    @Test(description = "User left field password empty")
    public void noValideDateUserEnteredOnlyName () {
        loginPage.open()
                 .enterLoginAndPassword("balahenka30041991@gmail.com", "")
                 .userClickButton();

        assertEquals(loginPage.errorMessageField(), "Mandatory field","Text does not match");
    }
    @Test(description = "User made a mistake in the name field")
    public void noValideDateUserEnteredNameWithError (){
        loginPage.open()
                 .enterLoginAndPassword("balahenka30041991@gmail.",password)
                 .userClickButton();

        assertEquals(loginPage.errorMessageLogin(), "Login failed","Text does not match");
    }

    @Test(description = "User made a mistake in the password field")
    public void noValideDateUserEnteredPasswordWithError(){
        loginPage.open()
                 .enterLoginAndPassword(email,"Valy2706331")
                 .userClickButton();

        assertEquals(loginPage.errorMessageLogin(), "Login failed","Text does not match");
        }
}