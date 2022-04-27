package easy;

//13. Roman to Integer
public class RomanToInteger {
    public int romanToInt(String s) {
        int left = 0;
        int right = 0;
        int sum = 0;

        while(right < s.length()) {
            char lastChar = s.charAt(left);
            char currentChar = s.charAt(right);
            if(right <= left) {
                sum += getValueByLetter("" + currentChar);
            } else {
                if(getValueByLetter("" + lastChar) < getValueByLetter("" + currentChar)) {
                    sum -= (getValueByLetter("" + lastChar) * 2 );
                }
                sum += getValueByLetter("" + currentChar);
                left++;
            }
            right++;
        }
        return sum;
    }
    public static int getValueByLetter(String letter) {
        switch (letter) {
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
            default: return 0;
        }
    }

    /*
    Optimal solution
     */
    public int romanToIntOptimal(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = romanToDigit(s.charAt(i));
            if (i != s.length() - 1 && digit < romanToDigit(s.charAt(i+1)))
                result -= digit;
            else result += digit;
        }
        return result;
    }
    private int romanToDigit(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }

}
