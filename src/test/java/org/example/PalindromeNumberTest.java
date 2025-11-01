package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * 回文数
 */
public class PalindromeNumberTest {
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void palindromeNumber1Test(int x, boolean expected) {
        boolean result = palindromeNumber1(x);
        Assertions.assertEquals(expected, result);
    }

    boolean palindromeNumber1(int x) {
        String numStr = String.valueOf(x);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) != numStr.charAt(numStr.length() - 1 - i)) {
                return false;
            }
            if (i > numStr.length() / 2) {
                break;
            }
        }
        return true;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void palindromeNumber2Test(int x, boolean expected) {
        boolean result = palindromeNumber2(x);
        Assertions.assertEquals(expected, result);
    }

    boolean palindromeNumber2(int x) {
        return true;
    }
}
