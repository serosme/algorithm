package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * 有效的括号
 */
public class ValidParenthesesTest {
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([])", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isValidTest(String s, boolean expected) {
        boolean result = isValid(s);
        Assertions.assertEquals(expected, result);
    }

    boolean isValid(String s) {
        boolean result = false;

        if (s.length() % 2 == 1) {
            return result;
        }

        char[] ints = new char[s.length()];
        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            if (index == -1) {
                ints[++index] = s.charAt(i);
            } else {
                char c = s.charAt(i);
                char c1 = ints[index];
                if (c1 == '(' && c == ')') {
                    index--;
                    continue;
                }
                if (c1 == '[' && c == ']') {
                    index--;
                    continue;
                }
                if (c1 == '{' && c == '}') {
                    index--;
                    continue;
                }
                ints[++index] = c;
            }
        }

        if (index == -1) {
            result = true;
        }

        return result;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isValid2Test(String s, boolean expected) {
        boolean result = isValid2(s);
        Assertions.assertEquals(expected, result);
    }

    boolean isValid2(String s) {
        boolean result = false;

        if (s.length() % 2 == 1) {
            return result;
        }

        char[] ints = new char[s.length()];
        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            if (index == -1) {
                ints[++index] = s.charAt(i);
            } else {
                char c = s.charAt(i);
                char c1 = ints[index];
                if (c1 == '(' && c == ')') {
                    index--;
                    continue;
                }
                if (c1 == '[' && c == ']') {
                    index--;
                    continue;
                }
                if (c1 == '{' && c == '}') {
                    index--;
                    continue;
                }
                ints[++index] = c;
            }
        }

        if (index == -1) {
            result = true;
        }

        return result;
    }
}
