package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permute;
        for (int i = 1; i < n; i++) {
            permute = new ArrayList<>();
            permute.add(i);
            combinations(i, n, k, permute, permutations, i + 1);
        }
        return permutations;
    }

    private static List<List<Integer>> combinations(int i, int n, int k,
                                                    List<Integer> permute, List<List<Integer>> permutations, Integer numb) {
        permute.add(numb++);

        if (permute.size() == k) {
            permutations.add(permute);
            permute = new ArrayList<>();
            permute.add(i);
        }

        if (numb > n) {
            return permutations;
        }

        combinations(i, n, k, permute, permutations, numb);

        return permutations;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = combine(4, 2);
        list.stream().forEach(e -> System.out.println(e));
    }
}
