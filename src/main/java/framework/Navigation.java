package framework;

import pages.RegisterPage;

import static framework.BasePage.initPage;

public class Navigation {
    public static RegisterPage openRegisterPage() {
        BrowserManager.getBrowser().get(BrowserManager.getSettings().getUrl());
        return initPage(RegisterPage.class);
    }
}
