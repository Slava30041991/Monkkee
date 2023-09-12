package tests;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Log4j2

public class MainTest extends BaseTest {
    String enteredText = "How to handle Alerts in chrome 64 using selenium Java";
    String homeTextNotebook = "How to handle Alerts in chrome 64 using selenium Java";
    String monthYear = "September 2023";
    String day = "12";
    String messageCalendar = "12 Sep. 2023";
    String textTags = "How to handle Alerts in chrome 64 using selenium Java";

    @Test(description = "User create entry")
    public void createEntry()  {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.clickButtonHome()
                .textMessageRecords(homeTextNotebook);

        assertEquals(enteredText, homeTextNotebook, "Текс не совподает");

        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete()
                .getText();
        contextMenuPage.alertAccept();

    }

    @Test (description = "User check and remove checkbox")
    public void selectAndDeleteCheckBox() {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.clickButtonHome();
        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete();
        contextMenuPage.getText();

        String alertText = contextMenuPage.getText();
        assertEquals(alertText, "Do you really want to delete the selected entries?", "Текст сообщения не верный");
        contextMenuPage.alertAccept();
    }

    @Test(description = "User searches for text by text")
    public void searchTextByText()  {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.clickButtonHome()
                .searchInput(enteredText)
                .messageSearch();

        assertEquals(mainPage.messageSearch(), enteredText, "Text does not match");

        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete()
                        .getText();
        contextMenuPage.alertAccept();



    }

    @Test(description = "User searches text for calendar")
    public void searchTextByDate() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton(); mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.clickButtonHome();
        mainPage.selectDate(monthYear,day);

       assertEquals(mainPage.getMessageCalendar(),messageCalendar,"Text does not match");

        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete()
                .getText();
        contextMenuPage.alertAccept();
    }

    @Test(description = "Adding a tag to a post")
    public void createTagInPost() {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.createTagPost(enteredText);
        mainPage.clickButtonHome();

       assertEquals(mainPage.getMessageTags(),enteredText,"Text does not match");

        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete()
                .getText();
        contextMenuPage.alertAccept();

    }

    @Test(description = "Delete tag by name")
    public void deleteTag(){
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.createTagPost(enteredText);
        mainPage.clickButtonHome();
        mainPage.clickButtonTextTag();
        mainPage.selectingTagName(textTags);
        contextMenuPage.clickButtonTeg();
        contextMenuPage.getText();

        String alertText = contextMenuPage.getText();
        assertEquals(alertText, "Do you really want to delete the tag? All entries related to the tag remain unchanged.", "Текст сообщения не верный");
        contextMenuPage.alertAccept();


    }
}
