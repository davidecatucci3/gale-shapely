import java.util.Arrays;

public class Main {
    private int[][] apref;
    private int[][] ranking;
    private int[] next;
    private final int n;
    private int[] matchings;

    public Main(int[][] apref, int[][] ranking) {
        this.n = apref.length;

        // if the length of the two sets is not the same raise an error
        if (n != ranking.length) {
            System.out.println("Error: Lengths of arrays do not match");
        } else {
            this.apref = apref;
            this.ranking = ranking;
            this.next = new int[n];
            this.matchings = new int[n];

            // initialize all matches to unmatched
            Arrays.fill(matchings, -1);
        }
    }

    public boolean is_all_matched() {
        // check if there is an ai that is not matched in that case return false
        for (int i = 0; i < n; i++) {
            if (matchings[i] == -1) {
                return false;
            }
        }

        return true;
    }

    public int[][] run() {
        // until there are still matching to do continue
        while (!is_all_matched()) {
            int j = (n * 2) / apref[0].length;
            int[][] curr_matchings = new int[n][j];

            // each bi accept or refuse the ai proposal based on the rankings array
            for (int i = 0; i < n; i++) {
                if (matchings[i] == -1) { // if ai is unmatched
                    int k = next[i];

                    curr_matchings[i] = new int[]{i, apref[i][k] - 1};
                } else {
                    curr_matchings[i] = new int[]{i, -1};
                }
            }

            // each bi accept or refuse the ai proposal based on the rankings array
            for (int i = 0; i < n; i++) {
                if (curr_matchings[i][1] != -1) { // if there is a match
                    if (curr_matchings[i][0] == ranking[curr_matchings[i][1]][0] - 1) { // stable matching
                        for (int r = 0; r < n; r++) {
                            if (matchings[r] == curr_matchings[i][1]) {
                                matchings[r] = -1; // becomes free

                                next[i]++;
                            }
                        }

                        matchings[i] = curr_matchings[i][1];
                    } else { // refuse
                        boolean refused = false;

                        for (int r = 0; r < n; r++) {
                            if (matchings[r] == curr_matchings[i][1]) {
                                refused = true;

                                next[i]++;
                            }
                        }

                        if (!refused) {
                            matchings[i] = curr_matchings[i][1];
                        }
                    }
                }
            }
        }

        // format results as 1-based indices, its not part of the algorithm you can choose if use it or not
        int j = (n * 2) / apref[0].length;
        int[][] results = new int[n][j];

        for (int i = 0; i < n; i++) {
            results[i][0] = i + 1;
            results[i][1] = matchings[i] + 1;
        }

        return results;
    }
}


