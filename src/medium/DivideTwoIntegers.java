package medium;

// 29. Divide Two Integers
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int maxNumber = Integer.MAX_VALUE;
        int minNumber = Integer.MIN_VALUE;



        long div = dividend / divisor;
        if (dividend < 0 && divisor < 0) {
            div = (div * -1);
        }

        if (div >= maxNumber) {
            System.out.println(" Im here");
            if (dividend < 0 && divisor < 0) {
                return maxNumber;
            } else if (dividend > 0 && divisor > 0) {
                return maxNumber;
            } else {
                return minNumber;
            }
        } else {
            System.out.println(" Im here 2");
            return Integer.parseInt(String.valueOf(dividend/divisor));
        }
    }

    public int divideOptimal(int dividend, int divisor) {
        int n;
        n=dividend/divisor;
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        return n;
    }
}
