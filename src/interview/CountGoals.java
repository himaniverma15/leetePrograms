package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class CountGoals {
    public static List<Integer> countGoals(int[] teamA, int[] teamB) {
        Arrays.sort(teamA);
        Arrays.sort(teamB);

        List<Integer> counts = new ArrayList<>();
        int j = 0;

        for (int goalsB : teamB) {
            while (j < teamA.length && teamA[j] <= goalsB) {
                j++;
            }
            counts.add(j);
        }

        return counts;
    }

    public static void main(String[] args) {
        System.out.println(countGoals(new int[]{1, 3, 4, 2}, new int[]{3, 5}));
    }

}


