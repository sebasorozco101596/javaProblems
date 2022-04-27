package easy;

// 9. Palindrome Number
public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        String number = "";
        int left = 0;
        int right;

        if (x < 0) {
            return false;
        }

        number = String.valueOf(x);
        right = number.length() - 1;

        while (left < right) {
            if (number.charAt(left) == number.charAt(right)) {
                right--;
                left++;
            } else {
                return false;
            }
        }

        return true;
    }
}
