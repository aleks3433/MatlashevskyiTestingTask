package pages;

import framework.Gender;
import framework.PreferenceHairAndEyesColor;
import framework.PreferenceStature;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.BrowserManager.getBrowser;

public class RegisterPage extends BasicPage {
    @FindBy(xpath = "//input[@name='name']")
    WebElement nameEditText;
    @FindBy(name = "email")
    WebElement emailEditText;
    @FindBy(name = "gender")
    WebElement genderSelect;
    @FindBy(name = "age")
    WebElement ageSelect;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement registrationButton;

    public String optionButton = "//div[@id='slide-0%s']//a[@data-test='qa-%s-btn']";

    private static final String LEFT_BUTTON_POSITION = "left";
    private static final String RIGHT_BUTTON_POSITION = "right";

    public void clickPreferenceButton(String slide, String position) {
        By locator = By.xpath(String.format(optionButton, slide, position));
        waitForElementVisible(locator);
        getBrowser().findElement(locator).click();
    }

    public RegisterPage choosePreferences(Gender gender, PreferenceHairAndEyesColor hairColor, PreferenceHairAndEyesColor eyeColor, PreferenceStature stature){
        switch (gender) {
            case FEMALE:
                clickPreferenceButton("1", LEFT_BUTTON_POSITION);
                break;
            case MALE:
                clickPreferenceButton("1", RIGHT_BUTTON_POSITION);
                break;
        }
        switch (hairColor) {
            case DARK:
                clickPreferenceButton(String.format("2-%s", gender.getGender()), LEFT_BUTTON_POSITION);
                break;
            case LIGHT:
                clickPreferenceButton(String.format("2-%s", gender.getGender()), RIGHT_BUTTON_POSITION);
                break;
        }
        switch (eyeColor) {
            case DARK:
                clickPreferenceButton(String.format("3-%s", gender.getGender()), LEFT_BUTTON_POSITION);
                break;
            case LIGHT:
                clickPreferenceButton(String.format("3-%s", gender.getGender()), RIGHT_BUTTON_POSITION);
                break;
        }
        switch (stature) {
            case ATHLETIC:
            case CURVY:
                clickPreferenceButton(String.format("4-%s", gender.getGender()), LEFT_BUTTON_POSITION);
                break;
            case NORMAL:
            case SLIM:
                clickPreferenceButton(String.format("4-%s", gender.getGender()), RIGHT_BUTTON_POSITION);
                break;
        }
        return initPage(RegisterPage.class);
    }

    public ProfilePage registerUserAs(User user){
        waitForElementVisible(nameEditText);
        type(nameEditText, user.getFirstName());
        type(emailEditText, user.getEmail());
        selectItemByValue(genderSelect, user.getGender());
        selectItemByIndex(ageSelect, user.getAge());
        registrationButton.click();
        return initPage(ProfilePage.class);
    }
}
