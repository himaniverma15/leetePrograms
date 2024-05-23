package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SplittingStringIntoDescendingConsecutiveValues {
    public static void main(String[] args) {
        splitString("050043");
    }

    public static boolean splitString(String s) {
        List<Integer> permutations = new ArrayList<>();
        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if ((s.charAt(i) - '0') != 0) {
                permutations.add(Integer.parseInt(sb.toString()));

                if (permutations.size() > 1) {

                    int previous = permutations.get(permutations.size() - 2);
                    int current = permutations.get(permutations.size() - 1);

                    if (current < previous && previous -current == 1) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
                sb = new StringBuffer();
            }
        }
        System.out.println(flag);
        return flag;
    }


    private static boolean dfs(String s, int index, List<Integer> permutations,
                               StringBuffer stringBuffer, int previous, boolean flag) {

//        if (Integer.parseInt(new Character(s.charAt(index)).toString()) != 0 ) {
//            permutations.add(stringBuffer.toString());
//            if(permutations.size() == 0){
//                permutations.add(stringBuffer.toString());
//            }else{
//                permutations.add(stringBuffer.toString());
//                if(Integer.parseInt(permutations.get(permutations.size())) < Integer.parseInt(permutations.get(permutations.size()-1))){
//                    flag = true;
//                }
//            }
//            return flag;
//        }

        if ((s.charAt(index) - '0') != 0 && s.length() - 1 != index) {
            //  stringBuffer.append( (s.charAt(index)));
            permutations.add(Integer.parseInt(stringBuffer.toString()));
            System.out.println(permutations);
        }


        dfs(s, index + 1, permutations, stringBuffer.append(s.charAt(index + 1)), 0, flag);
        return flag;
    }
}
