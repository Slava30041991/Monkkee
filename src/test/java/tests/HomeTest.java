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
        homePage.buttonClickSingUP();

        assertEquals(homePage.getTextMessageRegistration(), "Registration");
    }

    @Test
    public void userClickHeaderMenuAbout() {
        homePage.open().choiceLanguageClick("FR");
        homePage.clickHeaderMenu("A propos");

        assertEquals(homePage.getTextHomeRubricAbout(), "Tenir un journal intime en ligne – privé et gratuit");

    }
    @Test
    public void userClickHeaderMenuDonate() {
        homePage.open().choiceLanguageClick("DE");
        homePage.clickHeaderMenu("Spenden");

        assertEquals(homePage.getTextHomeRubricDonate(), "Unser Geschäftsmodell = eure Spenden");

    }
    @Test
    public void userClickHeaderMenuFeatures() {
        homePage.open().choiceLanguageClick("DE");
        homePage.clickHeaderMenu("Funktionen");

        assertEquals(homePage.getTextHomeRubricFeatures(), "Ohne Schnickschnack - die Funktionen von monkkee");
    }
    @Test
    public void userClickHeaderMenuFeaturesSecurity() {
        homePage.open().choiceLanguageClick("DE");
        homePage.clickHeaderMenu("Sicherheit");

        assertEquals(homePage.getTextHomeRubricSecurity(), "Sicherheit durch Ende-zu-Ende-Verschlüsselung");




    }}


