public class 2017_B85_Qs {
    //Q1
    public static int oneFiveSeven(int n){
        if( n == 0)
            return 0;
        if(n < 0)
            return Integer.MAX_VALUE;
        int one = oneFiveSeven(n-1);
        int five = oneFiveSeven(n-5);
        int seven = oneFiveSeven(n-7);

        return 1 + Math.min(one, Math.min(five, seven));
    }

    //Q2
    //O(n)
    public static void printClosest(int[]a, int[] b, int x){
        int iA = 0, iB = b.length -1;
        int sum = 0;
        int[] minSum = new int[3];
        minSum[0] = Integer.MAX_VALUE;



        while(iA < a.length && iB > -1){
            sum = a[iA] + b[iB];
            if(Math.abs(sum - x) < minSum[0]){
                minSum[0] = Math.abs(sum - x);
                minSum[1] = iA;
                minSum[2] = iB;
            }
            if(sum == x){
                System.out.println(a[iA] + " and " + b[iB]);
                return;
            }
            if(sum > x){
                iB--;
            } else
                iA++;
            
        }
        System.out.println(a[minSum[1]] + " ~and~ " + b[minSum[2]]);

        
    }
    
    //O(log-n)
    public static void printClosest1(int[] a, int[] b, int x) {

        
        int lowA = 0;
        int highA = a.length - 1;

        int lowB = 0;
        int highB = b.length - 1;

        int numA = 0, numB = 0, savedDiff = Integer.MAX_VALUE;

        int sum = 0;

        while (lowA <= highA || lowB <= highB) {

            int midA = (lowA + highA) / 2;
            int midB = (lowB + highB) / 2;

            sum = a[midA] + b[midB];

            if (sum == x) {
                System.out.println(a[midA] + " and " + a[midB]);
                return;
            }


            int currDiff = sum - x;
            if (currDiff < 0) currDiff = -currDiff;

            if (currDiff < savedDiff) {
                numA = a[midA];
                numB = b[midB];
                savedDiff = currDiff;
            }


            if (sum < x) {

                int intendedMidA = (midA + 1 + highA) / 2;
                int intendedMidB = (midB + 1 + highB) / 2;

                if ((lowA < highA && a[intendedMidA] < b[intendedMidB]) || lowB == highB)
                    lowA = intendedMidA;
                else
                    lowB = intendedMidB;
            } else {
                int intendedMidA = (lowA + midA) / 2;
                int intendedMidB = (lowB + midB) / 2;

                if ((lowB < highB && a[intendedMidA] < b[intendedMidB]) || lowA == highA)
                    highB = intendedMidB;
                else
                    highA = intendedMidA;
            }
        }
        int lastDiff = a[lowA] + b[lowB] - x;
        if (lastDiff < 0) lastDiff = -lastDiff;

        if (lastDiff < savedDiff)
            System.out.println(a[lowA] + " and " + b[lowB]);
        else
            System.out.println(numA + " and " + numB);

    }
    
    public static void main(String[] args) {
        for(int i = 1; i < 20; i++){
            System.out.println(oneFiveSeven(i));
        }

        int[] a = {0, 4, 6, 11, 11};
        int[] b = {10, 20, 30, 40};
        System.out.print("expected \"0 and 10\": ");
        printClosest(a, b, 11);

         System.out.print("expected \"4 and 10\": ");
        printClosest(a, b, 13);

        System.out.print("expected \"10 and 6\" or \"0 and 20\" : ");
        printClosest(a, b, 18);

        System.out.print("expected \"40 and 11\": ");
        printClosest(a, b, 70);

        char c = '5';
        char c1 = '6';
        System.out.println(c < c1);

    }
}
