package tests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class SettingsTest extends BaseTest {
    String textLanguage = "Seu idioma foi alterado com sucesso";
    String textTimeAndAlies = "Your settings have been saved successfully";

    @Test(description = "Language selection settings")
    public void languageSelectionSettings() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton()
                    .selectSettingLanguage();
        settingsPage.selectLanguage()
                    .clickButtonOkLanguage();

        assertEquals(settingsPage.textMessageLanguage("Seu idioma foi alterado com sucesso"),textLanguage,"Text does not match");

    }

    @Test(description = "logout")
    public void logout () {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.logout();

        assertTrue(homePage.isPageOpen());
    }

        @Test(description = "Adding a login alias instead of email")
                public void addingAlies()  {
            loginPage.open()
                        .enterLoginAndPassword(email, password)
                        .userClickButton();
           settingsPage.clickSettingButton()
                        .selectSettingAlies()
                        .nicknameClickCheckBox();
           settingsPage.selectNickName("Hotel");
                        settingsPage.clickButtonOkTime();

        assertEquals(settingsPage.getMessageTextAliasAndTime("Your settings have been saved successfully"),textTimeAndAlies,"Text does not match");

            settingsPage.deleteNickName();
            settingsPage.nicknameClickCheckBox();
            settingsPage.clickButtonOkTime();



        }

        @Test(description = "Change page time")
                public void changePageTime(){
            loginPage.open()
                        .enterLoginAndPassword(email, password)
                        .userClickButton();
            settingsPage.clickSettingButton()
                        .selectSettingTimeout();
           settingsPage.clickButtonTime()
                        .listTimeLimit()
                        .clickButtonOkTime();

            assertEquals(settingsPage.getMessageTextAliasAndTime("Your settings have been saved successfully"),textTimeAndAlies,"Text does not match");

        }

}

