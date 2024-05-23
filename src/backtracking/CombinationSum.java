package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private static void dfs(int s, int[] candidates, int target, List<Integer> path,
                     List<List<Integer>> ans) {
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < candidates.length; ++i) {
            path.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], path, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = new int[]{2,3,6,7};
        System.out.println(combinationSum(candidates,7));
    }
}
