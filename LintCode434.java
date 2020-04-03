public class LintCode434 {

    public static void main(String[] args) {
        Islands2 island = new Islands2();
        island.numIslands2(1, 1, new Point[0]);
        island.numIslands2(4, 5, new Point[] {new Point(1, 1), new Point(0, 1), new Point(3, 3), new Point(3, 4)});
    }   
}