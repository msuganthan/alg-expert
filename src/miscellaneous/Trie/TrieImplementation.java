package miscellaneous.Trie;

public class TrieImplementation {

    private TrieNode root;

    TrieImplementation() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    boolean match(char[] chars, int n, TrieNode node) {
        if (n == chars.length)
            return node.isWord;

        int charIndex = chars[n] - 'a';
        return node.children[charIndex] != null && match(chars, n + 1, node.children[charIndex]);
    }



    static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }

    public static void main(String[] args) {
        TrieImplementation trie = new TrieImplementation();
        trie.insert("apple");
        trie.insert("abc");

        System.out.println(trie.search("abc"));
    }
}
