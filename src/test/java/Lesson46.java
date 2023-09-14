import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson46 {

    /*
        <div>
            <h1>Hello world</h1>
            <p>Some text</p>
        </div>
     */

    @Test
    void test1() {
        // GIVEN
        String regex = "<.+>"; // zachłanne wyrażenie regularne
        String matcherString = """
                <div>
                    <h1>Hello world</h1>
                    <p>Some text</p>
                </div>""";
        int expectedMatches = 4;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @ParameterizedTest
    @ValueSource(strings = {"""
            <div>
                <h1>Hello world</h1>
                <p>Some text</p>
            </div>""", "<div><h1>Hello world</h1><p>Some text</p></div>"})
    void test2(String value) {
        // GIVEN
        String regex = "<[^>]+>"; // ograniczenie zachłanności wyrażenia regularnego
        String matcherString = value;
        int expectedMatches = 6;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @ParameterizedTest
    @ValueSource(strings = {"""
            <div>
                <h1>Hello world</h1>
                <p>Some text</p>
            </div>""", "<div><h1>Hello world</h1><p>Some text</p></div>"})
    void test3(String value) {
        // GIVEN
        String regex = "<.+?>"; // ograniczenie zachłanności wyrażenia regularnego
        String matcherString = value;
        int expectedMatches = 6;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @ParameterizedTest
    @ValueSource(strings = {"""
            <div>
                <h1>Hello world</h1>
                <p>Some text</p>
            </div>""", "<div><h1>Hello world</h1><p>Some text</p></div>"})
    void test4(String value) {
        // GIVEN
        String regex = "<.*?>"; // ograniczenie zachłanności wyrażenia regularnego, uwaga: uwzględnia również <>
        String matcherString = value;
        int expectedMatches = 6;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        int amountOfMatches = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            amountOfMatches++;
        }

        // THEN
        assertThat(amountOfMatches).isEqualTo(expectedMatches);
    }

    @Test
    void test5() {
        // GIVEN
        String regex = "\\w{3,5}";
        String matcherString = "abcde";

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        matcher.find();
        String resultString = matcher.group();

        // THEN
        assertThat(resultString).isEqualTo("abcde");
    }

    @Test
    void test6() {
        // GIVEN
        String regex = "\\w{3,5}?"; // ograniczenie zachłanności wyrażenia regularnego
        String matcherString = "abcde";

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        matcher.find();
        String resultString = matcher.group();

        // THEN
        assertThat(resultString).isEqualTo("abc");
    }
}
