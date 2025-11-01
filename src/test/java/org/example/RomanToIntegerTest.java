package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 罗马数字转整数
 */
public class RomanToIntegerTest {
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("IX", 9),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void twoSumTest(String s, int expected) {
        int result = romanToInt(s);
        Assertions.assertEquals(expected, result);
    }

    int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            String s2;
            if (i == s.length() - 1) {
                s2 = "";
            } else {
                s2 = String.valueOf(s.charAt(i + 1));
            }
            String s3 = s1 + s2;
            if (map.containsKey(s3)) {
                y += map.get(s3);
                i++;
            } else {
                y += map.get(s1);
            }
        }
        return y;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void twoSum2Test(String s, int expected) {
        int result = romanToInt2(s);
        Assertions.assertEquals(expected, result);
    }

    int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            if (i < s.length() - 1) {
                Character c2 = s.charAt(i + 1);
                if (map.get(c1) < map.get(c2)) {
                    y -= map.get(c1);
                } else {
                    y += map.get(c1);
                }
            } else {
                y += map.get(c1);
            }
        }
        return y;
    }
}
