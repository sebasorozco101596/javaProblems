package medium;

import java.util.*;

// 46. Permutations
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(), new HashSet<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> tempList, Set<Integer> tempSet, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if (tempList.contains(num)) continue; // element already exists, skip

            tempList.add(num);
            tempSet.add(num);

            backtrack(list, tempList, tempSet, nums);

            tempSet.remove(tempList.get(tempList.size() - 1));
            tempList.remove(tempList.size() - 1);
        }

    }



    // Optimal solution

    public List<List<Integer>> permuteOptimal(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permuteHelper(0,nums,output);
        return output;
    }

    private void permuteHelper(int index, int[] nums, List<List<Integer>> output) {
        if (index == nums.length) {
            System.out.print("--------- ");
            List<Integer> temp = new ArrayList<> ();
            for (int num : nums) {
                System.out.print(num + ", ");
                temp.add(num);
            }
            output.add(temp);
            System.out.println("----- added");
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, i, index);
                System.out.println("First swap = i: " + i + " index: "+ index);
                permuteHelper(index+1, nums, output);
                swap(nums, i, index);
                System.out.println("Second swap = i: " + i + " index: "+ index);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
