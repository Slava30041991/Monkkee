    package page;
    import io.qameta.allure.Step;
    import lombok.extern.log4j.Log4j2;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    @Log4j2
    public class LoginPage extends BasePage{
        String languageLocator = "//span[contains (@class, 'active')]/..//a[text() = '%s']";
    public static final By PAGE_LANGUAGE = By.xpath("//div[contains(@class ,'uccess')]");
    public static final By INPUT_USER_FIELD = By.id("login");
    public static final By INPUT_PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BUTTON = By.xpath("//button//div");
    public static By BUTTON_LOGIN = By.xpath(" //a[text() = 'Login']");
    public static By ERROR_MESSAGE_ONE = By.xpath("//div[normalize-space(text()) = 'Mandatory field']");
    public static By ERROR_MESSAGE_TWO = By.xpath("//div[normalize-space(text()) = 'Login failed']");

        @Step ("The user selects and changes the language")
        public LoginPage languageSelection(String language){
            driver.get(BASE_URL_LOGIN_PAGE);
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
            return driver.findElement(ERROR_MESSAGE_ONE).getText();
        }
        @Step("Second error message")
        public String errorMessageTwo() {
            log.info("Second error message");
            return driver.findElement(ERROR_MESSAGE_TWO).getText();
        }
        @Step("The user opens login page")
        public LoginPage openLoginPage(){
            driver.get(BASE_URL);
            log.info("Opens login page");
            driver.findElement(BUTTON_LOGIN).click();
            log.info("Click button login");
            return this;
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
            driver.findElement(LOGIN_BUTTON).click();
            log.info("Click button login");
            return this;
        }
        public LoginPage(WebDriver driver) {
                super(driver);
            }

            @Override
            public boolean isPageOpen () {
                return isExist(MAIN_PAGE);
            }
        }
