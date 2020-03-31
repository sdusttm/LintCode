import java.util.Arrays;

public class LintCode29 {

    public static void main(String[] args) {
        boolean res = isInterleave("sdfjas;dfjoisdufzjkndfasdkfja;sdfa;dfa;dfaskdjhfasdhjdfakhdgfkajdfasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfhakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh",
        "dfnakdjnfjkzghdufguweygfasjkdfgb2gf8asf7tgbgasjkdfgasodf7asdgfajksdfguayfgaogfsdkagfsdhfajksdvfbgkadsghfakdsfgasduyfgajsdkfgajkdghfaksdgfuyadgfasjkdvfjsdkvfakfgauyksgfajkefgjkdasgfdjksfgadjkghfajksdfgaskdjfgasjkdgfuyaegfasdjkfgajkdfygadjskfgjkadfg",
        "sdfjas;dfjoisdfnakdjnfjkzghdufguwdufzjkeygfasjkdfgb2gf8asf7ndtgbgasjkdfgasodf7asdfgfajkasdksdfguayfgaogfsdkagfsfjadhfajksdvfbgkadsghfa;sdkdsfgasduyfgajsdkfgafajkdghfaksdgfuyadgfas;dfjkdvfjsdkvfakfgauyksa;dgfajkefgjkdasgfdjksffaskdjhfasdhjdfakhdgadjkghfajgfkajdfksdfgaskdjfgasjkdgfuasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfyaegfasdjkfgajkdfygadjskfgjkadfghakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh");
        System.out.print(res);
    }

    // this does not pass the above test case, reason unkown yet.
    public static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1.equals("")) {
            return s2.equals(s3);
        }
       
        if (s2.equals("")) {
            return s1.equals(s3);
        }
       
        if (s3.equals("")) {
            return s1.equals("") && s2.equals("");
        }
       
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        char[] a3 = s3.toCharArray();
       
        // not necessary but an optimization
        if (a1.length + a2.length != a3.length) {
            return false;
        }
       
        if (a1[0] == a2[0] && a2[0] != a3[0]) {
            return false;
        }
       
        if (a1[a1.length - 1] == a2[a2.length - 1] && a2[a2.length - 1] != a3[a3.length - 1]) {
            return false;
        }
       
        while (a1.length > 0 && a2.length > 0 && a3.length > 0 && a1[0] != a2[0]) {
            if (a1[0] != a3[0] && a2[0] != a3[0]) {
                return false;
            }

            if (a1[0] == a3[0]) {
                a1 = Arrays.copyOfRange(a1, 1, a1.length);
                a3 = Arrays.copyOfRange(a3, 1, a3.length);
            } else if (a2[0] == a3[0]) {
                a2 = Arrays.copyOfRange(a2, 1, a2.length);
                a3 = Arrays.copyOfRange(a3, 1, a3.length);
            }
        }

        while (a1.length > 0 && a2.length > 0 && a3.length > 0 && a1[a1.length - 1] != a2[a2.length - 1]) {
            if (a1[a1.length - 1] != a3[a3.length - 1] && a2[a2.length - 1] != a3[a3.length - 1]) {
                return false;
            }

            if (a1[a1.length - 1] == a3[a3.length - 1]) {
                a1 = Arrays.copyOfRange(a1, 0, a1.length - 1);
                a3 = Arrays.copyOfRange(a3, 0, a3.length - 1);
            } if (a2[a2.length - 1] == a3[a3.length - 1]) {
                a2 = Arrays.copyOfRange(a2, 0, a2.length - 1);
                a3 = Arrays.copyOfRange(a3, 0, a3.length - 1);
            }
        }
       
        if (a1.length == 0 || a2.length == 0 || a3.length == 0) {
            return isInterleave(new String(a1), new String(a2), new String(a3));
        } else {
            return isInterleave(new String(a1), new String(Arrays.copyOfRange(a2, 1, a2.length)), new String(Arrays.copyOfRange(a3, 1, a3.length))) || isInterleave(new String(Arrays.copyOfRange(a1, 1, a1.length)), new String(a2), new String(Arrays.copyOfRange(a3, 1, a3.length)));
        }
    }
}