package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestValidParentheses {
    public static void main(String[] args) {

        System.out.println(longestValidParentheses(")()())()()("));
    }
    public static int longestValidParentheses(String s) {

        List<Integer> longestValidParentheses =new ArrayList<>();

        List<Character> list = new ArrayList<>();


        for(int j =0 ; j< s.length();j++){
            int open =0 , close =0 , sIndex = 0 , endIndex=0;  int tos = -1;
            for(int i =j ; i < s.length() ; i++){

                char c = s.charAt(i);

                if(c == '('){
                    tos+=1; open+=1;
                    list.add(c);

                }else {
                    if(tos !=-1){
                        if(close < open){
                            tos+=1; close+=1;
                            list.add(c);
                            if(open==close){
                                longestValidParentheses.add(tos+1);
                            }
                        }else {
                            longestValidParentheses.add(tos+1);
                            break;
                        }
                    }
                }

            }
        }

        Collections.sort(longestValidParentheses);
        return longestValidParentheses.size()>0 ? longestValidParentheses.get(longestValidParentheses.size()-1) : 0;
    }
}
