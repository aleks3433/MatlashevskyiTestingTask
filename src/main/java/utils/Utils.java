package utils;

import java.io.File;

public class Utils {
    public static String getAbsolutePath(String path) {
        File file = new File(path);
        return file.getAbsolutePath();
    }
}
