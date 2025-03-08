import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        int[][] apref = {{4, 1, 2, 3}, {3, 1, 4, 2}, {3, 2, 4, 1}, {3, 2, 1, 4}};
        int[][] ranking =  {{2, 3, 4, 1}, {3, 1, 4, 2}, {2, 4, 3, 1}, {1, 4, 2, 3}};

        Main algo = new Main(apref, ranking);

        int[][] matchings = algo.run();

        System.out.println(Arrays.deepToString(matchings));
    }
}
