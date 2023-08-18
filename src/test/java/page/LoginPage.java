    package page;
    import io.qameta.allure.Step;
    import lombok.extern.log4j.Log4j2;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import static page.HomePage.BUTTON_LOGIN_HOME_PAGE;

    @Log4j2
    public class LoginPage extends BasePage{

    public static final By INPUT_USER_FIELD = By.id("login");
    public static final By INPUT_PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BUTTON_LOGIN_PAGE = By.xpath("//button//div");
    public static By ERROR_MANDATORY_FIELD_MESSAGE = By.xpath("//div[normalize-space(text()) = 'Mandatory field']");
    public static By ERROR_LOGIN = By.xpath("//div[normalize-space(text()) = 'Login failed']");

        @Step("The user opens login page")
        public LoginPage open(){
            driver.get(BASE_URL);
            log.info("Opens login page");
            driver.findElement(BUTTON_LOGIN_HOME_PAGE).click();
            log.info("Click button login");
            return this;
        }
        @Step ("The user selects and changes the language")
        public LoginPage languageSelection(String language){
            driver.get(BASE_URL + "/app/#/");
            log.info("Go to the basic authorization page");
            driver.findElement(By.xpath(String.format(languageLocator, language))).click();
            log.info("Select page language" + language);
            return this;
        }
        @Step("Language change message")
        public boolean languageMessage(){
            driver.findElement(PAGE_LANGUAGE).getText();
            log.info("language change message");
            return true;
        }
        @Step("First error message")
        public String errorMessageOne(){
            log.info("First error message");
            return driver.findElement(ERROR_MANDATORY_FIELD_MESSAGE).getText();
        }
        @Step("Second error message")
        public String errorMessageTwo() {
            log.info("Second error message");
            return driver.findElement(ERROR_LOGIN).getText();
        }

        @Step("User enters username and password")
        public LoginPage userEnterLoginAndPassword (String user, String password) {
            driver.findElement(INPUT_USER_FIELD).sendKeys(user);
            log.info("Enters username");
            driver.findElement(INPUT_PASSWORD_FIELD).sendKeys(password);
            log.info("Enters password");
            return this;
        }
        @Step("The user clicks the login button")
        public LoginPage userClickButton(){
            driver.findElement(LOGIN_BUTTON_LOGIN_PAGE).click();
            log.info("Click button login");
            return this;
        }
        public LoginPage(WebDriver driver) {
                super(driver);
            }

            @Override
            public boolean isPageOpen () {
                return isExist(PAGE_LOCATOR);
            }
        }
