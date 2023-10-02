package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isString(String string) {
        return string.matches("[a-zA-Z]+");
    }

}
