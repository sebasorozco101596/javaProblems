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

    // Recursive O(log n )
    public int searchRecursive(int[] nums, int targer, int startI, int endIndex){

        int middle = (endIndex - startI)/2;
        if(middle==0){
            if(nums[startI]==targer){
                return startI;
            }else if(nums[endIndex] == targer){
                return endIndex;
            }else{
                return -1;
            }
        }
        int middleIndex = startI + middle;
        if(nums[startI] <= nums[middleIndex]){
            if(targer>=nums[startI] && targer<=nums[middleIndex]){
                return searchRecursive(nums,targer,startI, middleIndex);
            }else{
                return searchRecursive(nums,targer,middleIndex, endIndex);
            }
        }else if(nums[middleIndex] <= nums[endIndex]){
            if(targer>=nums[middleIndex] && targer<=nums[endIndex]){
                return searchRecursive(nums,targer,middleIndex, endIndex);
            }else{
                return searchRecursive(nums,targer,startI, middleIndex);
            }
        }
        return -1;
    }

    public int searchRecursive(int[] nums, int target) {
        return searchRecursive(nums,target,0,nums.length-1);
    }
}
