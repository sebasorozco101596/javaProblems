package easy;

//28 Implement strStr()
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        if (!haystack.contains(needle)) return -1;

        int left = 0;
        int right = 0;
        int index = 0;

        while (right < haystack.length() && index != (needle.length())){

            if (haystack.charAt(right) == needle.charAt(index)) {
                right++;
                index++;
            } else {
                ++left;
                right = left;
                index = 0;
            }
        }

        return left;
    }


    // Optimal
    public int strStrOptimal(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i =0; i < haystack.length() - needle.length() + 1; i++) {
            if (check(haystack,i,needle))
                return i;
        }
        return -1;
    }
    private boolean check(String haystack, int idx, String needle) {
        for (int i=0; i < needle.length();i++) {
            if (haystack.charAt(idx + i) != needle.charAt(i)) return false;
        }
        return true;
    }
}
