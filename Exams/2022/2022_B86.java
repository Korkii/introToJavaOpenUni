public class E2022_B86_Qs{
//Q1
    public static int maxPath(int [][] mat){
        return maxPath(mat,0,0,0);
    }
    private static int maxPath(int[][] mat, int i, int j, int sum){
        if(i >= mat.length || j >= mat[0].length)
            return Integer.MAX_VALUE;
        if(i == mat.length-1 && j == mat[0].length -1)
            return mat[i][j] + sum;
        int stp1 = mat[i][j] / 10, stp2 = mat[i][j]%10;
        
        int opt1 = maxPath(mat, i+stp1, j+stp2, sum + mat[i][j]);
        int opt2= maxPath(mat, i+stp2, j+stp1, sum + mat[i][j]);

        return Math.max(opt1, opt2);

    }
  
    //Q2
    // Time complexity: O(n)
    // Space complexity: O(1)

    // Time complexity is actually O(n*k), but k is constant.
    public static void sortmod(int[] a, int k){

        int newIndex = 0;

        for(int mod = 0; mod < k; mod++){

            for (int i = newIndex; i < a.length ; i++) {

                if(a[i] % k == mod){

                    // Swaps between both elements.
                    int tempVal = a[newIndex];
                    a[newIndex] = a[i];
                    a[i] = tempVal;

                    newIndex++;
                }
            }
        }
    }


    public static void main(String[] args){

        int[] a = {35,17,13,252,4,128,7,3,81};
        int[] expected  = {81,252,13,3,4,35,17,7,128};

        sortmod(a,10);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("received: " + Arrays.toString(a));
    }
  
}
