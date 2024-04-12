import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String[] words = new String[]{"ab","ba","ba"};
        System.out.println(findSubstring("ababaab", words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> integerList = new ArrayList<>();

        int sizeOfWord = words.length * words[0].length();
        int i = 0;

        Map<String, Integer> count = new HashMap<>();

        for (final String word : words)
            count.merge(word, 1, Integer::sum);

        while (i <= s.length() - sizeOfWord) {

            String str = s.substring(i, i + sizeOfWord);

            Map<String, Integer> seen = new HashMap<>();

            int k =0;

            while(k <= str.length()-words[0].length()){
                String l = str.substring(k, k+words[0].length());
                seen.merge(l, 1, Integer::sum);
                k+=words[0].length();
            }

            boolean b = false;
            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                Integer occurence = seen.get(key);
                if (value == occurence) {
                    b = true;
                } else{
                    b = false;
                    break;
                }
            }

            if(b == true){
                integerList.add(i);
            }

            ++i;
        }
        return integerList;
    }
}
