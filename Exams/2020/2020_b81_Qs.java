public class E2020_b81_Qs{

    //Q1
    public static int makeSum(int[] lens, int k, int num){
        if(k == 0 || num == 0)
            return 0;
        return makeSum(lens,k,num,0);
    }
    
    private static int makeSum(int[] lens, int k, int num, int i){
        if(i == lens.length || num < 0 || k < 0)
            return 0;
        
        if(k == 0 && num >= 0)
            return 1;
        //Try to add lens[i] to sum Or try take the next lens(i+1)
        int count = makeSum(lens, k - lens[i], num-1, i) + makeSum(lens, k, num, i+1);
        
        return count;
    }

    //Q2 - O(n)
    public static void minimumSubK(int[] arr, int k){
        int[] minSub = new int[3]; // [0] - min sum, [1] - start of subArr index, [2] end of subArr index
        int i = 0, j = 0;

        for(; j <= k-1 ;j++){
            minSub[0] += arr[j];
        }

        minSub[1] = i;
        minSub[2] = --j;
        
        int tempSum = minSub[0];

        while(j < arr.length-1){
            tempSum -= arr[i];
            i++;
            j++;
            tempSum += arr[j];

            if(tempSum < minSub[0]){
                minSub[0] = tempSum;
                minSub[1] = i;
                minSub[2] = j;
            }
        }
        System.out.println("Minimum sum sub-arry is (" + minSub[1] + "," + minSub[2] +")");


    }
    
    //Tester
    public static void main(String[] args) {

        //Test Q1
        int[] lens = {5,10,20,50};
        int k = 40, num = 4;
        System.out.println(makeSum(lens, k, num)); // Should be 4

        //Test Q2
        int[] arr = {10,4,2,5,6,3,8,1,5,9};
        minimumSubK(arr, 3); // Should be (1,3)
        minimumSubK(arr, 2); // Should be (1,2) / (7,8)

    

    }

 
    
}
