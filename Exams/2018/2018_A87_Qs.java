public class 2018_A87_Qs{ 

    //Q1
    public static int longSlope(int[][] mat, int num){
        return longSlope(mat,num,0,0,0);
    }

    private static int longSlope(int[][] mat, int num, int i, int j, int count) {
        if(i == mat.length)
            return count;
        if(j == mat[0].length)
            return longSlope(mat, num, i+1, 0, count);
        int tmpCount = longSlope(num,mat,i,j,(mat[i][j] + num));
        if(tmpCount > count)
            count = tmpCount;
        return longSlope(mat, num, i, j+1, count);
    }

    private static int longSlope(int num, int[][] mat, int i, int j, int pre) {
        if(i == mat.length || j == mat[0].length || i < 0 || j < 0 || mat[i][j] == Integer.MAX_VALUE)
            return 0;
        if(pre - mat[i][j] == num){
            int tmp = mat[i][j];
            mat[i][j] = Integer.MAX_VALUE;

            int down = longSlope(num, mat, i+1, j, tmp) + 1;
            int up = longSlope(num, mat, i-1, j, tmp) + 1;
            int right = longSlope(num, mat, i, j+1, tmp) + 1;
            int left = longSlope(num, mat, i, j-1, tmp) + 1;

            mat[i][j] = tmp;

            return Math.max(Math.max(up, down), Math.max(right, left));
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] mat = {
            {3,13,15,28,30},
            {55,54,53,27,26},
            {54,12,52,51,50},
            {50,10,8,53,11}};

        System.out.println(longSlope(mat, 1));
    }
    
}
