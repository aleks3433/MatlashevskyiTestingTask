package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasicPage {
    @FindBy(className = "interstial-close")
    WebElement downloadAppPopUpCloseButton;
    @FindBy(className = "prof_add_avatar")
    WebElement addPhotoIcon;

    public ProfilePage clickDownloadAppPopUpCloseButton(){
        downloadAppPopUpCloseButton.click();
        return initPage(ProfilePage.class);
    }

    public AddPhotoPopUp clickAddPhotoIcon(){
        addPhotoIcon.click();
        return initPage(AddPhotoPopUp.class);
    }
}
