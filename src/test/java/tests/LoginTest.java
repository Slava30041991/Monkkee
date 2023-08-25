package tests;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
@Log4j2
public class LoginTest extends BaseTest{

                @Test(description = "Page language selection")
                public void userChangesLanguage () {
                    loginPage.open();
                    loginPage.languageSelection("DE");

                    Assert.assertTrue(loginPage.languageMessage());
                }
                @Test(description = "User login and password  valid data")
                public void inputValidDateUserAndPassword () {
                    loginPage.open();
                    loginPage.userEnterLoginAndPassword("balahenka30041991@gmail.com", "Valy270619");
                    loginPage.userClickButton();
                    Assert.assertTrue(mainPage.isPageOpen());
                }
                 @Test(description = "User left the fields blank")
                 public void noValideDateUserLeftFieldsBlank (){
                    loginPage.open();
                    loginPage.userEnterLoginAndPassword("","");
                    loginPage.userClickButton();

                     assertEquals(loginPage.errorMessageOne(), "Mandatory field");

                 }
                @Test(description = "User left field name empty")
                public void noValideDateUserEnteredOnlyPassword () {
                    loginPage.open();
                    loginPage.userEnterLoginAndPassword("", "Valy27061");
                    loginPage.userClickButton();

                    assertEquals(loginPage.errorMessageOne(), "Mandatory field");
                }
        @Test(description = "User left field password empty") //
        public void noValideDateUserEnteredOnlyName () {
            loginPage.open();
            loginPage.userEnterLoginAndPassword("balahenka30041991@gmail.com", "");
            loginPage.userClickButton();

            assertEquals(loginPage.errorMessageOne(), "Mandatory field");
        }

                @Test(description = "User made a mistake in the name field")
                public void noValideDateUserEnteredNameWithError (){
                    loginPage.open();
                    loginPage.userEnterLoginAndPassword(email,password);
                    loginPage.userClickButton();

                    assertEquals(loginPage.errorMessageTwo(), "Login failed");
                }

        @Test(description = "User made a mistake in the password field")
        public void noValideDateUserEnteredPasswordWithError(){
            loginPage.open();
            loginPage.userEnterLoginAndPassword("balahenka30041991@gmail.com","Valy27061");
            loginPage.userClickButton();

            assertEquals(loginPage.errorMessageTwo(), "Login failed");
        }

}