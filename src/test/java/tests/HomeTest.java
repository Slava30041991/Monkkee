package tests;

import org.testng.annotations.Test;
import page.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {
    @Test(description = "User open website")
    public void userOpensWebsite() {
        homePage.open();
        homePage.isPageOpen();

        assertTrue(homePage.isPageOpen());

    }

    @Test(description = "User click button")
    public void userClickButtonRegistration() {
        homePage.open();
        homePage.buttonTestSingUP();

        assertEquals(homePage.buttonTestSingUP(), "Registration");
    }

    @Test
    public void userClickHeaderMenu() {
        homePage.open();
        homePage.choiceLanguageClick("DE");
        homePage.clickHeaderMenu("Spenden");
        homePage.textHomeRubric("Online Tagebuch schreiben – privat und kostenlos");

       assertEquals(homePage.textHomeRubric("Online Tagebuch schreiben – privat und kostenlos"),"Online Tagebuch schreiben – privat und kostenlos\n" +
               "Den Kopf voller Gedanken, die du irgendwo aufschreiben willst, wo sie keiner findet? Geniale Einfälle festhalten, damit sie nicht verloren gehen? Das Online-Tagebuch monkkee bietet dir einen Ort für deine ganz persönlichen Themen.\n" +
               "\n");




    }


}