package medium;

// 7. Reverse Integer
public class ReverseInteger {

    public int reverse(int x) {

        String num = String.valueOf(x);
        String numReversed = "";
        boolean isNegative = x < 0;

        try {
            if (isNegative) {
                for (int i = num.length() -1 ; i >= 1; i--) {
                    numReversed += num.charAt(i);
                }
            } else {
                for (int i = num.length() -1 ; i >= 0; i--) {
                    numReversed += num.charAt(i);
                }
            }

            if (isNegative) {
                return Integer.parseInt(numReversed) * -1;
            } else {
                return Integer.parseInt(numReversed);
            }
        } catch (NumberFormatException error) {
            return 0;
        }
    }


    // Optimal
    public int reverseOptimal(int x) {
        int reverse = 0;
        while(x!=0){
            int remainder = x%10;
            x = x/10;
            if((reverse > (Integer.MAX_VALUE/10)) || (reverse < (Integer.MIN_VALUE/10)))    return 0;
            if((reverse== (Integer.MAX_VALUE/10)) && remainder>7)   return 0;
            if((reverse == (Integer.MIN_VALUE/10)) && remainder<-8) return 0;
            reverse = reverse * 10 + remainder;

        }
        return reverse;

    }
}
