public static int printExpr(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return printExpr(arr, num, 0, "");
    }


    private static int printExpr(int[] a, int num, int i, String str) {

        if (num == 0) {
            System.out.println(str);
            return 1;
        }

        if (i == a.length) {
            return 0;
        }


        int take = printExpr(a, num + a[i], i + 1, str.concat("+" + a[i]));
        int leave = printExpr(a, num - a[i], i + 1, str.concat("-" + a[i]));
        int hold = printExpr(a, num, i + 1, str);


        return take + hold + leave;

    }
