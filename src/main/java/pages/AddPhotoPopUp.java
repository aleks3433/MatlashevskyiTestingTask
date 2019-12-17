package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Utils.getAbsolutePath;

public class AddPhotoPopUp extends BasicPage {
    @FindBy(id = "photo")
    WebElement addPhotoButton;
    @FindBy(className = "add-ava-go-btn")
    WebElement goButton;
    @FindBy(xpath = "//div[contains(@class,'user-avatar')]/div[@class='loading_indicator']")
    WebElement loadPhotoSpiner;

    private static final String PATH_TO_IMAGE = "src/test/resources/test_image.jpg";

    public AddPhotoPopUp addImage() {
        addPhotoButton.sendKeys(getAbsolutePath(PATH_TO_IMAGE));
        return initPage(AddPhotoPopUp.class);
    }

    public boolean isGoButtonClickable() {
        waitForElementVisible(loadPhotoSpiner);
        waitForElementInvisible(loadPhotoSpiner);
        return goButton.isEnabled();
    }
}
