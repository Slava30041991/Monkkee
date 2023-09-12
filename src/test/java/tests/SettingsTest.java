package tests;

import org.testng.annotations.Test;

import java.util.Collections;

import static org.testng.Assert.*;

public class SettingsTest extends BaseTest {
    String textLanguage = "Seu idioma foi alterado com sucesso";
    String textTime = "Suas configurações foram salvas com sucesso";

    @Test(description = "Language selection settings")
    public void languageSelectionSettings(){
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton();
        settingsPage.selectSettingLanguage();
        settingsPage.selectLanguage();
        settingsPage.clickButtonOkLanguage();

        assertEquals(settingsPage.textMessageLanguage("Seu idioma foi alterado com sucesso"),textLanguage,"Text does not match");

    }
    @Test(description = "User logout")
    public void logout () {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.logout();

        assertTrue(homePage.isPageOpen());
    }

        @Test(description = "Adding a login alias instead of email")
                public void addingAlies(){
            loginPage.open()
                    .enterLoginAndPassword(email, password)
                    .userClickButton();
            settingsPage.clickSettingButton();
            settingsPage.selectSettingAlies();
            settingsPage.nicknameClickCheckBox();
            settingsPage.clickNickname();
            settingsPage.selectNickName("bbbbbb");
            settingsPage.clickButtonOkTime();

            assertEquals(settingsPage.getMessageTextTime("Suas configurações foram salvas com sucesso"),textTime,"Text does not match");

        }

        @Test(description = "Change page time")
                public void changePageTime(){
            loginPage.open()
                    .enterLoginAndPassword(email, password)
                    .userClickButton();
            settingsPage.clickSettingButton();
            settingsPage.selectSettingTimeout();
            settingsPage.clickButtonTime();
            settingsPage.listTimeLimit();
            settingsPage.clickButtonOkTime();

            assertEquals(settingsPage.getMessageTextTime("Suas configurações foram salvas com sucesso"),textTime,"Text does not match");

        }

}

