import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson42 {

    // szukamy: 1234, 1537, 8910
    // nie szukamy: 1, 79, 1235673

    @ParameterizedTest
    @ValueSource(strings = {"1234", "1537", "8910"})
    void test1(String value) {
        // GIVEN
        String regex = "\\d\\d\\d\\d";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "1537", "8910"})
    void test2(String value) {
        // GIVEN
        String regex = "\\d{4}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "79", "1235673", "810"})
    void test3(String value) {
        // GIVEN
        String regex = "\\d{4}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    // szukamy: qwed, asdda, zxczxc
    // nie szukamy: d, asd, zxczccczz

    @ParameterizedTest
    @ValueSource(strings = {"qwed", "asdda", "zxczxc"})
    void test4(String value) {
        // GIVEN
        String regex = "[a-z]{4,6}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"d", "asd", "zxczccczz"})
    void test5(String value) {
        // GIVEN
        String regex = "[a-z]{4,6}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"qwed", "asdda", "zxczxc", "qwedsfd"})
    void test6(String value) {
        // GIVEN
        String regex = "[a-z]{4,}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"d", "asd", "qwe"})
    void test7(String value) {
        // GIVEN
        String regex = "[a-z]{4,}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"d", "as", "asd", "qwe", "zaqw", ""})
    void test8(String value) {
        // GIVEN
        String regex = "[a-z]{0,4}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }
}
