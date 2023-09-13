import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson44 {

    @ParameterizedTest
    @ValueSource(strings = {"", "1"})
    void test1(String value) {
        // GIVEN
        String regex = "1?";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "11111111111"})
    void test2(String value) {
        // GIVEN
        String regex = "1?";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    // szukamy: ASDZ 1 33, A 1 33333, GDZ 3

    @ParameterizedTest
    @ValueSource(strings = {"ASDZ133", "A133333", "GDZ3"})
    void test3(String value) {
        // GIVEN
        String regex = "[A-Z]{1,4}1?3+";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ASDZV133", "A1333334", "GDZ"})
    void test4(String value) {
        // GIVEN
        String regex = "[A-Z]{1,4}1?3+";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }
}
