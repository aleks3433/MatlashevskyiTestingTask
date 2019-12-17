package framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.RegisterPage;

import static framework.BasePage.initPage;

public class BaseTest {
    public RegisterPage registerPage;

    @BeforeTest(alwaysRun = true)
    public static void openBrowser() {
        BrowserManager.openBrowser();
    }

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        Navigation.openRegisterPage();
        registerPage = initPage(RegisterPage.class);
    }

    @AfterTest(alwaysRun = true)
    public static void afterSuite() {
        BrowserManager.closeBrowser();
    }
}
