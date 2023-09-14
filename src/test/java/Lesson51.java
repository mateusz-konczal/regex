import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson51 {

    // wymiary: 200x400x50, 400 500 80, 800 x 230 x 40
    // dlugosc: 200, szerokosc: 400, wysokosc: 50

    @ParameterizedTest
    @ValueSource(strings = {"200x400x50", "400 500 80", "800 x 230 x 40"})
    void test1(String value) {
        // GIVEN
        String regex = "\\d+[\\sx]+\\d+[\\sx]+\\d+";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"200x400x50", "400 500 80", "800 x 230 x 40"})
    void test2(String value) {
        // GIVEN
        String regex = "(\\d+)[\\sx]+(\\d+)[\\sx]+(\\d+)";
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
    @ValueSource(strings = {"200x400x50", "400 500 80", "800 x 230 x 40"})
    void test3(String value) {
        // GIVEN
        String regex = "(?<length>\\d+)[\\sx]+(?<width>\\d+)[\\sx]+(?<height>\\d+)";
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
        System.out.println("group 1 by name: " + matcher.group("length"));
        System.out.println("group 2 by name: " + matcher.group("width"));
        System.out.println("group 3 by name: " + matcher.group("height"));

        // THEN
        assertThat(resultString).isEqualTo(matcherString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"200x400x50", "400 500 80", "800 x 230 x 40"})
    void test4(String value) {
        // GIVEN
        String regex = "(?<length>\\d+)[\\sx]+(?<width>\\d+)[\\sx]+(?<height>\\d+)";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);

        matcher.find();
        System.out.println("dlugosc: " + matcher.group("length") + ", szerokosc: " +
                matcher.group("width") + ", wysokosc: " + matcher.group("height"));

        // THEN
        assertThat(matcher.group()).isEqualTo(matcherString);
    }
}
