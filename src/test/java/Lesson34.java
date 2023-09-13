import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson34 {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "4", "8", "9"})
    void test1(String value) {
        // GIVEN
        String regex = "[1-48-9]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "4", "8", "9"})
    void test2(String value) {
        // GIVEN
        String regex = "[1-4[8-9]]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "6", "7", "10", "0"})
    void test3(String value) {
        // GIVEN
        String regex = "[1-48-9]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "6", "7", "10", "0"})
    void test4(String value) {
        // GIVEN
        String regex = "[1-4[8-9]]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "6", "7"})
    void test5(String value) {
        // GIVEN
        String regex = "[3-7&&[5-9]]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "4", "8", "9", "100"})
    void test6(String value) {
        // GIVEN
        String regex = "[3-7&&[5-9]]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @Test
    void test7() {
        // GIVEN
        String regex = "[3-7&&[5-9]]";
        String matcherString = "0123456789";
        int expectedMatches = 3;

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
    void test8() {
        // GIVEN
        String regex = "[a-g&&[d-z]]";
        String matcherString = "qwertyuiopasdfghjklzxcvbnm";
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
    void test9() {
        // GIVEN
        String regex = "[a-g&&[^d-z]]";
        String matcherString = "qwertyuiopasdfghjklzxcvbnm";
        int expectedMatches = 3;

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
