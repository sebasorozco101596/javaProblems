package easy;

import java.util.Arrays;

// 14. Longest Common Prefix
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int right = 0;
        String commonPrefix = "";
        boolean isPrefix = true;

        if (strs.length >= 1) {
            while (right < strs[0].length()) {

                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() > right) {
                        if ( strs[i].charAt(right) != strs[0].charAt(right)) {
                            isPrefix = false;
                            break;
                        }
                    } else {
                        isPrefix = false;
                        break;
                    }
                }

                if (isPrefix) {
                    commonPrefix = commonPrefix + strs[0].charAt(right);
                } else {
                    break;
                }
                right++;
            }
        } else {
            return strs[0];
        }

        return commonPrefix;
    }

    public String longestCommonPrefixOptimal(String[] strings) {

        Arrays.sort(strings);

        int index = 0;
        int size = strings.length;
        int end = Math.min(strings[0].length(), strings[size - 1].length());

        while (index < end && strings[0].charAt(index) == strings[size-1].charAt(index)) {
            index++;
        }

        return strings[0].substring(0,index);
    }


}
