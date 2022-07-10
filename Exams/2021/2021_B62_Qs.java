public class E2021_B62_Qs{
    //Q1
    public static boolean equalsSplit(int[] arr){
        if(arr.length <1 || !(arr.length / 2 != 0))
            return false;
        return equalsSplit(arr,0,0,0,0,0);
    }

    private static boolean equalsSplit(int[] arr, int i, int sum1, int sum2, int l1, int l2) {
        if(i == arr.length){
            if(sum1 == sum2 && l1 == l2 && l1 == arr.length/2)
                return true;
            return false;
        }
        return equalsSplit(arr, i+1, sum1+arr[i], sum2, l1+1, l2) || equalsSplit(arr, i+1, sum1, sum2+arr[i], l1, l2+1);
    }
    public static int maxPath(int [][] mat){
        return maxPath(mat,0,0,0);
    }
    private static int maxPath(int[][] mat, int i, int j, int sum){
        if(i == mat.length || j == mat[0].length)
            return Integer.MAX_VALUE;
        if(i == mat.length-1 && j == mat[0].length -1)
            return mat[i][j] + sum;
        int stp1 = mat[i][j] / 10, stp2 = mat[i][j]%10;
        
        int opt1 = maxPath(mat, i+stp1, j+stp2, sum + mat[i][j]);
        int opt2= maxPath(mat, i+stp2, j+stp1, sum + mat[i][j]);

        return Math.max(opt1, opt2);

    }
    public static void main(String[] args) {
        int[] arr = {-3,5,-12,14,-9,13};
        System.out.println(equalsSplit(arr));
        System.out.println(2);
    }
}
