public static int findMax(int[] a) {

        int high = a.length - 1;
        int low = 0;
        int mid;
        int maxIndex = 0;

        while(low < high){

            mid = (low + high) / 2;

            if(a[mid] > a[maxIndex]){
                maxIndex = mid;
            }

            if(a[low] > a[mid]){
                high = mid;
            }
            else low = mid + 1;

        }

        return maxIndex;

    }
