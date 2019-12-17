package pages;

import framework.BasePage;
import framework.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage extends BasePage {
    public void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static void selectItemByIndex(WebElement webElement, int index) {
        Select selectValue = new Select(webElement);
        selectValue.selectByIndex(index);
    }

    public static void selectItemByValue(WebElement webElement, String value) {
        Select selectValue = new Select(webElement);
        selectValue.selectByValue(value);
    }

    public static void waitForElementVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(BrowserManager.getBrowser(), 10);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(BrowserManager.getBrowser(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementInvisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(BrowserManager.getBrowser(), 20);
        wait.until((ExpectedConditions.invisibilityOf(webElement)));
    }
}
