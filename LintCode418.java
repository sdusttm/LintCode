public class Solution {
    /**
     * @param n: The integer
     * @return: Roman representation
     */
    public String intToRoman(int n) {
        // write your code here
        return getRomanDigit(n/1000, "M", "", "") + getRomanDigit(n%1000/100, "C", "D", "M") + getRomanDigit(n%1000%100/10, "X", "L", "C") + getRomanDigit(n%1000%100%10, "I", "V", "X");
    };
    
    public String getRomanDigit(int n, String low, String medium, String high) {
        String out = "";
        if (n <= 3) {
            for (int i = 0; i < n; i++) {
                out += low;
            }
            return out;
        } else if (n == 4) {
            return low + medium;
        } else if (n == 5) {
            return medium;
        } else if (n <= 8) {
            out = medium;
            for(int i=5; i < n; i++) {
                out += low;
            }
            return out;
        } else if (n==9) {
            return low + high;
        } else {
            return "";
        }
    }
}