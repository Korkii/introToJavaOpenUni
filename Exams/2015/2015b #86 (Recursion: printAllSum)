public static void printAllSum(int[] a,int sum) {

        printAllSum(a,sum,0,"");

    }

    private static void printAllSum(int[] a,int sum,int i, String s){

        if (sum == 0 && i == a.length) { // reached sum and end of array of numbers
            System.out.println(s); // printing the binary string
            return;
        }
        else if (i == a.length) {// didn't reach sum - cannot create a binary string with the sum number with this array
            return;
        }
        printAllSum(a, sum, i+1,s +'0');
        printAllSum(a,sum-a[i], i+1, s + '1');

    }
