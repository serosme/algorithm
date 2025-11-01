package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefixTest {
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void longestCommonPrefixTest(String[] strs, String expected) {
        String result = longestCommonPrefix(strs);
        Assertions.assertEquals(expected, result);
    }

    String longestCommonPrefix(String[] strs) {
        String result = "";

        int min = 200;
        for (String s : strs) {
            int length = s.length();
            if (length < min) {
                min = length;
            }
        }

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                String substring = str.substring(0, i + 1);
                if (substring.length() <= min) {
                    if (!map.containsKey(substring)) {
                        map.put(substring, 1);
                    } else {
                        map.put(substring, map.get(substring) + 1);
                    }
                }
            }
        }

        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == strs.length) {
                keys.add(entry.getKey());
            }
        }
        if (keys.isEmpty()) {
            return result;
        }
        result += keys.get(keys.size() - 1);
        return result;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void longestCommonPrefix2Test(String[] strs, String expected) {
        String result = longestCommonPrefix2(strs);
        Assertions.assertEquals(expected, result);
    }

    String longestCommonPrefix2(String[] strs) {
        // TODO 排序算法有问题
        String result = "";

        Arrays.sort(strs, Comparator.comparingInt(String::length));

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c == s2.charAt(i)) {
                result += c;
            } else  {
                break;
            }
        }

        return result;
    }
}
