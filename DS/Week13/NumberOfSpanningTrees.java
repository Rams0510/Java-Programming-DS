public class NumberOfSpanningTrees {
    static final int MOD = 1000000007;

    private long determinant(long[][] matrix, int size) {
        long det = 1;
        long[][] tempMatrix = new long[size][size];

        for (int i = 0; i < size; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, size);
        }

        for (int i = 0; i < size; i++) {
            if (tempMatrix[i][i] == 0) {
                int swapRow = i + 1;
                while (swapRow < size && tempMatrix[swapRow][i] == 0) {
                    swapRow++;
                }

                if (swapRow == size) {
                    return 0;
                }

                long[] tempRow = tempMatrix[i];
                tempMatrix[i] = tempMatrix[swapRow];
                tempMatrix[swapRow] = tempRow;

                det = -det;
            }

            for (int j = i + 1; j < size; j++) {
                if (tempMatrix[j][i] == 0) continue;

                long ratio = tempMatrix[j][i] / tempMatrix[i][i];
                for (int k = i; k < size; k++) {
                    tempMatrix[j][k] -= ratio * tempMatrix[i][k];
                }
            }

            det = (det * tempMatrix[i][i]) % MOD;
        }

        return (det + MOD) % MOD;
    }

    public long numOfSpanningTree(int[][] graph, int V) {
        long[][] laplacianMatrix = new long[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    int degree = 0;
                    for (int k = 0; k < V; k++) {
                        if (graph[i][k] == 1) degree++;
                    }
                    laplacianMatrix[i][j] = degree;
                } else if (graph[i][j] == 1) {
                    laplacianMatrix[i][j] = -1;
                } else {
                    laplacianMatrix[i][j] = 0;
                }
            }
        }

        long[][] reducedMatrix = new long[V - 1][V - 1];
        for (int i = 1; i < V; i++) {
            for (int j = 1; j < V; j++) {
                reducedMatrix[i - 1][j - 1] = laplacianMatrix[i][j];
            }
        }

        return determinant(reducedMatrix, V - 1);
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] graph = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 1 },
            { 1, 1, 0, 1 },
            { 1, 1, 1, 0 }
        };

        NumberOfSpanningTrees obj = new NumberOfSpanningTrees();
        System.out.println("Number of spanning trees: " + obj.numOfSpanningTree(graph, V));
    }
}
