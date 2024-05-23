//package backtracking;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RatInMaze {
//
//    public static void main(String[] args) {
//
//        int[][] board = {{1, 0, 0, 0},
//                {1, 1, 0, 1},
//                {1, 1, 0, 0},
//                {0, 1, 1, 1}};
//
//        way(0, 0, board, ' ', new StringBuilder(), new ArrayList<>());
//
//    }
//
//    public static void way(int row, int col, int[][] board, char direction, StringBuilder sb, List<String> combination) {
//
//        if (row == board.length - 1 && col == board[0].length - 1) {
//            combination.add(sb.toString());
//            return;
//        }
//
//        boolean isValid = row < 0 || col < 0 || row > board.length - 1 || col > board[0].length;
//        if(){
//
//        }
//
//        //right
//        if (!isValid && board[row][col] == 1) {
//            board[row][col] = 0;
//         //   sb = board[row][col+1]!=0 ? sb.append('R') : sb.append("");
//            way(row, col + 1, board, 'R',sb, combination);
//            board[row][col] = 1;
//
//        }
//
//
//        //down
//        if (!isValid && board[row][col] == 1) {
//            board[row][col] = 0;
//        //    sb = board[row+1][col]!=0 ? sb.append('D') : sb.append("");
//            way(row + 1, col, board, 'D', sb, combination);
//            board[row][col] = 1;
//
//        }
//
//        //left
//        if (!isValid && board[row][col] == 1) {
//            board[row][col] = 0;
//          //  sb = board[row][col-1]!=0 ? sb.append('L') : sb.append("");
//            way(row, col - 1, board, 'L', sb, combination);
//            board[row][col] = 1;
//
//        }
//
//        //up
//        if (!isValid && board[row][col] == 1) {
//            board[row][col] = 0;
//         //   sb = board[row][col+1]!=0 ? sb.append('U') : sb.append("");
//            way(row , col+1, board, 'U', sb, combination);
//            board[row][col] = 1;
//        }
//
//    }
//}
