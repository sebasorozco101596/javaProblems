package easy;

// Search Insert Position
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int num;
        int result = 0;
        boolean isFounded = false;
        while (!isFounded) {
            num = nums[index];
            if(num == target) {
                result = index;
                break;
            } else if (num >= target) {
                result = index;
                break;
            } else {
                index++;
            }
            if (index == nums.length) {
                isFounded = true;
            }
        }

        if(index == nums.length) {
            result = nums.length;
        }

        return result;
    }

    // Optimal Solution

    public int searchInsertOptimal(int[] nums, int target) {

        int high = nums.length-1;
        int low =0;

        while(low < high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                low = mid+1;
            } else {
                high = mid;
            }
        }

        if(target > nums[nums.length -1])
            return nums.length;
        else
            return low;

    }
}
