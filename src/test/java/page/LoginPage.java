    package page;
    import io.qameta.allure.Step;
    import lombok.extern.log4j.Log4j2;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    @Log4j2
    public class LoginPage extends BasePage{
    public static final By INPUT_USER_FIELD = By.id("login");
    public static final By INPUT_PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BUTTON_LOGIN_PAGE = By.xpath("//button//div");
    public static By ERROR_MANDATORY_FIELD_MESSAGE = By.xpath("//div[normalize-space(text()) = 'Mandatory field']");
    public static By ERROR_LOGIN = By.xpath("//div[normalize-space(text()) = 'Login failed']");


        @Step("The user opens login page")
        public LoginPage open(){
            driver.get(BASE_URL + "/app/#/");
            log.info("Opens login page");
            return this;
        }
        @Step ("The user selects and changes the language")
        public LoginPage languageSelection(String language){
            driver.findElement(By.xpath(String.format(languageLocator, language))).click();
            log.info("Select page language" + language);
            return this;
        }
        @Step("Language change message")
        public String languageMessageDe(){
            log.info("language change message");
            return driver.findElement(DE_LANGUAGE_TEXT).getText();
        }

        @Step("Language change message")
        public String languageMessageFr(){
            log.info("language change message");
            return driver.findElement(FR_LANGUAGE_TEXT).getText();
        }
        @Step("Language change message")
        public String languageMessagePt(){
            log.info("language change message");
            return driver.findElement(PT_LANGUAGE_TEXT).getText();
        }

        @Step("First error message")
        public String errorMessageField(){
            log.info("First error message");
            return driver.findElement(ERROR_MANDATORY_FIELD_MESSAGE).getText();
        }
        @Step("Second error message")
        public String errorMessageLogin() {
            log.info("Second error message");
            return driver.findElement(ERROR_LOGIN).getText();
        }

        @Step("User enters username and password")
        public LoginPage enterLoginAndPassword (String user, String password) {
            driver.findElement(INPUT_USER_FIELD).sendKeys(user);
            log.info("Enters username");
            driver.findElement(INPUT_PASSWORD_FIELD).sendKeys(password);
            log.info("Enters password");
            return this;
        }
        @Step("The user clicks the login button")
        public void userClickButton(){
            driver.findElement(LOGIN_BUTTON_LOGIN_PAGE).click();
            log.info("Click button login");
            this.isPageOpen();
        }
        public LoginPage(WebDriver driver) {
                super(driver);
            }

            @Override
            public boolean isPageOpen () {
                return isExist(PAGE_LOCATOR);
            }
        }
