package framework;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static Settings settings = new Settings();

    public static WebDriver getBrowser() {
        return driver.get();
    }

    public static Settings getSettings() {
        return settings;
    }

    public static void openBrowser() {
        driver.set(settings.getDriver());
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public static void closeBrowser() {
        driver.get().quit();
    }
}
