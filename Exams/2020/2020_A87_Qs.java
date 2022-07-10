public class 2020_A87_Qs{
    //Q1
    public static int totalWays(int[][] mat, int k){
        return totalWays(mat,k,0,0,'E');
    }

    private static int totalWays(int[][] mat, int k, int i, int j, char c) {
        if(i == mat.length || j == mat[0].length || k < 0){
            return 0;}
        if(i == mat.length-1 && j == mat[0].length-1){
            if(k == 0)
                return 1;
            return 0;
        }
        int spt1;
        if(c == 'D')
            spt1 = totalWays(mat, k, i+1, j, 'D') + totalWays(mat, k-1, i, j+1, 'L');
        else if(c == 'L')
            spt1 = totalWays(mat, k-1, i+1, j, 'D') + totalWays(mat, k, i, j+1, 'L');
        else   // fot the first step
            spt1 = totalWays(mat, k, i+1, j, 'D') + totalWays(mat, k, i, j+1, 'L');
        return spt1;
    }

    //Q2
    public static void printTripels(int[] arr, int num){
        if(arr.length < 3)
            return;
        
        int a = 0, b = 1, c = arr.length-1;
        int sum = 0;
        for(;b< arr.length-2;a++){
            b = a+1;
            c=arr.length-1;
            while(b<c){
                sum = arr[a]*arr[b]*arr[c];
                if(sum == num){
                    System.out.println(arr[a] + "*" + arr[b] + "*" + arr[c] + " = " + num);
                    b++;
                    c--;
                }
                else if(sum < num)
                    b++;
                else    
                    c--;
            }
        }

    }

    public static void main(String[] args) {
        //Q1 Tester 
        int[][] mat = new int[3][3];
        System.out.println(totalWays(mat, 1));//Shoule be 2
        System.out.println(totalWays(mat, 2));//Shoule be 2
        System.out.println(totalWays(mat, 3));//Shoule be 2
        System.out.println(totalWays(mat, 4));//Shoule be 0

        //Q2 Tester
        int[] arr = {1,2,3,4,5,6,7,8,9};
        printTripels(arr, 40);
    }


}
