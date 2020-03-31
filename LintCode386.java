public class LintCode386 {

    public static void main(String[] args) {
        int res = lengthOfLongestSubstringKDistinct("dafafsfsafwefassaf", 5);
        System.out.print(res);
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (k == 0 || s == "") {
            return 0;
        }

        // write your code here
        int i = 0, j = 0;
        char[] sArr = s.toCharArray();
        int[] map = new int[256];
        int len = 0;
        int res = 0;

        while (j < sArr.length) {
            while (j < sArr.length && (len < k || map[sArr[j]] > 0)) {
                map[sArr[j]]++;
                if (map[sArr[j]] == 1) {
                    len++;
                }
                j++;
            }

            if (len == k) {
                res = j - i > res ? j - i : res;
            } else { // len < k
                res = sArr.length;
            }

            while (i < j && len >= k) {
                map[sArr[i]]--;
                if (map[sArr[i]] == 0) {
                    len--;
                }
                i++;
            }
        }

        return res;
    }
}