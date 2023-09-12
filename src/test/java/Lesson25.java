import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson25 {

    @ParameterizedTest
    @ValueSource(strings = {"sk1ssss", "sks"})
    void test1(String value) {
        // GIVEN
        String regex = "sk.s*";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
//        assertTrue(isMatching);
        assertThat(isMatching).isTrue();
    }

    @Test
    void test2() {
        // GIVEN
        String regex = "sk.s*";
        String matcherString = "sktest123sk1sss";
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

    @ParameterizedTest
    @ValueSource(strings = {"skasfko4sfsk", "sksk"})
    void test3(String value) {
        // GIVEN
        String regex = "sk.*sk";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
//        assertTrue(isMatching);
        assertThat(isMatching).isTrue();
    }
}
