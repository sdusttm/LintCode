public class Trie {
    Trie[] children= new Trie[26];
    boolean isValid = false;
    String word = null;
    
    public Trie() {
        // do intialization if necessary
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        char[] chars = word.toCharArray();
        Trie node = this;
        for(int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            
            node = node.children[index];
        }
        
        node.isValid = true;
        node.word = word;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        char[] chars = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            if (node.children[index] == null) {
                return false;
            } else {
                node = node.children[index];
            }    
        }    
        
        return node.isValid;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        char[] chars = prefix.toCharArray();
        Trie node = this;
        for (int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            if (node.children[index] == null) {
                return false;
            } else {
                node = node.children[index];
            }    
        }    
        
        return true;
    }
}