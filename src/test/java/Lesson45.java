import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson45 {

    /*
        Plyn na zachod
        Plyn na wschod
        ...
     */

    @ParameterizedTest
    @ValueSource(strings = {"Plyn na zachod", "Plyn na wschod"})
    void test1(String value) {
        // GIVEN
        String regex = "Plyn na (zachod|wschod)";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Plyn na polnoc", "Plyn na poludnie", "Plyn na qwerty"})
    void test2(String value) {
        // GIVEN
        String regex = "Plyn na (zachod|wschod)";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Plyn na zachod", "Plyn na wschod", "Plyn na poludnie", "Plyn na polnoc"})
    void test3(String value) {
        // GIVEN
        String regex = "Plyn na (zachod|wschod|polnoc|poludnie)";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    // szukamy: 11, ..., 11111, 222, ..., 22222222

    @ParameterizedTest
    @ValueSource(strings = {"11", "111", "11111", "222", "222222", "22222222"})
    void test4(String value) {
        // GIVEN
        String regex = "(1{2,5}|2{3,8})";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "111111", "22", "222222222"})
    void test5(String value) {
        // GIVEN
        String regex = "(1{2,5}|2{3,8})";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }
}
