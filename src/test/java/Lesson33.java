import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson33 {

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "T", "V", "Z"})
    void test1(String value) {
        // GIVEN
        String regex = "[A-Z]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "t", "v", "z"})
    void test2(String value) {
        // GIVEN
        String regex = "[A-Z]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "t", "v", "z", "g"})
    void test3(String value) {
        // GIVEN
        String regex = "[a-z]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "T", "V", "Z", "G"})
    void test4(String value) {
        // GIVEN
        String regex = "[a-z]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "4", "7", "9"})
    void test5(String value) {
        // GIVEN
        String regex = "[1-9]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "27", "999"})
    void test6(String value) {
        // GIVEN
        String regex = "[1-9]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3"})
    void test7(String value) {
        // GIVEN
        String regex = "[0-3]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "4", "2000", "-993"})
    void test8(String value) {
        // GIVEN
        String regex = "[0-3]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"C", "D", "G"})
    void test9(String value) {
        // GIVEN
        String regex = "[C-G]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"B", "H", "Z"})
    void test10(String value) {
        // GIVEN
        String regex = "[C-G]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "G", "M", "Z"})
    void test11(String value) {
        // GIVEN
        String regex = "[a-cG-Z]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"d", "m", "z", "B", "E", "F"})
    void test12(String value) {
        // GIVEN
        String regex = "[a-cG-Z]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "G", "M", "Z", "5", "6", "7"})
    void test13(String value) {
        // GIVEN
        String regex = "[a-cG-Z5-7]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"d", "m", "z", "B", "E", "F", "3", "8", "106"})
    void test14(String value) {
        // GIVEN
        String regex = "[a-cG-Z5-7]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @Test
    void test15() {
        // GIVEN
        String regex = "\\s..[0-3]*\\s";
        String matcherString = " bg3 bg2 cc0b1 sd ddd3 re4 cc021  9-0123223  sa2";
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
}
