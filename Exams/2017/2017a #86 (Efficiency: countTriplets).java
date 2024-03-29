// Time Complexity: O(n^2) - as requested
// Space Complexity: O(1)

public static int countTriplets(int[] a , int num){
        int high = a.length - 1;
        int low = 0;
        int mid = high - 1;
        int counter = 0;

        while (low <= mid){

            if(low == mid){
                high = high - 1;
                mid = high - 1;
                if(low == high - 1){
                    break;
                }
            }
            if(a[high] + a[mid] + a[low] < num){
                counter++;
                mid--;
            }
            else if(a[high] + a[mid] + a[low] >= num){
                mid--;
            }
        }

        return counter;
    }
