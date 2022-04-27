package easy;

public class TwoSum {

    /**
     * Problem to resolve the Two sum
     * Problem number 1 in leetCode named Two Sum
     * @param nums
     * @param target
     * @return arrangement of 2 Int
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == diff) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {};
    }
}
