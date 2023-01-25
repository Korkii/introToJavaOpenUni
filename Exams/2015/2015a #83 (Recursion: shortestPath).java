public static int shortestPath(int[][] mat) {
        return shortestPath(mat, 0, 0, 0);
    }

    public static int shortestPath(int[][] mat, int prev, int i, int j) {

        if (i < 0 || i > mat.length - 1 || j < 0 || j > mat[0].length - 1 || mat[i][j] <= prev || mat[i][j] == 0) {
            return Integer.MAX_VALUE;
        }

        if (i == mat.length - 1 && j == mat[0].length - 1) {
            return 1;
        }

        int value = mat[i][j];
        mat[i][j] = 0;

        int up = shortestPath(mat, value, i - 1, j);
        int down = shortestPath(mat, value, i + 1, j);
        int right = shortestPath(mat, value, i, j + 1);
        int left = shortestPath(mat, value, i, j - 1);

        mat[i][j] = value;


        int shortest = Math.min(Math.min(up, down), Math.min(left, right));
        if (shortest == Integer.MAX_VALUE)
            return shortest;

        return 1 + shortest;

    }
