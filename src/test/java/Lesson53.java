import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson53 {

    // 15-02-1990, 02 04 1995, 28 - 07 - 1992
    // 15.02.90r.

    @ParameterizedTest
    @ValueSource(strings = {"15-02-1990", "02 04 1995", "28 - 07 - 1992"})
    void test1(String value) {
        // GIVEN
        String regex = "\\d{2}[\\s-]+\\d{2}[\\s-]+\\d{2}\\d{2}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"15-02-1990", "02 04 1995", "28 - 07 - 1992"})
    void test2(String value) {
        // GIVEN
        String regex = "(\\d{2})[\\s-]+(\\d{2})[\\s-]+\\d{2}(\\d{2})";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);

        matcher.find();
        String resultString = matcher.group();
        System.out.println(resultString);
        System.out.println("group count: " + matcher.groupCount());
        for (int i = 0; i <= matcher.groupCount(); i++) {
            System.out.println("group " + i + ": " + matcher.group(i));
        }

        // THEN
        assertThat(resultString).isEqualTo(matcherString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"15-02-1990", "02 04 1995", "28 - 07 - 1992"})
    void test3(String value) {
        // GIVEN
        String regex = "(?<day>\\d{2})[\\s-]+(?<month>\\d{2})[\\s-]+\\d{2}(?<year>\\d{2})";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);

        matcher.find();
        String resultString = matcher.group();
        System.out.println(resultString);
        System.out.println("group count: " + matcher.groupCount());
        for (int i = 0; i <= matcher.groupCount(); i++) {
            System.out.println("group " + i + " by index: " + matcher.group(i));
        }
        System.out.println("group 1 by name: " + matcher.group("day"));
        System.out.println("group 2 by name: " + matcher.group("month"));
        System.out.println("group 3 by name: " + matcher.group("year"));

        // THEN
        assertThat(resultString).isEqualTo(matcherString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"15-02-1990", "02 04 1995", "28 - 07 - 1992", "31 - 02 - 1992"})
    void test4(String value) {
        // GIVEN
        String regex = "(?<day>\\d{2})[\\s-]+(?<month>\\d{2})[\\s-]+\\d{2}(?<year>\\d{2})";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);

        matcher.find();
        System.out.println(matcher.group("day") + "." + matcher.group("month") +
                "." + matcher.group("year") + "r.");

        // THEN
        assertThat(matcher.group()).isEqualTo(matcherString);
    }
}
