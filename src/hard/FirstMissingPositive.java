package hard;

import java.util.Arrays;

// 41. First Missing Positive
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        if (nums.length == 1 && nums[0] > 1) return 1;

        int firstPositive = 1;

        Arrays.sort(nums);

        for (int num : nums) {
            if (num == firstPositive) {
                firstPositive++;
            } else if (num > firstPositive) {
                return firstPositive;
            }
        }

        return firstPositive;
    }


    // O(n)
    public static int firstMissingPositiveOptimal(int[] nums) {
        boolean[] present = new boolean[nums.length];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                present[num - 1] = true;
            }
        }
        for (int i = 0; i < present.length; i++) {
            if (!present[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
