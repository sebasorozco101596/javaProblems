package medium;

// 38. Count and Say
public class CountAndSay {
    public String countAndSay(int n) {
        return countAndSayRecursive(n,1,"1");
    }

    private String countAndSayRecursive(int n, int repetition, String output) {

        StringBuilder result = new StringBuilder();
        int pointer = 0;
        int duplicates = 0;
        char lastChar = output.charAt(pointer);

        if (repetition == n) {
            return output;
        }

        while (pointer < output.length()) {

            if (output.charAt(pointer) != lastChar) {
                result.append(duplicates);
                result.append(lastChar);
                lastChar = output.charAt(pointer);
                duplicates = 0;
            }
            duplicates++;
            pointer++;
        }

        if (duplicates > 0) {
            result.append(duplicates);
            result.append(lastChar);
        }

        return countAndSayRecursive(n,repetition + 1, result.toString());
    }

    public String countAndSayOptimal(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }

    public String countIdx(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
