package tests;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
@Log4j2
public class LoginTest extends BaseTest{
    String textDe = "Sprache temporär geändert. Um deine Profil-Sprache dauerhaft zu ändern, besuche den Menüpunkt \"Einstellungen\" nach dem Login.";
    String textFr = "Langue temporairement changée. Afin de changer de façon permanente la langue de votre compte, veuillez accéder au point de menu \"Paramètres\" après le login.";
    String textPT = "Idioma alterado temporariamente. Para modificar a linguagem de seu perfil permanentemente, vá para o item do menu \"Configurações\" após estar logado.";

    @Test(description = "Page language DE selection")
    public void changeLanguageDe () {
        loginPage.open()
                 .languageSelection("DE");

        assertEquals(loginPage.languageMessageDe(),textDe);
    }
    @Test(description = "Page language FR selection")
    public void changeLanguageFr () {
        loginPage.open()
                 .languageSelection("FR");

        assertEquals(loginPage.languageMessageFr(),textFr);
    }
    @Test(description = "Page language PT selection")
    public void changeLanguagePt () {
        loginPage.open()
                 .languageSelection("PT");

        assertEquals(loginPage.languageMessagePt(),textPT);
    }
    @Test(description = "User login and password  valid data")
    public void inputValidDateUserAndPassword () {
        loginPage.open()
                 .enterLoginAndPassword(email, password)
                 .userClickButton();

        Assert.assertTrue(mainPage.isPageOpen());
    }
    @Test(description = "User left the fields blank")
    public void noValideDateUserLeftFieldsBlank (){
        loginPage.open()
                 .enterLoginAndPassword("","")
                 .userClickButton();

        assertEquals(loginPage.errorMessageField(), "Mandatory field");

    }
    @Test(description = "User left field name empty")
    public void noValideDateUserEnteredOnlyPassword () {
        loginPage.open()
                 .enterLoginAndPassword("", "Valy27061")
                 .userClickButton();

        assertEquals(loginPage.errorMessageField(), "Mandatory field");
    }
    @Test(description = "User left field password empty")
    public void noValideDateUserEnteredOnlyName () {
        loginPage.open()
                 .enterLoginAndPassword("balahenka30041991@gmail.com", "")
                 .userClickButton();

        assertEquals(loginPage.errorMessageField(), "Mandatory field");
    }
    @Test(description = "User made a mistake in the name field")
    public void noValideDateUserEnteredNameWithError (){
        loginPage.open()
                 .enterLoginAndPassword("balahenka30041991@gmail.",password)
                 .userClickButton();

        assertEquals(loginPage.errorMessageLogin(), "Login failed");
    }

    @Test(description = "User made a mistake in the password field")
    public void noValideDateUserEnteredPasswordWithError(){
        loginPage.open()
                 .enterLoginAndPassword(email,"Valy2706331")
                 .userClickButton();

        assertEquals(loginPage.errorMessageLogin(), "Login failed");
        }
}