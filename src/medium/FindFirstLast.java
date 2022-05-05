package medium;

// 34. Find First and Last Position of Element in Sorted Array
public class FindFirstLast {
    public int[] searchRange_firstTry(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == target && nums[right] == target) {
                return new int[] {left,right};
            }

            if (nums[left] != target) {
                left++;
            }

            if (nums[right] != target) {
                right--;
            }
        }

        return new int[] {-1,-1};
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = binarySearch(nums, target, 0, nums.length-1, false);
        int end = binarySearch(nums, target, 0, nums.length-1, true);
        return new int[]{start, end};
    }

    private int binarySearch(int[] nums, int target, int low, int high, boolean front) {
        int keyIndex = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] < target) {
                low = mid+1;
            } else if(nums[mid] > target){
                high = mid-1;
            } else {
                keyIndex = mid;
                if(front) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return keyIndex;
    }
}
