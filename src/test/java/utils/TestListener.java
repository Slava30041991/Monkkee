package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

@Log4j2
public class TestListener implements ITestListener {
    public void onTestStart(org.testng.ITestResult result) {
        log.info(">>>>>>>>>>>>>>>TEST START: "+ result.getName() +">>>>>>>>>>>>>>>");
    }
    public void onTestSuccess(org.testng.ITestResult result) {
        log.info(">>>>>>>>>>>>>>>TEST SUCCESS: " + result.getName() + ">>>>>>>>>>>>>>>" );
    }
    public void onTestFailure(org.testng.ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        ((TakesScreenshot) driver).getScreenshotAs((OutputType.BYTES));
        log.info(">>>>>>>>>>>>>>>TEST FAILURE: " + result.getName() + ">>>>>>>>>>>>>>>" );
    }
    public void onTestSkipped(org.testng.ITestResult result) {
        log.info(">>>>>>>>>>>>>>>TEST SKIPPED: " + result.getName() + ">>>>>>>>>>>>>>>" );
    }
    public void onStart(ITestContext iTestContext) {
        log.info(">>>>>>>>>>>>>>>TEST START: " + iTestContext.getName() + ">>>>>>>>>>>>>>>" );
    }
    public void onFinish(ITestContext iTestContext) {
        log.info(">>>>>>>>>>>>>>>TEST FINISH >>>>>>>>>>>>>>>" );
    }

}