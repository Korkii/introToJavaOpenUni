    public class O2017B93 {

        public static int cntTrueReg(boolean[][] mat) {
            return cntTrueReg(mat, 0, 0);
        }

        private static int cntTrueReg(boolean[][] mat, int i, int j){
            if (i>=mat.length || j>=mat[0].length || j<0 || i<0){
                return 0;
            }
            if (mat[i][j]==true){
                cleaner(mat, i, j);
                return 1 + cntTrueReg(mat,i+1,j) + cntTrueReg(mat,i,j+1);
            }
            return cntTrueReg(mat,i+1,j) + cntTrueReg(mat,i,j+1);
    }

        public static void cleaner(boolean[][] mat, int i, int j) {
            if (i >= mat.length || j >= mat[0].length || j < 0 || i < 0) {
                return;
            }
            if (mat[i][j] == true) {
                mat[i][j] = false;
                cleaner(mat, i + 1, j);
                cleaner(mat, i - 1, j);
                cleaner(mat, i, j - 1);
                cleaner(mat, i, j + 1);
            }

        }

        public static int findNum(Range rangeA[], int num){
            int high = rangeA.length-1, low = 0;
            int mid;
            while (low<=high){
                mid = (low+high)/2;
                if (num<=rangeA[mid].getCenter()+rangeA[mid].getRadius() && num>=rangeA[mid].getCenter()-rangeA[mid].getRadius()){
                    return mid;
                }
                else if (num>rangeA[mid].getCenter()+rangeA[mid].getRadius()){
                    low = mid+1;
                }
                else if (num<rangeA[mid].getCenter()-rangeA[mid].getRadius()) {
                    high = mid-1;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            boolean[][] mat = new boolean[][] {
                    { false, false, false, false, true },
                    { false, true, true, true, false },
                    { false, false, true, true, false },
                    { true, false, false, false, false },
                    { true, true, false, false, false }
            };
            System.out.println(cntTrueReg(mat));
            Range[] arr = new Range[]{new Range(4,1),new Range(12, 0),new Range(20, 1), new Range(102, 2)};
            System.out.println(findNum(arr, 5)); // print 0
            System.out.println(findNum(arr, 101)); // print 3
            System.out.println(findNum(arr, 15)); // print -1
            System.out.println(findNum(arr, 105)); //print -1

        }
    }
