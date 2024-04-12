package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutations {
    public static void main(String[] args) {

        int length = 1;
        int[] array = new int[]{1, 2, 3};
        Arrays.sort(array);
        List<List<Integer>> list = new ArrayList<>();
        List permutations = dfs(array, list, new ArrayList<>());
        permutations.stream().forEach(e -> System.out.println(e));
    }

    private static List dfs(int[] array, List<List<Integer>> list, List<Integer> permutations) {
        if (permutations.size() == array.length) {
            list.add(new ArrayList<>(permutations));
        }

        for (int i = 0; i < array.length; i++) {
            if (permutations.contains(array[i])) continue;
            permutations.add(array[i]);
            dfs(array, list, permutations);
            permutations.remove(permutations.size() - 1);
        }

        return list;
    }


}
