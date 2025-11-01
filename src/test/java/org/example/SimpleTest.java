package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * 示例
 */
public class SimpleTest {
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 3, 5),
                Arguments.of(3, 4, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void twoSumTest(int x, int y, int expected) {
        int result = sum(x, y);
        Assertions.assertEquals(expected, result);
    }

    int sum(int x, int y) {
        return x + y;
    }
}
