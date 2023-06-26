// Originally written by Yonatan Hadad
public static boolean superInc(int[] arr, int k) {
    for(int i = arr.length - 1; i >= 0; i--) {
        if(k == 0)
            return true;
        if(arr[i] <= k)
            k -= arr[i];
    }
    
    return false;
}
    
public static void main(String[] args) {
    int[] nums = {4,7,12,25,49,100};
    int target = 161;
  
    System.out.println(superInc(nums, target)); //prints true
}
