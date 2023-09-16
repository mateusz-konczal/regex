import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson54 {

    // mateuszkonczal96@gmail.com
    // Internet E-mail address format (RFC 822)
    // rozwiązanie: ogólne wyrażenie regularne i wysłanie wiadomości z linkiem potwierdzającym adres e-mail

    @ParameterizedTest
    @ValueSource(strings = {"mateuszkonczal96@gmail.com", "mateusz.konczal96@gmail.com",
            "mateusz-konczal96@gmail.com", "mateusz_konczal96@gmail.com", "Mateusz.Konczal96@gmail.com",
            "_test123@test.com", "\"qwe\\\\asdasd\"@test.com"})
    void test1(String value) {
        // GIVEN
        String regex = "[a-zA-Z0-9.\\-_\"\\\\]+@[a-z0-9]+\\.[a-z]+";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"mateuszkonczal96@gmail.com", "mateusz.konczal96@gmail.com",
            "mateusz-konczal96@gmail.com", "mateusz_konczal96@gmail.com", "Mateusz.Konczal96@gmail.com",
            "_test123@test.com", "\"qwe\\\\asdasd\"@test.com"})
    void test2(String value) {
        // GIVEN
        String regex = ".+@.+\\..+"; // ogólne wyrażenie regularne dla adresu e-mail
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }
}
