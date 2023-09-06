package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SettingsTest extends BaseTest {
    String textLanguage = "Seu idioma foi alterado com sucesso";

    @Test(description = "Language selection settings")
    public void languageSelectionSettings(){
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton();
        settingsPage.selectSetting();
        settingsPage.selectLanguage();
        settingsPage.clickButtonOkLanguage();

        assertEquals(settingsPage.textMessageLanguage("Seu idioma foi alterado com sucesso"),textLanguage,"Text does not match");

    }
    @Test(description = "User logout")
    public void logout (){
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.logout();

        assertTrue(homePage.isPageOpen());
}}
