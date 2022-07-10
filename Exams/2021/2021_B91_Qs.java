public class E2021_B91_Qs {
    //Q1
    public static int printExpr(int[] arr, int num){
        return printExpr(arr, num,0,"",0);
    }

    private static int printExpr(int[] arr, int num, int i, String s, int curSum) {
        
        if(curSum == num){
            System.out.println(s);
            return 1;
        }
        if(i == arr.length)
            return 0;
        return printExpr(arr, num, i+1, s + "+" + arr[i], curSum + arr[i]) + printExpr(arr, num, i+1, s + "-" + arr[i], curSum - arr[i]) + printExpr(arr, num, i+1, s, curSum);
    }
    public static int longestSequence(int[] a, int k){
        int i = 0, maxCount = 0, curCount = 0,zeroFound = k;
        int[] zeros = new int[a.length];
        int ZeroI = 0, zeroused = 0;;

        while(i < a.length){
            if(a[i] == 0){
                zeros[ZeroI++] = i;
                if(zeroFound > 0){
                    zeroFound--;
                    curCount++;
                    i++;

                }else{
                    zeroFound = k;
                    if(maxCount < curCount)
                        maxCount = curCount;
                    curCount = 0;
                    i = zeros[zeroused++]+1;

                }
            } else {
                curCount++;
                i++;
            }
        }
        return curCount > maxCount ? curCount:maxCount;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1,3,6,2};
        System.out.println(printExpr(arr1, 3));

        int[] arr = {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0};
        System.out.println("expected 4: " + longestSequence(arr, 0));
        System.out.println("expected 7: " + longestSequence(arr, 1));
        System.out.println("expected 10: " + longestSequence(arr, 2));
        System.out.println("expected 11: " + longestSequence(arr, 3));

        
    }
    
}

