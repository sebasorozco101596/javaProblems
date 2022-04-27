package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 4. Median of Two Sorted Arrays
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        ArrayList<Integer> newArray = new ArrayList<>();

        int upper = 0;
        int down= 0;

        while (upper < (nums1.length) || down < (nums2.length)) {

            if (upper < nums1.length && down < nums2.length) {
                newArray.add(nums1[upper]);
                newArray.add(nums2[down]);
                down++;
                upper++;
            } else if (upper < nums1.length){
                newArray.add(nums1[upper]);
                upper++;
            } else {
                newArray.add(nums2[down]);
                down++;
            }
        }
        if (newArray.size() == 1) {
            return newArray.get(0);
        } else if (newArray.size() == 0) {
            return 0;
        } else {
            Collections.sort(newArray);
            return calculateMedian(newArray);
        }
    }

    public double calculateMedian(ArrayList<Integer> newArray) {
        if ( (newArray.size() % 2) == 0) {
            int left = newArray.get((newArray.size()/2) - 1);
            int right = newArray.get((newArray.size()/2));
            int sum = left + right;
            return sum / 2f;
        } else {
            int position = newArray.size() / 2;
            return newArray.get(position);
        }
    }



    // Optimal solution
    public double findMedianSortedArraysOptimal(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m == n) {
            if (nums1[m-1] <= nums2[0]) return (nums1[m-1] + nums2[0]) / 2.0;
            else if (nums2[m-1] <= nums1[0]) return (nums2[m-1] + nums1[0]) / 2.0;
        } else if (m < n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        m = nums1.length;
        n = nums2.length;
        int lo = 0, hi = 2*m;
        int c1, c2, lmax1 = 0, rmin1 = 0, lmax2 = 0, rmin2 = 0;
        while (lo <= hi) {
            c1 = Math.max(Math.min((hi + lo) >> 1, m + n), m - n);
            c2 = (m + n) - c1;
            lmax1 = c1 == 0 ? Integer.MIN_VALUE : nums1[(c1 - 1) >> 1];
            rmin1 = c1 == 2*m ? Integer.MAX_VALUE : nums1[c1 >> 1];
            lmax2 = c2 == 0 ? Integer.MIN_VALUE : nums2[(c2 - 1) >> 1];
            rmin2 = c2 == 2*n ? Integer.MAX_VALUE : nums2[c2 >> 1];
            if (lmax1 > rmin2) hi = c1 - 1;
            else if (lmax2 > rmin1) lo = c1 + 1;
            else break;
        }
        return (Math.max(lmax1, lmax2) + Math.min(rmin1, rmin2)) / 2.0;
    }

}
