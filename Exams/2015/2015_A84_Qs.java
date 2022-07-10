public class E2015_A84_Qs {
    public static int countRope(int[][]mat){
        return countRope(mat,0,0,-1);
    }

    private static int countRope(int[][]mat, int i, int j ,int pre){
        if(i == mat.length || j == mat[0].length || i <0 || j < 0)
            return 0;
        if(mat[i][j] >= pre && pre != -1)
            return 0;
        if(i == mat.length-1)
            return 1;
        int count = countRope(mat,i+1,j,mat[i][j]) + countRope(mat,i+1,j-1,mat[i][j]) + countRope(mat,i+1,j+1,mat[i][j]);

        if(i == 0)
            return count + countRope(mat,i,j+1,-1);
        return count;
    }


    public static boolean splitT03(int[] arr){
        int sum = 0;
        for(int i = 0; i< arr.length;i++){
            sum += arr[i];
        }

        int lim1 = 0, lim2 = arr.length-1, sum1 = 0, sum2 = 0, sum3 = 0;
        while(lim1 < lim2){
            sum3 = sum - (sum1 + sum2);
            if(sum3 == 0 && sum1 <= 0 && sum2 >= 0)
                return true;
            else if(sum3 > 0)
                sum2 += arr[lim2--];
            else if(sum3 < 0)
                sum1 += arr[lim1++];
            else{
                sum2 += arr[lim2--];
                sum1 += arr[lim1++];
            } 
            

        }
            return false;
        
    }
}
