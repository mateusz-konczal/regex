import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson32 {

    // nie szukamy: tama
    // szukamy: pozostałe litery + ama

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "t"})
    void test1(String value) {
        // GIVEN
        String regex = "[^s]";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @Test
    void test2() {
        // GIVEN
        String regex = "[^s]";
        String matcherString = "s";

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
        String regex = "[^012]";
        String matcherString = "12353464574442323321";
        int expectedMatches = 14;

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
        String regex = "\\s[^s].\\s";
        String matcherString = " sk cb se vk sk sw cd ";
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
    void test5() {
        // GIVEN
        String regex = "[^t]ama";
        String matcherString = "tama rama kama bama zama ttama";
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
