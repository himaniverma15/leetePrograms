package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        Arrays.sort(array);
        List<List<Integer>> list = new ArrayList<>();
        List permutations = dfs(array, list, new ArrayList<>(), 3, new ArrayList<Integer>());
        permutations.stream().forEach(e -> System.out.println(e));

    }
    private static List dfs(int[] array, List<List<Integer>> list, List<Integer> permutations, int k, List l) {
        if (permutations.size() == k) {
            list.add(new ArrayList<>(permutations));
        }

        for (int i = 0; i < array.length; i++) {
            if (permutations.contains(array[i]) || permutations.size() == k || l.contains(array[i])) continue;
            permutations.add(array[i]);
            dfs(array, list, permutations, k, l);
            permutations.remove(permutations.size() - 1);
            if (permutations.size() == 0) {
                l.add(array[i]);
            }
        }

        return list;
    }


}
