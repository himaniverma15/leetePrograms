package backtracking;

import Trie.TrieNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class WordSearch2 {
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
         String[] words = {"oath","oathf", "pea", "eat", "rain"};
//        String[] words = {"oath", "oathf"};
        System.out.println(findWords(board, words));
    }

    private static List<String> findWords(char[][] board, String[] words) {
        List<String> wordInGrid = new ArrayList<>();

        TrieNode trieNode = storeWordsInTrie(words);
        Boolean isAdded = true;


        trieNode.childerns.forEach((character, node) -> {
            StringBuilder word;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {

                    word = new StringBuilder();
                    if (board[row][col] == character) {
                        if (searchWord(row, col, node, word, board, character,wordInGrid)) {
                            wordInGrid.add(word.toString());
                        }

                    }
                }
            }
        });
        return wordInGrid;
    }

    private static boolean searchWord(int row, int col, TrieNode node, StringBuilder word, char[][] board, Character character, List<String> wordInGrid) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 1 || board[row][col] != character) {
            return false;
        }

        word.append(board[row][col]);

        if (node.endOfString == true) {
            node.endOfString = false;
            return true;
        }

      //  board[row][col] = 1;

        AtomicBoolean isExist = new AtomicBoolean(false);
        node.childerns.forEach(((character1, trieNode) -> {
            //search right
            isExist.set(searchWord(row, col + 1, trieNode, word, board, character1, wordInGrid) ||
                    //search down
                    searchWord(row + 1, col, trieNode, word, board, character1, wordInGrid) ||
                    //search left
                    searchWord(row, col - 1, trieNode, word, board, character1, wordInGrid) ||
                    //search up
                    searchWord(row - 1, col, trieNode, word, board, character1, wordInGrid));
        }));

        return isExist.get();
    }

    private static TrieNode storeWordsInTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode currentNode = root;
            for (int index = 0; index < word.length(); index++) {
                char ch = word.charAt(index);
                TrieNode newNode = currentNode.childerns.get(ch);
                if (newNode == null) {
                    newNode = new TrieNode();
                }
                currentNode.childerns.put(ch, newNode);
                currentNode = newNode;
            }
            currentNode.endOfString = true;
        }
        return root;
    }
}
