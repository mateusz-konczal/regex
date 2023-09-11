import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Lesson21 {

    @Test
    void test() {
        Pattern pattern = Pattern.compile("regex");
        Matcher matcher = pattern.matcher("Badany ciąg znaków");
//        matcher.find();       // Attempts to find the next subsequence of the input sequence that matches the pattern.
//        matcher.matches();    // Attempts to match the entire region against the pattern.
    }
}
