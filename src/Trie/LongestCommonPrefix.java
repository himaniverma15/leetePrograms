package Trie;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        TrieNode root = new TrieNode();

        for (String s : strs) {

            if(s.length()== 0){
                return "";
            }

            TrieNode current = root;
            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                TrieNode node = current.childerns.get(c);

                if (node == null) {

                    node = new TrieNode();

                    current.childerns.put(c, node);

                }

                current = node;
            }

            root.endOfString = true;
        }


        StringBuilder longestPrefix = new StringBuilder();


        while (root.childerns.size() == 1) {
            Character ch = root.childerns.keySet().stream().findFirst().get();
            longestPrefix.append(ch);
            root = root.childerns.get(ch);
        }


        return longestPrefix.toString();
    }
}
