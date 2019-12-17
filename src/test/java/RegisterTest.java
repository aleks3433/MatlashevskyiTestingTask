import framework.BaseTest;
import models.User;
import models.UserBuilder;
import org.testng.annotations.Test;
import pages.AddPhotoPopUp;

import static framework.Gender.FEMALE;
import static framework.Gender.MALE;
import static framework.PreferenceHairAndEyesColor.DARK;
import static framework.PreferenceHairAndEyesColor.LIGHT;
import static framework.PreferenceStature.SLIM;
import static org.testng.Assert.assertTrue;

public class RegisterTest extends BaseTest {
    @Test
    public void registerTest() {
        User user = UserBuilder.registerUser(MALE);
        AddPhotoPopUp addPhotoPopUp = registerPage.choosePreferences(FEMALE, DARK, LIGHT, SLIM)
                .registerUserAs(user)
                .clickDownloadAppPopUpCloseButton()
                .clickAddPhotoIcon()
                .addImage();
        assertTrue(addPhotoPopUp.isGoButtonClickable(), "Go button should be clickable after uploading photo");
    }
}
