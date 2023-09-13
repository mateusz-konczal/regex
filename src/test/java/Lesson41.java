import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson41 {

    // szukamy: sk test1 test2, sk bla test1, sk test2 bla
    // nie szukamy: test1 sk bla, test2 bla sk, bla sk test1
    // KOTWICA POCZĄTKOWA (^)

    @ParameterizedTest
    @ValueSource(strings = {"test123qwesfdajkalaske", "test123", "test123509"})
    void test1(String value) {
        // GIVEN
        String regex = "^test.*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"sk test1 test2", "sk bla test1", "sk test2 bla"})
    void test2(String value) {
        // GIVEN
        String regex = "^sk.*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1 sk bla", "test2 bla sk", "bla sk test1"})
    void test3(String value) {
        // GIVEN
        String regex = "^sk.*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    // szukamy: test1 test2 sk, bla test1 sk, test2 bla sk
    // nie szukamy: test1 sk bla, sk test2 bla, bla sk test1
    // KOTWICA KOŃCOWA ($)

    @ParameterizedTest
    @ValueSource(strings = {"qwesfdajkalasketest123", "test123", "509test123"})
    void test4(String value) {
        // GIVEN
        String regex = ".*test123$";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1 test2 sk", "bla test1 sk", "test2 bla sk"})
    void test5(String value) {
        // GIVEN
        String regex = ".*sk$";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1 sk bla", "sk test2 bla", "bla sk test1"})
    void test6(String value) {
        // GIVEN
        String regex = ".*sk$";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    // --------------------------------------------------------------------------

    @ParameterizedTest
    @ValueSource(strings = {"1qweacxczc", "0xd9", "99D2_71b"})
    void test7(String value) {
        // GIVEN
        String regex = "^\\d.*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"qweacxczc", "xd9", "D2_71b"})
    void test8(String value) {
        // GIVEN
        String regex = "^\\d.*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1qweacxczc2", "0xd9", "99D2_71b4"})
    void test9(String value) {
        // GIVEN
        String regex = "^\\d.*\\d$";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1qweacxczc", "0xd", "D2_71b"})
    void test10(String value) {
        // GIVEN
        String regex = ".*\\d$";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }
}
