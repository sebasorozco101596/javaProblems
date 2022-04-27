package medium;

import java.util.ArrayList;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        String result = "";
        ArrayList<String> temporalResults = new ArrayList<>();
        int way = 0;

        for (int n = 0; n <s.length(); n ++) {
            char c = s.charAt(n);
            if (result.contains("" + c)) {
                if ( way > 0) {
                    n = n - way;
                    way = 0;
                    temporalResults.add(result);
                    result = "";
                }
            } else {
                way++;
                result = result + c;
            }
        }
        temporalResults.add(result);

        for (int i = 0; i < temporalResults.size(); i++) {
            if (temporalResults.get(i).length() > result.length()) {
                result = temporalResults.get(i);
            }
        }
        return result.length();
    }


    // Optimized
    public int lengthOfLongestSubstringOptimized(String s) {

        int left = 0;
        int right = 0;
        int result = 0;
        int[] chars = new int[128]; // char tables by default accessible with O(1) for all ascii values from 0 - 128

        while(right < s.length()) {
            char r = s.charAt(right);

            int i = chars[r];
            if(i >= 1 && i >= left) {
                left = i;
            }

            result = Math.max(result, right - left + 1 );

            // assign the index value to char and increment right
            chars[r] = ++right;
        }

        return result;
    }
}
