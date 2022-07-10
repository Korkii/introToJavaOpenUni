public static void printPath(int[][] mat){

        if(mat == null){
            return;
        }
        String path = printPath(mat, 0, 0, mat[0][0] - 1, "");
        System.out.println(path);

    }

    private static String printPath(int[][] mat, int i, int j, int prev, String path){

        if(i < 0 || i > mat.length - 1 || j < 0 || j > mat[0].length - 1 || mat[i][j] <= prev){
            return path;
        }


        path += "(" + i + "," + j + ")";



        String up = printPath(mat, i - 1, j, mat[i][j], path);
        String right = printPath(mat, i, j + 1, mat[i][j], path);
        String down = printPath(mat, i + 1, j, mat[i][j], path);
        String left = printPath(mat, i, j - 1, mat[i][j], path);

        return maxString(up,down,right,left);

    }

    private static String maxString(String a, String b, String c, String d) {

        if (a.length() < b.length())
            a = b;

        if (c.length() < d.length())
            c = d;

        if (a.length() < c.length())
            a = c;

        return a;
    }
