package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class LoginTest extends BaseTest{

        @DataProvider (name = "incorrectLoginTestOne")
        public Object[][] incorrectLoginTestOne() {
            return new Object[][]{
                    {"", "", "Mandatory field"},
                    {"", "Valy270619", "Mandatory field"},
                    {"balahenka30041991@gmail.com", "", "Mandatory field"},
            };
            }
            @DataProvider(name = "incorrectLoginTestTwo")
            public Object[][] incorrectLoginTestTwo() {
                return new Object[][]{
                        {"balahenk30041991@gmail.com", "Valy270619", "Login failed"},
                        {"balahenka30041991@gmail.com", "Valy27061", "Login failed"},
                };
            }
            @Test(description = "Page language selection")
            public void userChangesLanguage () {
                loginPage.languageSelection("DE");
                Assert.assertTrue(loginPage.languageMessage());
            }
            @Test(description = "User login and password  valid data")
            public void inputValidDateUserAndPassword () {
                loginPage.openLoginPage();
                loginPage.userEnterLoginAndPassword("balahenka30041991@gmail.com", "Valy270619");
                loginPage.userClickButton();
                Assert.assertTrue(loginPage.isPageOpen());
            }
            @Test(dataProvider = "incorrectLoginTestOne", description = "Incorrect user input")
            public void noUserAuthorizationValideDateOne (String login, String password, String errorMessage){
                loginPage.openLoginPage();
                loginPage.userEnterLoginAndPassword(login, password);
                loginPage.userClickButton();

               assertEquals(loginPage.errorMessageOne(), "Mandatory field");

            }
            @Test(dataProvider = "incorrectLoginTestTwo", description = "Incorrect user input")
            public void noUserAuthorizationValideDateTwo (String login, String password, String errorMessage){
                loginPage.openLoginPage();
                loginPage.userEnterLoginAndPassword(login, password);
                loginPage.userClickButton();

                assertEquals(loginPage.errorMessageTwo(), "Login failed");
            }
        }