import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson35 {

    // d, D, s, S, w, W

    @Test
    void test1() {
        // GIVEN
        String regex = "[0-9]";
        String matcherString = "sk test123 sk sk test123 0x -9";
        int expectedMatches = 8;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @Test
    void test2() {
        // GIVEN
        String regex = "\\d"; // [0-9]
        String matcherString = "sk test123 sk sk test123 0x -9";
        int expectedMatches = 8;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @Test
    void test3() {
        // GIVEN
        String regex = "\\D"; // [^0-9]
        String matcherString = "sk test123 sk sk test123 0x -9";
        int expectedMatches = 22;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @Test
    void test4() {
        // GIVEN
        String regex = "\\s";
        String matcherString = "sk test123 sk sk test123 0x -9";
        int expectedMatches = 6;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @Test
    void test5() {
        // GIVEN
        String regex = "\\S";
        String matcherString = "sk test123 sk sk test123 0x -9";
        int expectedMatches = 24;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @Test
    void test6() {
        // GIVEN
        String regex = "\\w"; // [a-zA-Z0-9_]
        String matcherString = "!@#_aB1 %";
        int expectedMatches = 4;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @Test
    void test7() {
        // GIVEN
        String regex = "\\W"; // [^a-zA-Z0-9_]
        String matcherString = "!@#_aB1 %";
        int expectedMatches = 5;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }
}
