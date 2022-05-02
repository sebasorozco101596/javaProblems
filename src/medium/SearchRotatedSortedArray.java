package medium;

// 33. Search in Rotated Sorted Array
public class SearchRotatedSortedArray {

    // O(logn)
    public int search(int[] nums, int target) {

        int right = nums.length - 1;
        int left = 0;

        while (left <= right)  {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            }

            right--;
            left++;
        }

        return -1;
    }

    // O(n)
    public int searchN(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
