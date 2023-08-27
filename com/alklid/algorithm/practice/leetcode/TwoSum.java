package alklid.algorithm.practice.leetcode;

import java.util.HashMap;

class Solution {
    // HashTable, 시간복잡도 O(n), 공간복잡도 O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            int findNum = target - nums[i];
            if (map.containsKey(findNum) && map.get(findNum) != i) {
                return new int[]{i, map.get(findNum)};
            }
        }

        throw new IllegalArgumentException("Not found");
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i1=0; i1<nums.length; i1++) {
            int findNum = target - nums[i1];
            if (map.containsKey(findNum)) {
                return new int[]{i1, map.get(findNum)};
            }
            else {
                map.put(nums[i1], i1);
            }
        }

        throw new IllegalArgumentException("Not found");
    }
}

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(result[0] + ", " + result[1]);

        result = solution.twoSum(new int[]{3,2,4}, 6);
        System.out.println(result[0] + ", " + result[1]);

        result = solution.twoSum(new int[]{3,3}, 6);
        System.out.println(result[0] + ", " + result[1]);

        result = solution.twoSum2(new int[]{2,7,11,15}, 9);
        System.out.println(result[0] + ", " + result[1]);

        result = solution.twoSum2(new int[]{3,2,4}, 6);
        System.out.println(result[0] + ", " + result[1]);

        result = solution.twoSum2(new int[]{3,3}, 6);
        System.out.println(result[0] + ", " + result[1]);
    }
}
