package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 两数之和
 */
public class TwoSumTest {
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9),
                Arguments.of(new int[]{3, 2, 4}, 6),
                Arguments.of(new int[]{3, 3}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void twoSumTest(int[] nums, int target) {
        int[] result = twoSum(nums, target);
        Assertions.assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void twoSum2Test(int[] nums, int target) {
        int[] result = twoSum2(nums, target);
        Assertions.assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
