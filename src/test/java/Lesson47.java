import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson47 {

    @ParameterizedTest
    @ValueSource(strings = {"asdasd111225345", "asdasd111225345xcvb12op22df21"})
    void test1(String value) {
        // GIVEN
        String regex = "1{1,3}2{1,3}";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);

        matcher.find();
        String resultString = matcher.group();
        System.out.println(resultString);

        // THEN
        assertThat(resultString).isEqualTo("11122");
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdasd111225345", "asdasd111225345xcvb12op22df21"})
    void test2(String value) {
        // GIVEN
        String regex = "(1{1,3})(2{1,3})";
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
        assertThat(resultString).isEqualTo("11122");
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdasd111225345", "asdasd111225345xcvb12op22df21"})
    void test3(String value) {
        // GIVEN
        String regex = "(1{1,3})(2{1,3})";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        String resultString = "";

        while (matcher.find()) {
            resultString = matcher.group();
            System.out.println(resultString);
            System.out.println("group count: " + matcher.groupCount());
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println("group " + i + ": " + matcher.group(i));
            }
        }

        // THEN
        assertThat(resultString).isNotBlank();
    }

    @Test
    void test4() {
        // GIVEN
        String regex = "(w+)\\.([a-z0-9]+)\\.([a-z]+)";
        String matcherString = "www.strefakursow.pl";

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

    @Test
    void test5() {
        // GIVEN
        String regex = "(?<worldWideWeb>w+)\\.(?<siteName>[a-z0-9]+)\\.(?<extension>[a-z]+)";
        String matcherString = "www.strefakursow.pl";

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
        System.out.println("group 1 by name: " + matcher.group("worldWideWeb"));
        System.out.println("group 2 by name: " + matcher.group("siteName"));
        System.out.println("group 3 by name: " + matcher.group("extension"));

        // THEN
        assertThat(resultString).isEqualTo(matcherString);
    }
}
