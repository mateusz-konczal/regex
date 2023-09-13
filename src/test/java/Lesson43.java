import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson43 {

    @ParameterizedTest
    @ValueSource(strings = {"3", "33", "333", "3333333333"})
    void test1(String value) {
        // GIVEN
        String regex = "3+";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "033", "xsd3d"})
    void test2(String value) {
        // GIVEN
        String regex = "3+";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "3", "33", "3333333333"})
    void test3(String value) {
        // GIVEN
        String regex = "3*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    // szukamy: 125 3333 adck, 637 33 asc, 12 3 adbj
    // nie szukamy: ciągów znaków z literkami ghi

    @ParameterizedTest
    @ValueSource(strings = {"125333adck", "63733asc", "123adbj", "1253333adck"})
    void test4(String value) {
        // GIVEN
        String regex = "\\d{2,3}3+[a-z&&[^g-i]]{3,4}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"125333agck", "63733aic", "123ahbj", "1253333aghi", "127abc"})
    void test5(String value) {
        // GIVEN
        String regex = "\\d{2,3}3+[a-z&&[^g-i]]{3,4}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }
}
