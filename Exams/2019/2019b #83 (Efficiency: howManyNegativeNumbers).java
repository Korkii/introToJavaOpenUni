// Time Complexity: O(n + m) - Linear
// Space Complexity: O(1)


public static int howManyNegativeNumber(int[][] a){

        int i = 0;
        int j = a[i].length - 1;
        int counter = 0;

        while(i != a.length -1 && j != 0){

            if(a[i][j] >= 0){
                j--;
            }

            if(a[i][j] < 0){
                counter += j + 1;
                i++;
            }
        }

        return counter;

    }
