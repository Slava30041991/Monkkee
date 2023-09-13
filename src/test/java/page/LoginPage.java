    package page;
    import io.qameta.allure.Step;
    import lombok.extern.log4j.Log4j2;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;

    import java.util.List;

    @Log4j2
    public class LoginPage extends BasePage{
    public static final By INPUT_USER_FIELD = By.id("login");
    public static final By INPUT_PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BUTTON_LOGIN_PAGE = By.xpath("//button//div");
    public static By ERROR_MANDATORY_FIELD_MESSAGE = By.xpath("//div[normalize-space(text()) = 'Mandatory field']");
    public static By ERROR_LOGIN = By.xpath("//div[normalize-space(text()) = 'Login failed']");
    public static By LOGIN_LANGUAGE = By.xpath("//span[@class = 'language-switcher' ]//a");



        @Step("Opens login page")
        public LoginPage open(){
            driver.get(BASE_URL + "/app/#/");
            log.info("Opens login page "+ BASE_URL);
            return this;
        }

        @Step("Login language")
        public LoginPage languagePageLogin () {
            List<WebElement> language = driver.findElements(LOGIN_LANGUAGE);
            language.get(1).click();
            return this;
        }

        @Step("First error message")
        public String errorMessageField(){
            return driver.findElement(ERROR_MANDATORY_FIELD_MESSAGE).getText();
        }

        @Step("Second error message")
        public String errorMessageLogin() {
            log.info("Second error message");
            return driver.findElement(ERROR_LOGIN).getText();
        }

        @Step("Enters username and password")
        public LoginPage enterLoginAndPassword (String user, String password) {
            driver.findElement(INPUT_USER_FIELD).sendKeys(user);
            log.info("Enters username " + user);
            driver.findElement(INPUT_PASSWORD_FIELD).sendKeys(password);
            log.info("Enters password " + password);
            return this;
        }
        @Step("Clicks button login")
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
