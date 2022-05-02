package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 17. Letter Combinations of a Phone Number
public class LetterCombinationsPhoneNumber {

    HashMap<Integer, String> letters = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> combinations = new ArrayList<>();

        letters.put(2, "abc");
        letters.put(3, "def");
        letters.put(4, "ghi");
        letters.put(5, "jkl");
        letters.put(6, "mno");
        letters.put(7, "pqrs");
        letters.put(8, "tuv");
        letters.put(9, "wxyz");

        for (int i = 0; i < digits.length(); i++) {
            combinations = getCombinations(digits.charAt(i), combinations);
        }

        return combinations;
    }

    private ArrayList<String> getCombinations(char digit, ArrayList<String> pastCombinations) {

        ArrayList<String> newCombinations = new ArrayList<>();
        String thisLetters = letters.get(Integer.parseInt("" + digit));

        if (pastCombinations.isEmpty()) {
            for (int i = 0; i < thisLetters.length(); i++) {
                newCombinations.add(String.valueOf(thisLetters.charAt(i)));
            }
        } else {
            for (String comb: pastCombinations) {
                for (int i = 0; i < thisLetters.length(); i++) {
                    newCombinations.add(comb + thisLetters.charAt(i));
                }
            }
        }

        return newCombinations;
    }


}
