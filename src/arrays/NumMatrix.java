package arrays;

import java.util.List;

import static java.util.Arrays.asList;

public class NumMatrix {
    static int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
    };

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

   static int[][] board = new int[matrix.length + 1][matrix[0].length + 1];

    public static void main(String[] args) {

        for (int row = 1; row < board.length; row++) {
            for (int col = 1; col < board[0].length; col++) {
                board[row][col] = board[row][col-1]+ (board[row-1][col]- board[row-1][col-1]) +matrix[row-1][col-1];
            }
        }

        List<List<Integer>> input = asList(asList(2, 1, 4, 3), asList(1, 1, 2, 2), asList(1, 2, 2, 4));
        input.stream().forEach(list -> {
            List<Integer> i = list;
            System.out.println(sumRegion(i.get(0), i.get(1), i.get(2), i.get(3)));
        });
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        return board[row2 + 1][col2 + 1] - board[row1][col2 + 1]
                - board[row2 + 1][col1] + board[row1][col1];
    }
}
