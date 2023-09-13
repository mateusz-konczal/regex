import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson36 {

    // szukamy: abCD#12, EFgz!34, ...
    // nie szukamy: stQR@89, OPuw%79, OPuw%89

    private static final String REGEX = "[a-zA-Z&&[^s-wO-R]]*[\\W&&[^@%]][0-6]*";

    @ParameterizedTest
    @ValueSource(strings = {"abCD#12", "EFgz!34"})
    void test1(String value) {
        // GIVEN
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"stQR@89", "OPuw%79", "OPuw%89"})
    void test2(String value) {
        // GIVEN
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isFalse();
    }
}
