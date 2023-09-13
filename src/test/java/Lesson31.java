import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson31 {

    // szukamy: tama, jama, gama
    // nie szukamy: dama, .ama

    @ParameterizedTest
    @ValueSource(strings = {"tama", "jama", "gama"})
    void test1(String value) {
        // GIVEN
        String regex = "[tjg]ama";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"dama", "sama", "opama", "ttama"})
    void test2(String value) {
        // GIVEN
        String regex = "[tjg]ama";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @Test
    void test3() {
        // GIVEN
        String regex = "[tjg]ama";
        String matcherString = "tama sk jama test123gama sk sk damatest123 ttama";
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

    @ParameterizedTest
    @ValueSource(strings = {"ama", "tama", "jama", "gama", "ttama", "tjgama", "tjjjjgtama"})
    void test4(String value) {
        // GIVEN
        String regex = "[tjg]*ama";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"dama", "zama", "ztama"})
    void test5(String value) {
        // GIVEN
        String regex = "[tjg]*ama";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"dama", "zama", "ztama"})
    void test6(String value) {
        // GIVEN
        String regex = "[tjg]*ama";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();

        // THEN
        assertThat(hasFound).isTrue();
    }
}
