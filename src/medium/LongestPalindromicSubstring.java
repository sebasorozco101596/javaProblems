package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

// 5. Longest Palindromic Substring
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        HashMap<Integer, String> palindromes = new HashMap<>();
        int maxSubstring = 0;
        if (s.length() == 1) {
            return s;
        } else if (isPalindrome(s)){
            return s;
        } else {
            for (int i = 0; i < s.length(); i++) {
                int next = i;
                for (int j = next; j < s.length(); j++) {
                    System.out.println(j);
                    String substring = s.substring(i,j);
                    if (isPalindrome(substring)) {

                        int length = substring.length();
                        palindromes.put(length, substring);

                        if (length > maxSubstring) {
                            maxSubstring = length;
                        }
                    }
                    next++;
                }
            }
        }

        System.out.println(isPalindrome("bb"));

        //Collections.sort(palindromes);
        return palindromes.get(maxSubstring);
    }

    public boolean isPalindrome(String word) {
        boolean isPalindrome = false;
        int right = word.length() - 1, left = 0;

        while (right > left) {
            if (word.charAt(left) == word.charAt(right)) {
                right++;
                left++;
            } else {
                isPalindrome =  false;
                break;
            }
            isPalindrome = true;
        }
        return isPalindrome;
    }
}
