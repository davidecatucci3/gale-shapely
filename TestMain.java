import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        int[][] apref = {{2, 4, 1, 3}, {1, 3, 4, 2}, {1, 3, 2, 4}, {2, 1, 4, 3}};
        int[][] ranking =  {{1, 4, 2, 3}, {4, 2, 1, 3}, {1, 4, 3, 2}, {2, 4, 1, 3}};

        Main algo = new Main(apref, ranking);

        int[][] matchings = algo.run();

        System.out.println(Arrays.deepToString(matchings));
    }
}
