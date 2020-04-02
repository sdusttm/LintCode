public class LintCode590 {

    public static void main(String[] args) {
        ConnectingGraph2 cg = new ConnectingGraph2(10);
        cg.connect(1, 2);
        cg.connect(2, 3);
        int res = cg.query(1);
        System.out.print(res);
    }
}