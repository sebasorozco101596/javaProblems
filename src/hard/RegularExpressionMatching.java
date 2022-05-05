package hard;

enum Result {
    TRUE, FALSE
}
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        int sPointer = 0;
        int pPointer = 0;
        char anyLetter = '.';
        char anyPrecedingLetters = '*';
        char lastLetter = p.charAt(pPointer);
        char lastLetterTested = s.charAt(sPointer);

        while (sPointer < s.length() && pPointer < p.length()) {

            if (lastLetter != p.charAt(pPointer) && p.charAt(pPointer) != '*') {
                lastLetter = p.charAt(pPointer);
                System.out.println("new lastLetter is: " + lastLetter);
            }

            if (lastLetterTested != s.charAt(sPointer)) {
                lastLetterTested = s.charAt(sPointer - 1);
                System.out.println("new lastLetterTested is: " + lastLetterTested);
            }

            if (s.charAt(sPointer) == p.charAt(pPointer)) {
                sPointer++;
                pPointer++;
                System.out.println("Adding sPointer and pPointer  (1): " + sPointer + ", p: " + pPointer);
            } else if (p.charAt(pPointer) == anyLetter) {
                sPointer++;
                pPointer++;
                System.out.println("Adding sPointer and pPointer  (2): " + sPointer + ", p: " + pPointer);
            } else if (p.charAt(pPointer) == anyPrecedingLetters) {
                if (p.length() - (pPointer+1) > (s.length() - (sPointer+1))) {
                    pPointer++;
                    System.out.println(p.length() + "," + pPointer);
                    System.out.println(s.length() + "," + sPointer);
                    System.out.println("Adding pPointer   (3.2): " + pPointer);
                } else if (p.length() - (pPointer+1) == (s.length() - (sPointer+1))) {
                    sPointer++;
                    pPointer++;
                    System.out.println(p.length() + "," + pPointer);
                    System.out.println(s.length() + "," + sPointer);
                    System.out.println("Adding pPointer   (3.2): " + pPointer);
                } else if (s.charAt(sPointer) == lastLetter) {
                    sPointer++;
                    System.out.println("Adding sPointer   (3.1): " + sPointer);
                } else if (lastLetter == '.') {
                    sPointer++;
                    System.out.println("Adding sPointer   (3.3): " + sPointer);
                }  else {
                    pPointer++;
                    System.out.println("Adding pPointer   (3.4): " + pPointer);
                }
            } else {
                if (p.length() > pPointer + 1) {
                    if (p.charAt(pPointer + 1) == '*') {
                        pPointer += 2;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        boolean verifyingFinish = sPointer == s.length();
        boolean verifyFinishedWithZero = verifyingFinish && p.length() - pPointer == 2 && p.charAt(p.length()-1) == '*';
        boolean verifyingFinishAndLastAny = verifyingFinish &&
                ((pPointer == p.length() - 1 && p.charAt(p.length()-1) == anyPrecedingLetters) || verifyFinishedWithZero);
        boolean verifyAllFinished = verifyingFinish && (pPointer == p.length());


        return  verifyAllFinished || verifyingFinishAndLastAny;
    }


    Result[][] memo;
    public boolean isMatchOptimal(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dynamicProgramming(0, 0, text, pattern);
    }

    public boolean dynamicProgramming(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dynamicProgramming(i, j+2, text, pattern) ||
                        first_match && dynamicProgramming(i+1, j, text, pattern));
            } else {
                ans = first_match && dynamicProgramming(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
