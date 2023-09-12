import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson26 {

    @ParameterizedTest
    @ValueSource(strings = {"sk sk", "sk\nsk", "sk\tsk"})
    void test1(String value) {
        // GIVEN
        String regex = "\\s";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();
        System.out.println(matcherString);

        // THEN
//        assertTrue(hasFound);
        assertThat(hasFound).isTrue();
    }

    @Test
    void test2() {
        // GIVEN
        String regex = "\\s";
        String matcherString = "sksk";

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean hasFound = matcher.find();

        // THEN
//        assertFalse(hasFound);
        assertThat(hasFound).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"sk      sk", "sk\t\tsk", "sk       sk", "sksk"})
    void test3(String value) {
        // GIVEN
        String regex = "sk\\s*sk";
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
    void test4() {
        // GIVEN
        String regex = "\\s";
        String matcherString = "sk\t\tsk";
        int expectedMatches = 2;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }
        System.out.println(matcherString);

        // THEN
//        assertEquals(expectedMatches, amountOfMatches);
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @Test
    void test5() {
        // GIVEN
        String regex = "\\s";
        String matcherString = "sk      sk"; // 2 x Tab
        int expectedMatches = 6;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            amountOfMatches++;
        }
        System.out.println(matcherString);

        // THEN
//        assertEquals(expectedMatches, amountOfMatches);
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @Test
    void test6() {
        // GIVEN
        String regex = "\\s";
        String matcherString = " 5123 6463 1231 6431 ";
        String expectedString = "5123646312316431";

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        String resultString = matcher.replaceAll("");
        System.out.println(matcherString);

        // THEN
//        assertEquals(expectedString, resultString);
        assertThat(resultString).isEqualTo(expectedString);
    }
}
