package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LanguagTest extends BaseTest{
    String textFr = "Langue temporairement changée. Afin de changer de façon permanente la langue de votre compte, veuillez accéder au point de menu \"Paramètres\" après le login.";
    String textDe = "Sprache temporär geändert. Um deine Profil-Sprache dauerhaft zu ändern, besuche den Menüpunkt \"Einstellungen\" nach dem Login.";
    String textPt = "Idioma alterado temporariamente. Para modificar a linguagem de seu perfil permanentemente, vá para o item do menu \"Configurações\" após estar logado.";
    String textEn = "Language changed temporarily. To change your profile language permanently, go to the menu item \"Settings\" after login.";


    @Test(description = "Page language de selection")
    public void changeLanguageDe () {
        loginPage.open();
                languagePage.languageSelection("DE");

        assertEquals(languagePage.languageMessage(),textDe,"Text does not match");
    }

    @Test(description = "Page language fr selection")
    public void changeLanguageFr () {
        loginPage.open();
                languagePage.languageSelection("FR");

        assertEquals(languagePage.languageMessage(),textFr,"Text does not match");
    }
    @Test(description = "Page language pt selection")
    public void changeLanguagePT () {
        loginPage.open();
        languagePage.languageSelection("PT");

        assertEquals(languagePage.languageMessage(),textPt,"Text does not match");
    }
    @Test(description = "Page language en selection")
    public void changeLanguageEn () {
        loginPage.open();
        languagePage.languageSelection("PT");
        languagePage.languageSelection("EN");

        assertEquals(languagePage.languageMessage(),textEn,"Text does not match");

}}
