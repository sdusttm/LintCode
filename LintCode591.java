public class LintCode591 {

    public static void main(String[] args) {
        ConnectingGraph3 cg = new ConnectingGraph3(10);
        cg.query();
        cg.connect(1, 2);
        cg.query();
        cg.connect(2, 4);
        cg.query();
        cg.connect(1, 4);
        cg.query();
        int res = cg.query();
        System.out.print(res);
    }
}