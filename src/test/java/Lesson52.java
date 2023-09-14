import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Lesson52 {

    // Adam, Nowak, 32, Zielona Gora
    // Jan,Kowalski,40,Bielsko-Biala
    // Imie: Adam, Nazwisko: Nowak, Miasto: Zielona Gora, Wiek: 32

    @ParameterizedTest
    @ValueSource(strings = {"Adam, Nowak, 32, Zielona Gora", "Jan,Kowalski,40,Bielsko-Biala"})
    void test1(String value) {
        // GIVEN
        String regex = "[a-zA-Z]+[\\s,]+[a-zA-Z]+[\\s,]+\\d{1,3}[\\s,]+[a-zA-Z-\\s]+";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);
        boolean isMatching = matcher.matches();

        // THEN
        assertThat(isMatching).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Adam, Nowak, 32, Zielona Gora", "Jan,Kowalski,40,Bielsko-Biala"})
    void test2(String value) {
        // GIVEN
        String regex = "([a-zA-Z]+)[\\s,]+([a-zA-Z]+)[\\s,]+(\\d{1,3})[\\s,]+([a-zA-Z-\\s]+)";
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
    @ValueSource(strings = {"Adam, Nowak, 32, Zielona Gora", "Jan,Kowalski,40,Bielsko-Biala"})
    void test3(String value) {
        // GIVEN
        String regex = "(?<firstName>[a-zA-Z]+)[\\s,]+(?<lastName>[a-zA-Z]+)[\\s,]+(?<age>\\d{1,3})[\\s,]+(?<city>[a-zA-Z-\\s]+)";
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
        System.out.println("group 1 by name: " + matcher.group("firstName"));
        System.out.println("group 2 by name: " + matcher.group("lastName"));
        System.out.println("group 3 by name: " + matcher.group("age"));
        System.out.println("group 4 by name: " + matcher.group("city"));

        // THEN
        assertThat(resultString).isEqualTo(matcherString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Adam, Nowak, 32, Zielona Gora", "Jan,Kowalski,40,Bielsko-Biala"})
    void test4(String value) {
        // GIVEN
        String regex = "(?<firstName>[a-zA-Z]+)[\\s,]+(?<lastName>[a-zA-Z]+)[\\s,]+(?<age>\\d{1,3})[\\s,]+(?<city>[a-zA-Z-\\s]+)";
        String matcherString = value;

        // WHEN
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matcherString);

        matcher.find();
        System.out.println("Imie: " + matcher.group("firstName") + ", Nazwisko: " + matcher.group("lastName") +
                ", Miasto: " + matcher.group("city") + ", Wiek: " + matcher.group("age"));

        // THEN
        assertThat(matcher.group()).isEqualTo(matcherString);
    }
}
