import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson23 {

    @ParameterizedTest
    @ValueSource(strings = {"sk1sk", "skgsk"})
    void test1(String value) {
        // GIVEN
        String regex = "sk.sk";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();

        // THEN
//        assertTrue(hasFound);
        assertThat(hasFound).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"sk121sk", "skggsk"})
    void test2(String value) {
        // GIVEN
        String regex = "sk.sk";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();

        // THEN
//        assertFalse(hasFound);
        assertThat(hasFound).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"sk11sk", "skggsk", "sk12sk"})
    void test3(String value) {
        // GIVEN
        String regex = "sk..sk";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();

        // THEN
//        assertTrue(hasFound);
        assertThat(hasFound).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"sk test123 sk12", "sk test123 sk12\n"})
    void test4(String value) {
        // GIVEN
        String regex = "sk.";
        String matcherString = value;
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
    @ValueSource(strings = {"sk1", "skg"})
    void test5(String value) {
        // GIVEN
        String regex = "sk.";
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
    @ValueSource(strings = {"sk12", "skgg"})
    void test6(String value) {
        // GIVEN
        String regex = "sk.";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
//        assertFalse(isMatching);
        assertThat(isMatching).isFalse();
    }

    @Test
    void test7() {
        // GIVEN
        String regex = "strefakursow\\.pl";
        String matcherString = "strefakursow.pl test123";

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();

        // THEN
//        assertTrue(hasFound);
        assertThat(hasFound).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"strefakursow5pl test123", "strefakursowddpl test123"})
    void test8(String value) {
        // GIVEN
        String regex = "strefakursow\\.pl";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();

        // THEN
//        assertFalse(hasFound);
        assertThat(hasFound).isFalse();
    }
}
