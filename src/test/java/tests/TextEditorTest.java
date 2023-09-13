package tests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
public class TextEditorTest extends BaseTest {

    @Test(description = "Loading File ")
    public void loadingFileFormat() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.buttonBlockEmage()
                .selectFileLoading()
                .clickButtonSave();

        assertTrue(homePage.isPageOpen());

}}
