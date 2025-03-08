import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        int[][] apref = {{3, 1, 2}, {3, 2, 1}, {1, 2, 3}}; // a1:b3>b1>b2, a2:b3>b2>b1 a3:b1>b2>b3
        int[][] ranking = {{3, 2, 1}, {2, 1, 3}, {1, 2, 3}}; // b1:a3>a2>a1, b2:a2>a1>a3 b3:a1>a2>a3

        Main algo = new Main(apref, ranking);

        int[][] matchings = algo.run();

        System.out.println(Arrays.deepToString(matchings));
    }
}
