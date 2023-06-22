// By Ziv Laifer 
  public static int test(int[][] mat){
        int[][] counter = new int[mat.length][mat[0].length];
        return test(mat,0,0,0, counter, "");
    }
    private static int test(int[][]m, int i, int j, int sum, int[][] counter, String str){
        if(i == m.length-1 && j == m[i].length-1){
            sum += m[i][j];
            str += "(" + i + "," + j + ") = " + sum;
            System.out.println(str);
            return sum;
        }
        if(i < 0 || j < 0 || i >= m.length || j >= m[i].length || counter[i][j] >= m[i][j]){
            return Integer.MIN_VALUE;
        }
        counter[i][j]++;
        str += "(" + i + "," + j + ") --> ";
        int left = test(m,i,j-1,sum+m[i][j], counter, str);
        int right = test(m,i,j+1,sum+m[i][j], counter, str);
        int up = test(m,i-1,j,sum+m[i][j], counter, str);
        int down = test(m,i+1,j,sum+m[i][j], counter, str);
        counter[i][j]--;
        return max(left,right,up,down);
    }
    private static int max(int a, int b, int c, int d) {
        int max1 = a > b ? a : b;
        int max2 = c > d ? c : d;
        return max1 > max2 ? max1 : max2;       
    }
