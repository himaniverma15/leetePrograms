package backtracking;

import java.util.*;

public class MaximumLengthConcatenatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        List arr = Arrays.asList("abcdefghijklmnopqrstuvwxyz");
        maxLength(arr);
    }

    public static int maxLength(List<String> arr) {
        List<String> combinations = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            combination(i, i+1, 0, combinations, arr);
        }
        System.out.println(combinations);
        return 0;
    }

    public static void combination(int start, int next, int index, List<String> combinations,
                                   List<String> arr) {
        if(next >= arr.size()) return;

        if (arr.get(start).length() == index) {
            combinations.add(arr.get(start).concat(arr.get(next)));
            index = 0;
            next = next + 1;
        }

        if (next < arr.size() && !arr.get(next).contains(new Character(arr.get(start).charAt(index)).toString()))
            combination(start, next, index + 1, combinations, arr);
        else combination(start, next+1, 0, combinations, arr);
    }
}


