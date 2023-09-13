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
    public void clickButtonRegistration() {
        homePage.open()
                .clickButtonSingUP();

        assertEquals(homePage.getTextMessageRegistration(), "Registration");
    }

    @Test(description = "Click header menu about de")
    public void clickHeaderMenuAboutDe() {
        homePage.open()
                .choiceLanguageClick("DE")
                .clickHeaderMenu("Über monkkee");

        assertEquals(homePage.getTextHomeRubricAbout(), "Online Tagebuch schreiben – privat und kostenlos","Message does not match");

    }
    @Test(description = "Click header menu about en")
    public void clickHeaderMenuAboutEn() {
        homePage.open()
                .choiceLanguageClick("FR")
                .choiceLanguageClick("EN")
                .clickHeaderMenu("About");

        assertEquals(homePage.getTextHomeRubricAbout(), "Keep a private and free online diary","Message does not match");

    }
    @Test(description = "Click header menu about fr")
    public void clickHeaderMenuAboutFr() {
        homePage.open()
                .choiceLanguageClick("FR")
                .clickHeaderMenu("A propos");

        assertEquals(homePage.getTextHomeRubricAbout(), "Tenir un journal intime en ligne – privé et gratuit","Message does not match");
    }
    @Test(description = "Click header menu about pt")
    public void clickHeaderMenuAboutPt() {
        homePage.open()
                .choiceLanguageClick("PT")
                .clickHeaderMenu("Sobre");

        assertEquals(homePage.getTextHomeRubricAbout(), "Tenha um diário online privado e grátis", "Message does not match");
    }

        @Test(description = "Click header menu features de")
        public void clickHeaderMenuFeaturesDe() {
            homePage.open()
                    .choiceLanguageClick("DE")
                    .clickHeaderMenu("Funktionen");

            assertEquals(homePage.getTextHomeRubricFeatures(), "Ohne Schnickschnack - die Funktionen von monkkee","Message does not match");

        }
        @Test(description = "Click header menu features en")
        public void clickHeaderMenuFeaturesEn() {
            homePage.open()
                    .choiceLanguageClick("FR")
                    .choiceLanguageClick("EN")
                    .clickHeaderMenu("Features");

            assertEquals(homePage.getTextHomeRubricFeatures(), "monkkee’s features - no bells and whistles, plain functionality","Message does not match");

        }
        @Test(description = "Click header menu fea" +
                "" +
                "tures fr")
        public void clickHeaderMenuFeaturesFr() {
            homePage.open()
                    .choiceLanguageClick("FR")
                    .clickHeaderMenu("Fonctionnalités");

            assertEquals(homePage.getTextHomeRubricFeatures(), "monkkee - tout simplement fonctionnel","Message does not match");
        }
        @Test(description = "Click header menu features pt")
        public void clickHeaderMenuFeaturesPt() {
            homePage.open()
                    .choiceLanguageClick("PT")
                    .clickHeaderMenu("Recursos");

            assertEquals(homePage.getTextHomeRubricFeatures(), "Características do monkkee - Sem recursos adicionais, funcionalidade simples", "Message does not match");


        }

            @Test(description = "Click header menu security de")
            public void clickHeaderMenuSecurityDe() {
                homePage.open()
                        .choiceLanguageClick("DE")
                        .clickHeaderMenu("Sicherheit");

                assertEquals(homePage.getTextHomeRubricSecurity(), "Sicherheit durch Ende-zu-Ende-Verschlüsselung","Message does not match");
            }

    @Test(description = "Click header menu security en")
    public void clickHeaderMenuSecurityEn() {
        homePage.open().
                choiceLanguageClick("FR")
                .choiceLanguageClick("EN")
                .clickHeaderMenu("Security");

        assertEquals(homePage.getTextHomeRubricSecurity(), "Secure end-to-end encryption","Message does not match");

    }
    @Test(description = "Click header menu security fr")
    public void clickHeaderMenuSecurityFr() {
        homePage.open()
                .choiceLanguageClick("FR")
                .clickHeaderMenu("Sécurité");

        assertEquals(homePage.getTextHomeRubricSecurity(), "Chiffrement de bout en bout pour une sécurité maximale","Message does not match");
    }
    @Test(description = "Click header menu security pt")
    public void clickHeaderMenuSecurityPt() {
        homePage.open()
                .choiceLanguageClick("PT")
                .clickHeaderMenu("Segurança");

        assertEquals(homePage.getTextHomeRubricSecurity(), "Criptografia segura de ponta a ponta", "Message does not match");
    }

    @Test(description = "Click header menu donate de")
    public void clickHeaderMenuDonateDe() {
        homePage.open()
                .choiceLanguageClick("DE")
                .clickHeaderMenu("Spenden");

        assertEquals(homePage.getTextHomeRubricDonate(), "Unser Geschäftsmodell = eure Spenden","Message does not match");
    }

    @Test(description = "Click header menu donate en")
    public void clickHeaderMenuDonateEn() {
        homePage.open()
                .choiceLanguageClick("FR")
                .choiceLanguageClick("EN")
                .clickHeaderMenu("Donate");

        assertEquals(homePage.getTextHomeRubricDonate(), "Our business model = your donations","Message does not match");

    }
    @Test(description = "Click header menu donate fr")
    public void clickHeaderMenuDonateFr() {
        homePage.open()
                .choiceLanguageClick("FR")
                .clickHeaderMenu("Faire un don");

        assertEquals(homePage.getTextHomeRubricDonate(), "Notre modèle commercial = vos dons","Message does not match");
    }
    @Test(description = "Click header menu donate pt")
    public void clickHeaderMenuDonatePt() {
        homePage.open()
                .choiceLanguageClick("PT")
                .clickHeaderMenu("Faça uma doação");

        assertEquals(homePage.getTextHomeRubricDonate(), "Nosso modelo de negócios = suas doações", "Message does not match");

    }}


