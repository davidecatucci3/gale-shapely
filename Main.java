public class Main {
    private int[][] apref;
    private int[][] ranking;
    private final int n1;
    private int n_matchings;
    private int[][] matchings;

    public Main(int[][] apref, int[][] ranking) {
        // if the length of the two sets is not the same raise an error
        n1 = apref.length;
        int n2 = ranking.length;

        if (n1 != n2) {
            System.out.println("Error: Lengths of arrays do not match");
        } else {
            this.apref = apref;
            this.ranking = ranking;
            this.n_matchings = 0;
            this.matchings = new int[n1][(n1 * 2) / apref[0].length];

            // initialize all matches to unmatched (-1)
            for (int i = 0; i < n1; i++) {
                matchings[i] = new int[] {i, -1};
            }
        }
    }

    public boolean is_all_matched() {
        return n_matchings == n1;
    }

    public int[][] run() {
        int k = 0;

        // until there are still matching to do continue
        while (!is_all_matched()) {
            // each ai that is unmatched makes proposal to his best preference
            int j = (n1 * 2) / apref[0].length;
            int[][] curr_matchings = new int[n1][j];

            for (int i = 0; i < n1; i++) {
                if (matchings[i][1] == -1) { // if ai is unmatched
                    curr_matchings[i] = new int[]{i, apref[i][k] - 1};
                } else {
                    curr_matchings[i] = new int[]{-1, -1};
                }
            }

            // each bi accept or refuse the ai proposal based on the rankings array
            for (int i = 0; i < n1; i++) {
                if (curr_matchings[i][0] != -1) { // if ai is unmatched
                    if (curr_matchings[i][0] == ranking[curr_matchings[i][1]][0] - 1) {
                        matchings[i] = new int[]{i, curr_matchings[i][1]};

                        n_matchings++;
                    }
                }
            }

            k++;
        }

        return matchings;
    }
}


