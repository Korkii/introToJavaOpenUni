
public class E2021_B50_Qs{

    //Q1
    public static boolean split3(int[] arr){
        return split3(arr,0,0,0,0);
    }

    private static boolean split3(int[] arr, int i, int sum1, int sum2, int sum3) {
        if(i == arr.length){
            if(sum1 == sum2 && sum2 == sum3)
                return true;
            return false;
        }
        return split3(arr,i+1, sum1 + arr[i], sum2, sum3) ||
            split3(arr,i+1, sum1 ,arr[i] + sum2, sum3) ||
            split3(arr,i+1, sum1, sum2, sum3+arr[i]);
        
    }

    //Q2
    public static int smallestSub(int[] a, int k){
        int low = 0, high = 0, curCount = 0, minCount = a.length+1, curSum = 0;

        while(low < a.length){
            if(curSum <= k){
                if(high < a.length){
                    curCount++;
                    curSum += a[high];
                    high++;
                }
                else
                    low = a.length;
            }
            else if(curSum > k){
                if(curCount < minCount)
                    minCount = curCount;
                curCount--;
                curSum -= a[low];
                low++;
            }
        }
        return minCount;
    }
    public static void main(String[] args) {
        System.out.println("expected true: " + split3(new int[]{8,4,7,1,2,3,5}));
        System.out.println("expected false: " + split3(new int[]{4,7,1,2,3,5}));
    


        int[] arr = {1, 4, 13, 6, 0, 19};
        System.out.println("expected 3: " + smallestSub(arr, 22));
        System.out.println("expected 6: " + smallestSub(arr, 42));
        System.out.println("expected 7: " + smallestSub(arr, 43));
        System.out.println("expected 4: " + smallestSub(arr, 26));
        System.out.println("expected 1: " + smallestSub(arr, 2));
        System.out.println("expected 1: " + smallestSub(arr, 0));
        
    
    }
}
