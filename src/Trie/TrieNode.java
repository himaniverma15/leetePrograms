package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public Map<Character,TrieNode> childerns ;
    public boolean endOfString;

    public TrieNode() {
        this.childerns = new HashMap<>();
        this.endOfString = false;
    }
}
