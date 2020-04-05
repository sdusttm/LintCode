import java.util.Arrays;

public class WordDictionary {
    
    WordDictionary[] children = new WordDictionary[27];
    boolean isValid = false;
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        // write your code here
        char[] chars = word.toCharArray();
        WordDictionary node = this;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.children[index] == null) {
                node.children[index] = new WordDictionary();
            }
            
            node = node.children[index];
        }
        
        node.isValid = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        if (word == ".") {
            for (int i = 0; i < this.children.length; i++) {
                if (this.children[i] != null && this.children[i].isValid) {
                    return true;
                }
            }
            
            return false;
        }
        
        
        char[] chars = word.toCharArray();
        WordDictionary node = this;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                String subset = new String(Arrays.copyOfRange(chars, i + 1, chars.length));
                for (int j = 0; j < node.children.length; j++) {
                    if (node.children[j] != null && node.children[j].search(subset)) {
                        return true;
                    }
                }
                
                return false;
            } else {
                int index = chars[i] - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                
                node = node.children[index];
            }
        }
        
        return node.isValid;
    }
}