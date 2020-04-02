public class LintCode589 {

    public static void main(String[] args) {
        ConnectingGraph cg = new ConnectingGraph(10);
        cg.connect(1, 2);
        cg.connect(2, 3);
        boolean res = cg.query(1, 3);
        System.out.print(res);
    }
}