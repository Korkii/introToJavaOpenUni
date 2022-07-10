public static int howManyPaths(int[][] mat){
        return howManyPaths(mat,mat[0][0],0,0);
    }

    private static int howManyPaths(int[][] mat, int k, int i ,int j){

        if(i > mat.length - 1 || i < 0 || j > mat[0].length - 1 || j < 0 || mat[i][j] == 0){
            return 0;
        }

        if(i == mat.length - 1 && j == mat[0].length - 1){
            return 1;
        }

        k = mat[i][j];
        mat[i][j] = 0;

        int up = howManyPaths(mat,k,i - k, j);
        int down = howManyPaths(mat,k,i + k, j);
        int left = howManyPaths(mat,k,i, j - k);
        int right = howManyPaths(mat,k,i, j + k);

        mat[i][j] = k;

        return up+down+left+right;

    }
