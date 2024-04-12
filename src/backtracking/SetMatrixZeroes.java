package backtracking;

public class SetMatrixZeroes {
    public static void main(String[] args) {

        int[][] board =
                {
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                };


//        int[][] board = {
//            {0,1,2,0},
//            {3,4,5,2},
//            {1,3,1,5}
//        };



        setZeroes(board);
    }

    public static void setZeroes(int[][] matrix) {
        boolean isZeroOnRow = false;
        boolean isZeroOnCol = false;


        for (int col = 0; col < matrix.length; col++) {
            if (matrix[0][col] == 0) {
                isZeroOnCol = true;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                isZeroOnRow = true;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row - 1][col] = 0;
                    matrix[row][col - 1] = 0;
                }
            }
        }


        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                int i = 1;
                while (i < matrix.length) {
                    matrix[i][col] = 0;
                    i++;
                }
            }
        }


        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                int j = 1;
                while (j < matrix[0].length) {
                    matrix[row][j] = 0;
                    j++;
                }
            }
        }

        if (isZeroOnRow) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }


        if (isZeroOnCol) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[0][col] = 0;
            }
        }

        System.out.println(matrix);

    }

//    public static void setZeroes(int[][] matrix) {
//
//        int [][] copy = Arrays.copyOf(matrix,matrix.length);
//
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                if (matrix[row][col] == 0) {
//
//
//
//
//
//
//
//                    updateMatrixWithZeroes(row, col, matrix, matrix.length, matrix[0].length
//                            , Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,copy);
//                    System.out.println(copy);
//                }
//            }
//        }
//
//    }
//
//
//    private static void updateMatrixWithZeroes(int row, int col, int[][] matrix,
//                                               int rowLength, int colLength,
//                                               boolean left, boolean right, boolean up, boolean down, int[][] copy) {
//
//        if(left&&right&&up&&down){
//            return;
//        }
//
//        if (row >= 0 && col >= 0 && row < rowLength && col < colLength) {
//
//            copy[row][col] = 0;
//
//            //right
//            if (right == false) {
//                updateMatrixWithZeroes(row, col + 1, matrix, rowLength, colLength, left, right, up, down, copy);
//            }
//            right = true;
//            //left
//            if (left == false) {
//                updateMatrixWithZeroes(row, col - 1, matrix, rowLength, colLength, left, right, up, down, copy);
//            }
//            left=true;
//            //up
//            if (up == false) {
//                updateMatrixWithZeroes(row - 1, col+1, matrix, rowLength, colLength, left, right, up, down, copy);
//            }
//            up =true;
//            //down
//            if (down == false) {
//                updateMatrixWithZeroes(row + 1, col, matrix, rowLength, colLength, left, right, up, down, copy);
//            }
//            down=true;
//        }
//
//    }
}
