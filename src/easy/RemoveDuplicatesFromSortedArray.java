package easy;

import java.util.ArrayList;
import java.util.HashMap;

// Remove Duplicates from Sorted Array
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int index = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[index]) {
                index++;
                nums[index] = nums[j];
            }
        }

        return index + 1;
    }
}
