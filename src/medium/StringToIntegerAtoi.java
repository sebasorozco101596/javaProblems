package medium;

// 8. String to Integer (atoi)
public class StringToIntegerAtoi {

    boolean removedZeros = false;
    boolean isNegative = false;
    public int myAtoi(String s) {


        s = s.trim();
        if (s.length() > 1 && isDigit(s.charAt(1))) {
            s = removeInitialZeros(s);
        }
        if (s.length() == 0 || (s.length() == 1 && !isDigit(s.charAt(0)))) {
            return 0;
        }

        int pointer = 0;
        String newNumber = "";
        char signedCharacter = ' ';
        char character;

        System.out.println(s);

        while (pointer < s.length()) {

            character = s.charAt(pointer);
            if (!isNegative) {
                if (!( character== ' ')
                        && (isDigit(character) || character == '-' || character == '+')){
                    if (character == '-') {

                        if (removedZeros) {
                            return 0;
                        }

                        if (newNumber.length() == 0 && signedCharacter != '+') {
                            isNegative = true;
                            signedCharacter = '-';
                        } else {
                            if (newNumber.length() > 0) {
                                return returnNumber(newNumber);
                            } else {
                                return 0;
                            }
                        }
                    } else {
                        if (character != '+') {
                            newNumber += character;
                        } else {
                            if (signedCharacter == '+') {
                                if (newNumber.length() > 0) {
                                    return returnNumber(newNumber);
                                } else {
                                    return 0;
                                }
                            } else {
                                signedCharacter = '+';
                            }
                        }
                    }
                } else {
                    if ((character == ' ') && newNumber.length() == 0) {
//                        pointer++;
//                        continue;
                        return 0;
                    } else if (!isDigit(character)) {
                        if (newNumber.length() > 0) {
                            return returnNumber(newNumber);
                        } else {
                            return 0;
                        }
                    } else {
                        if (newNumber.length() > 0) {
                            return returnNumber(newNumber);
                        }
                    }
                }
            } else {
                if (!(character == '-' || character == ' ' || character == '+') && isDigit(character)){
                    newNumber += s.charAt(pointer);
                } else {
                    if (newNumber.length() > 0) {
                        return returnNumber(newNumber) ;
                    } else {
                        return 0;
                    }
                }
            }
            pointer++;
        }

        return returnNumber(newNumber);
    }

    public int returnNumber(String newNumber) {
        long number;
        int maxNumber = Integer.MAX_VALUE;
        int minNumber = Integer.MIN_VALUE;
        int result;
        try {
            number = Long.parseLong(newNumber);
        } catch (NumberFormatException error) {
            if (isNegative) {
                number = minNumber;
            } else {
                number = maxNumber;
            }
        }

        if(number <= maxNumber && number >= minNumber) {
            if (isNegative) {
                result = Integer.parseInt(String.valueOf(number)) * -1;
            } else {
                result = Integer.parseInt(String.valueOf(number));
            }
        } else {
            if (isNegative) {
                result = minNumber;
            } else {
                result = maxNumber;
            }
        }
        return result;
    }

    public boolean isDigit(char character) {
        return character == '0' || character == '1' ||
                character == '2' || character == '3' ||
                character == '4' || character == '5' ||
                character == '6' || character == '7' ||
                character == '8' || character == '9' ;
    }

    public String removeInitialZeros(String word) {

        boolean isNegative = word.charAt(0) == '-';
        int index = isNegative ? 1:0;

        for (int i = (isNegative) ? 1:0 ; i < word.length(); i++) {

            if (!isNegative) {
                if (word.charAt(i) == '+') {
                    index++;
                    continue;
                }
            }


            if (word.charAt(i) != '0') {
                break;
            } else {
                if (!isNegative) {
                    removedZeros = true;
                }
                index++;
            }
        }
        if (isNegative && index > 0)  {
            return '-' + word.substring(index);
        } else {
            return word.substring(index);
        }
    }


    public int myAtoiOptimal(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();

        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') {
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions.
            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }

    public int myAtoiOptimizedTwo(String s) {
        s = s.trim();
        int size = s.length();
        int signed = -1;
        char c;
        int value = 0;
        long result = 0;
        boolean first = true;
        for (int i = 0; i < size; i++) {
            c = s.charAt(i);
            if (first && c == '+') {
                first = false;
            } else if (first && c == '-') {
                signed = 1;
                first = false;
            } else {
                first = false;
                value = c - '0';
                if (value >= 0 && value <= 9) {
                    result = result * 10 - value;
                    if (result <= Integer.MIN_VALUE) {
                        result = Integer.MIN_VALUE;
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        result *= signed;
        if (result >= Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;

        return (int) result;

    }
}
