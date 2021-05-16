package Tests;

import DriverManager.DriverFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utility.Utilities.captureScreenshot;
import static org.testng.Reporter.log;

@Epic("Regression Test Suite - Login Details")
public class BarnabasStagingTest extends DriverFactory {

    @Step("Success Message: ")
    public void logToReport(String message) {
        log(message);
    }

    @Test(priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Step("TestCase_001 - verify Login Application")
    public void barnabas_001_verifyLoginApplication() {
        try {
            barnabasStagingPage.loginToApplication();
            Log.info("Login Successfully.");
            logToReport("verify user login successfully to application.");
        } catch (Exception E) {
            captureScreenshot();
            System.out.println("User could not login to application.");
            Log.error("User could not login to application." + E);
            Assert.fail("User Could not login to application." + E);
        }
    }

    @Test(enabled = false,priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Step("TestCase_001 - verify newly created event")
    public void barnabas_002_verifyNewCreatedEvent() {
        try {
            barnabasStagingPage.verifyNewEvent();
            Log.info("New event created Successfully.");
            logToReport("New event created Successfully.");
        } catch (Exception E) {
            captureScreenshot();
            System.out.println("User could not able to create new event.");
            Log.error("User could not able to create new event." + E);
            Assert.fail("User could not able to create new event." + E);
        }
    }

    @Test(enabled = false,priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Step("TestCase_002 - verify Edit event")
    public void barnabas_003_verifyEditEvent() {
        try {
            barnabasStagingPage.editAndVerifyEvents();
            Log.info("Edited event verify Successfully.");
            logToReport("Edited event verify Successfully.");
        } catch (Exception E) {
            captureScreenshot();
            System.out.println("User could not able to verify edit event.");
            Log.error("User could not able to verify edit event." + E);
            Assert.fail("User could not able to verify edit event." + E);
        }
    }

    @Test(enabled = false,priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Step("TestCase_003 - verify duplicate event")
    public void barnabas_004_verifyDuplicateEvent() {
        try {
            barnabasStagingPage.verifyDuplicateEvent();
            Log.info("Duplicate event verify Successfully.");
            logToReport("Duplicate event verify Successfully.");
        } catch (Exception E) {
            captureScreenshot();
            System.out.println("User could not able to verify duplicate event.");
            Log.error("User could not able to verify duplicate event." + E);
            Assert.fail("User could not able to verify duplicate event." + E);
        }
    }

    @Test(enabled = false,priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Step("TestCase_005 - verify sorting of event")
    public void barnabas_004_verifySortingOfEvent() {
        try {
            barnabasStagingPage.verifySortingOfDropdown();
            Log.info("Sorting of event verify Successfully.");
            logToReport("Sorting of event verify Successfully..");
        } catch (Exception E) {
            captureScreenshot();
            System.out.println("User could not able to sorting event.");
            Log.error("User could not able to sorting event." + E);
            Assert.fail("User could not able to sorting event." + E);
        }
    }
}
