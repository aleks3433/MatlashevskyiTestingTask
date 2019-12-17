package utils;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class RandomStringUtils {
    public static String getRandomAlphabetic(int length) {
        return randomAlphabetic(length);
    }

    public static String getEmailWithRandomPart(int randomPartLength) {
        return randomAlphabetic(randomPartLength) + "@testmail.com";
    }

    public static int getRandomNumberInRange(int start, int bound) {
        Random random = new Random();
        return start + random.nextInt(bound);
    }
}
