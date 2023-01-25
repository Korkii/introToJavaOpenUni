// Time Complexity : O(nk) - k is constant
// Space Complexity: O(4) = O(1)

public static void sortMod(int[] a, int k){

        int i,j,temp,count = 0;
        for(i = 0; i < k; i++){
            for(j = count; j < a.length; j++){
                if(a[j] % k  == i){
                    temp = a[j];
                    a[j] = a[count];
                    a[count] = temp;
                    count++;
                }
            }
        }
    }
