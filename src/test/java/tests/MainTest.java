package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Log4j2

public class MainTest extends BaseTest{
 String enteredText = "Привет мой друг ";
 String homeTextNotebook = "Привет мой друг ";
 String searchRecordsDate = "Fri, 1 Sep. 2023 10:54 PM";

    @Test
    public void createEntry(){
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
    public void selectAndDeleteCheckBox(){
        loginPage.open()
                .enterLoginAndPassword(email,password)
                .userClickButton();
        mainPage.selectCheckBox(searchRecordsDate);
        contextMenuPage.clickButtonDelete();
        contextMenuPage.getText();
        String alertText = contextMenuPage.getText();
        assertEquals(alertText,"Do you really want to delete the selected entries?","Текст сообщения не верный");
        contextMenuPage.alertAccept();




    }

}
