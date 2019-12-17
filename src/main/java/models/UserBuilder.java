package models;

import framework.Gender;

import static utils.RandomStringUtils.*;

public class UserBuilder {
    public static User registerUser(Gender gender) {
        return User.builder()
                .firstName(getRandomAlphabetic(7))
                .email(getEmailWithRandomPart(5))
                .gender(gender.getGender())
                .age(getRandomNumberInRange(1, 53))
                .build();
    }
}
