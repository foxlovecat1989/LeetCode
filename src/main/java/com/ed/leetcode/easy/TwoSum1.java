package com.ed.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@Slf4j
public class TwoSum1 {
//    Given an array of integers nums and an integer target,
//    return indices of the two numbers such that they add up to target.
//    You may assume that each input would have exactly one solution,
//    and you may not use the same element twice.
//    You can return the answer in any order.

//    Example 1:
//
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

//
//    Example 2:
//
//    Input: nums = [3,2,4], target = 6
//    Output: [1,2]
//
//
//    Example 3:
//
//    Input: nums = [3,3], target = 6
//    Output: [0,1]
//
//
//    Constraints:
//
//            2 <= nums.length <= 104
//            -109 <= nums[i] <= 109
//            -109 <= target <= 109
//    Only one valid answer exists.

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] ans1 = TwoSum1.twoSum(nums1, target1);
        log.debug("ans1: {}", Arrays.toString(ans1));

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] ans2 = TwoSum1.twoSum(nums2, target2);
        log.debug("ans2: {}", Arrays.toString(ans2));

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] ans3 = TwoSum1.twoSum(nums3, target3);
        log.debug("ans3: {}", Arrays.toString(ans3));

        int[] nums4 = {3, 3};
        int target4 = -1;
        int[] ans4 = TwoSum1.twoSum(nums4, target4);
        log.debug("ans4: {}", Arrays.toString(ans4));
    }


    public static int[] twoSum(int[] nums, int target) {
        checkInput(nums, target);

        return findNumber(nums, target);
    }

    private static void checkInput(int[] nums, int target) {
        boolean invalidElementsSize = nums.length < 2;
        if (invalidElementsSize)
            throw new IllegalStateException("nums數量不可少於2");
        boolean invalidTargetNumber = target < 0;
        if (invalidTargetNumber)
            throw new IllegalStateException("目標數字不可小於0");
    }

    private static int[] findNumber(int[] nums, int target) {
        if (nums.length == 2 && nums[0] + nums[1] == target)
            return new int[]{0, 1};

        Map<Integer, List<Integer>> datas = getData(nums);
        AtomicInteger currentIndex = new AtomicInteger();
        int answerIndex = IntStream.range(0, nums.length)
                .filter(index -> {
                    int gap = target - nums[index];
                    boolean isFound = Optional.ofNullable(datas.get(gap)).isPresent();
                    AtomicBoolean isSameElement = new AtomicBoolean(true);
                    if (isFound)
                        datas.get(gap).stream()
                                .filter(element -> element != index)
                                .findAny().ifPresent(matchedIndex -> {
                                    currentIndex.set(matchedIndex);
                                    isSameElement.set(false);
                                });


                    return isFound && !isSameElement.get();
                })
                .findAny().orElseThrow(() -> new IllegalStateException("datas error"));


        return Stream.of(currentIndex.get(), answerIndex)
                .mapToInt(i -> i)
                .toArray();
    }

    private static Map<Integer, List<Integer>> getData(int[] nums) {
        Map<Integer, List<Integer>> datas = new HashMap<>();
        IntStream.range(0, nums.length)
                .forEach(index -> {
                    List<Integer> elements = getElements(nums, datas, index);
                    elements.add(index);
                    datas.put(nums[index], elements);
                });

        return datas;
    }

    private static List<Integer> getElements(int[] nums, Map<Integer, List<Integer>> datas, int index) {
        boolean isPresent =
                Optional.ofNullable(datas.get(nums[index])).isPresent() &&
                        !datas.get(nums[index]).isEmpty();
        if (isPresent)
            return datas.get(nums[index]);
        else
            return new ArrayList<>();
    }
}
