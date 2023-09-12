package tests;

import org.testng.annotations.Test;
public class TextEditorTest extends BaseTest{

    @Test(description = "Loading File ")
    public void loadingFileFormat() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.buttonBlockEmage()
                .selectFileLoading()
                .clickButtonSave();


}}
