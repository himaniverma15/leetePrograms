package matrix;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        exist(board, "ABCCED");
        exist(board, "ABCB");
        exist(board,"SEE");
    }

    public static boolean exist(char[][] board, String words) {

        int rowLength = board.length;
        int colLength = board[0].length;
        boolean isWordExist = false;
        int index = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (board[row][col] == words.charAt(index)) {
                   if(searchWord(board, words, row, col, new StringBuffer(), index, rowLength, colLength)) {
                     isWordExist= true;
                     break;
                   }
                }
            }
        }
        System.out.println("isWordExist : " + isWordExist);
        return isWordExist;
    }
    private static boolean searchWord(char[][] board, String words, int row, int col, StringBuffer sWord,
                                      int index, int rowLength, int colLength) {

        if (index == words.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || index >= words.length() || board[row][col] != words.charAt(index) ||
                board[row][col]==1) {
            index -= 1;
            return false;
        }

        board[row][col] =1;
        index += 1;

        boolean isExist =
                //search right
                searchWord(board, words, row, col + 1, sWord, index, rowLength, colLength) ||
                        //search down
                        searchWord(board, words, row + 1, col, sWord, index, rowLength, colLength) ||
                        //search left
                        searchWord(board, words, row, col - 1, sWord, index, rowLength, colLength) ||
                        //search up
                        searchWord(board, words, row - 1, col, sWord, index, rowLength, colLength);


        return isExist;
    }
}
