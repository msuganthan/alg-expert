package algo_expert.dynamicProg;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            cost[0][i] = i;

        for (int i = 0; i <= n; i++)
            cost[i][0] = i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];

                else {
                    int a = cost[i][j];
                    int b = cost[j][i + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = Math.min(a,Math.min(b,c));
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];

    }
}
