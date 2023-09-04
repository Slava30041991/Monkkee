package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Log4j2

public class MainTest extends BaseTest {
    String enteredText = "How to handle Alerts in chrome 64 using selenium Java ";
    String homeTextNotebook = "How to handle Alerts in chrome 64 using selenium Java ";
    String searchRecordsDate = "Sun, 3 Sep. 2023 08:19 PM";
    String monthYear = "September 2023";
    String day = "3";
    String messageCalendar = "Entries on";
    String textTags = "3 сентября";

    @Test(description = "User create entry")
    public void createEntry() {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.clickButtonHome();
        mainPage.textMessageRecords(homeTextNotebook);

        assertEquals(enteredText, homeTextNotebook, "Текс не совподает");
    }

    @Test (description = "User check and remove checkbox")
    public void selectAndDeleteCheckBox() {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.selectCheckBox(searchRecordsDate);
        contextMenuPage.clickButtonDelete();
        contextMenuPage.getText();
        String alertText = contextMenuPage.getText();
        assertEquals(alertText, "Do you really want to delete the selected entries?", "Текст сообщения не верный");
        contextMenuPage.alertAccept();

    }
    @Test(description = "User searches for text by text")
    public void searchTextByText() {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.searchInput(homeTextNotebook);

        assertEquals(homeTextNotebook, enteredText, "Text does not match");
    }

    @Test(description = "User searches text for calendar")
    public void searchTextByDate() {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.selectDate(monthYear,day);

       assertEquals(mainPage.getMessageCalendar("Entries on"),messageCalendar,"Text does not match");

    }
    @Test
    public void createTagInPost(){
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.createTagPost(textTags);

    }
}
