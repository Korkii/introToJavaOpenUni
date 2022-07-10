# introToJavaOpenUni
Test solutions for the course.

Upload exams in this form, make sure to format them before uploading them.
Name the file name in this form "Test + [year] + [semester] + [test number]".
public class Exam2019B85 {

    public static int howManyPaths(int[][] mat) {
        return howManyPaths(mat, 0, 0);
    }

    private static int howManyPaths(int[][] mat, int i, int j) {

        if (i >= mat.length || i < 0 || j < 0 || j >= mat[0].length) {
            return 0;
        }

        if (i == mat.length - 1 && j == mat[0].length - 1) {
            return 1;
        }

        int k = mat[i][j];
        mat[i][j] = -k;
        int up = howManyPaths(mat, i + k, j) + howManyPaths(mat, i - k, j) + howManyPaths(mat, i, j + k)
                + howManyPaths(mat, i, j - k);
        mat[i][j] = k;
        return up;

    }

    public static int meetingPoint(int[] a, int[] b) {
        int smallest = Integer.MAX_VALUE;
        int high = Math.min(a.length, b.length);
        int low = 0;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == b[mid]) {
                if (mid < smallest) {
                    smallest = mid;
                }
                high = mid - 1;
            } else if (a[mid] > b[mid]) {
                low = mid + 1;
            } else if (a[mid] < b[mid]) {
                high = mid - 1;
            }
        }
        if (smallest == Integer.MAX_VALUE) {
            return -1;
        }
        return smallest;
    }

}
