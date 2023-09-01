package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Log4j2
public class HomeTest extends BaseTest {
    @Test(description = "Open website")
    public void userOpensWebsite() {
        homePage.open()
                .isPageOpen();

        assertTrue(homePage.isPageOpen());
    }

    @Test(description = "Click button registration")
    public void userClickButtonRegistration() {
        homePage.open()
                .buttonClickSingUP();

        assertEquals(homePage.getTextMessageRegistration(), "Registration");
    }

    @Test(description = "Click header menu about")
    public void userClickHeaderMenuAbout() {
        homePage.open()
                .choiceLanguageClick("FR");
        homePage.clickHeaderMenu("A propos");

        assertEquals(homePage.getTextHomeRubricAbout(), "Tenir un journal intime en ligne – privé et gratuit","Message does not match");

    }
    @Test(description = "Click header menu donate")
    public void userClickHeaderMenuDonate() {
        homePage.open().choiceLanguageClick("DE");
        homePage.clickHeaderMenu("Spenden");

        assertEquals(homePage.getTextHomeRubricDonate(), "Unser Geschäftsmodell = eure Spenden","Message does not match");

    }
    @Test(description = "Click header menu features")
    public void userClickHeaderMenuFeatures() {
        homePage.open().choiceLanguageClick("DE");
        homePage.clickHeaderMenu("Funktionen");

        assertEquals(homePage.getTextHomeRubricFeatures(), "Ohne Schnickschnack - die Funktionen von monkkee","Message does not match");
    }
    @Test(description = "Click header menu security")
    public void userClickHeaderMenuFeaturesSecurity() {
        homePage.open().choiceLanguageClick("DE");
        homePage.clickHeaderMenu("Sicherheit");

        assertEquals(homePage.getTextHomeRubricSecurity(), "Sicherheit durch Ende-zu-Ende-Verschlüsselung","Message does not match");

    }}


