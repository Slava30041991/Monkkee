package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Log4j2

public class MainTest extends BaseTest{
 String enteredText = "Привет мой друг";
 String homeTextNotebook = "Привет мой друг";
 String searchRecordsDate = "Wed, 30 Aug. 2023 07:18 PM";

    @Test
    public void CreateEntry(){
        loginPage.open()
                 .enterLoginAndPassword(email, password)
                 .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                 .clickButtonSave();
        mainPage.clickButtonHome();
        mainPage.textMessageRecords(homeTextNotebook);

        assertEquals(enteredText,homeTextNotebook,"Текс не совподает");
    }
    @Test
    public void SelectAndDeleteCheckBox(){
        loginPage.open()
                .enterLoginAndPassword(email,password)
                .userClickButton();
        mainPage.selectCheckBox(searchRecordsDate);
        mainPage.clickButtonDelete();








    }

}
