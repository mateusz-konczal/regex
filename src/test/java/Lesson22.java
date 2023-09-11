import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson22 {

    @Test
    void test1() {
        // GIVEN
        String regex = "sk";
        String matcherString = "sk test123 sk sk test123";

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();

        // THEN
//        assertTrue(hasFound);           // JUnit 5
        assertThat(hasFound).isTrue();  // AssertJ
    }

    @Test
    void test2() {
        // GIVEN
        String regex = "sk";
        String matcherString = "sk test123 sk sk test123";

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
//        assertFalse(isMatching);
        assertThat(isMatching).isFalse();
    }

    @Test
    void test3() {
        // GIVEN
        String regex = "sk";
        String matcherString = "sk";

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
//        assertTrue(isMatching);
        assertThat(isMatching).isTrue();
    }

    @Test
    void test4() {
        // GIVEN
        String regex = "sk";
        String matcherString = "sk test123 sk sk test123";
        int expectedMatches = 3;

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
