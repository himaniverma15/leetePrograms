package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "dvdf";
        int length = lengthOfLongestSubstring(str);
        System.out.println(length);
    }
    public static int lengthOfLongestSubstring(String s) {

        if(s.length()==0){
            return 0;
        }else if (s.length()==1){
            return 1;
        }

        int substringLength = 0;
        StringBuffer stringBuffer = new StringBuffer();
        Map<Integer,String> map = new HashMap<>();

        for(int i =0 ; i< s.length(); i++){

            stringBuffer.append(s.charAt(i));

            for(int j = i+1 ; j< s.length(); j++){

                char c = s.charAt(j);
                if(!stringBuffer.toString().contains(Character.toString(c))){
                    stringBuffer.append(Character.toString(c));
                    if(j==s.length()-1){
                        if(substringLength < stringBuffer.length()){
                            map.remove(substringLength);
                            map.put(stringBuffer.length(),stringBuffer.toString());
                            substringLength = stringBuffer.length();
                        }
                        stringBuffer = new StringBuffer();
                    }
                }else{
                    if(substringLength < stringBuffer.length()){
                        map.remove(substringLength);
                        map.put(stringBuffer.length(),stringBuffer.toString());
                        substringLength = stringBuffer.length();
                    }
                    stringBuffer = new StringBuffer();
                    if(j != s.length()-1){
                        stringBuffer.append(c);
                    }
                }
            }
        }
        return map.keySet().stream().findFirst().get();
    }
}
