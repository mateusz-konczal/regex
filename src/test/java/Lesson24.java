import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson24 {

    @ParameterizedTest
    @ValueSource(strings = {"skkkk", "sk", "s"})
    void test(String value) {
        // GIVEN
        String regex = "sk*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
//        assertTrue(isMatching);
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"sqwerty"})
    void test2(String value) {
        // GIVEN
        String regex = "sk*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
//        assertFalse(isMatching);
        assertThat(isMatching).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"sqwerty"})
    void test3(String value) {
        // GIVEN
        String regex = "sk*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();

        // THEN
//        assertTrue(isMatching);
        assertThat(hasFound).isTrue();
    }

    @Test
    void test4() {
        // GIVEN
        String regex = "sk*";
        String matcherString = "sqqskk";
        int expectedMatches = 2;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }

        // THEN
//        assertEquals(expectedMatches, amountOfMatches);
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }
}
