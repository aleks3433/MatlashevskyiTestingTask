package framework;

import org.openqa.selenium.support.PageFactory;

import static framework.BrowserManager.getBrowser;

public class BasePage {
    public static <T> T initPage(Class<T> pageClass) {
        return PageFactory.initElements(getBrowser(), pageClass);
    }
}
