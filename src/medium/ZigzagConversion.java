package medium;

// 6. Zigzag Conversion
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        String zigzagWord = "";

        int limits = (numRows - 1) * 2;
        int startSecondIndex = 2;

        zigzagWord = getPositionsForRow(1,limits,limits,s);

        for (int i = 2; i <= numRows - 1; i++) {
            limits -= 2;
            zigzagWord += getPositionsForRow(i,limits,startSecondIndex,s);
            startSecondIndex += 2;
        }
        limits = (numRows - 1) * 2;

        zigzagWord += getPositionsForRow(numRows,limits,limits,s);

        return zigzagWord;
    }

    public String getPositionsForRow(int row, int index, int secondIndex, String word) {
        String subWord = "";
        int right = row - 1;
        boolean change = true;

        while (right < word.length()) {
            if (change) {
                change = false;
                subWord += word.charAt(right);
                right += index;

            } else {
                change = true;
                subWord += word.charAt(right);
                right += secondIndex;
            }
        }

        return subWord;
    }


    public String convertOptimal(String s, int numRows) {
        int length = s.length();

        if (length < numRows || numRows <=1) {
            return s;
        }

        char[] chars = new char[length];
        int charIndex = 0;
        int interval = 2 * numRows - 2;

        for (int i = 0; i < numRows; ++i) {
            int step = interval - 2 * i;
            for (int j = i; j < length ; j += interval) {
                chars[charIndex] = s.charAt(j);
                ++charIndex;
                if (step > 0 && step < interval && j + step < length) {
                    chars[charIndex] = s.charAt(j + step);
                    ++charIndex;
                }
            }

        }

        return new String(chars);
    }
}
