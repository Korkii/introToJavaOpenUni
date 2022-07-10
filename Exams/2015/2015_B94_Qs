public class 2015_B94_Qs{
    //Q1
    public static int longOrdNum_Koren(String s) {
        if (s.equals(""))
            return 0;

        int length = longOrdNum_Koren(s, (char) (s.charAt(0) - '1'));
        int nextLength = longOrdNum_Koren(s.substring(1));

        return Math.max(length, nextLength);
    }

    private static int longOrdNum_Koren(String s, char prevChar) {

        if (s.equals(""))
            return 0;

        boolean notANumber = s.charAt(0) < '0' || s.charAt(0) > '9';
        if (notANumber)
            return 0;

        boolean invalidSequence = prevChar >= s.charAt(0);
        if (invalidSequence)
            return 0;

        return 1 + longOrdNum_Koren(s.substring(1), s.charAt(0));
    }

    
    public static int longOrdNum(String s) {
        if (s == null || s.length() == 0)
            return 0;
        return longOrdNum(s, 0, 0, 0, ' ');
    }
    private static boolean isNumber(char c){
        return c >= '0' || c <= '9';
    }

    private static int longOrdNum(String s, int i, int count, int max, char prev) {
        if (i == s.length())
            return max;
        char curr = s.charAt(i);
        if (i == 0) {
            if (isNumber(curr))
                return longOrdNum(s, i + 1, count + 1, count + 1, curr);
            return longOrdNum(s, i + 1, count, count, curr);
        }
        if (isNumber(curr)) {
            if (isNumber(prev) && curr > prev) {
                count++;
                if (count > max)
                    max = count;
                return longOrdNum(s, i + 1, count, max, curr);
            }
            return longOrdNum(s, i + 1, 1, Math.max(1, max), curr);
        }
        return longOrdNum(s, i + 1, count, max, curr);
    }

    public static void main(String[] args) {

        System.out.println("expected 3: " + longOrdNum("x12y3348"));
        System.out.println("expected 1: " + longOrdNum("321"));
        System.out.println("expected 0: " + longOrdNum("xyz"));
        System.out.println("expected 0: " + longOrdNum(""));
        System.out.println("expected 4: " + longOrdNum("23256812"));
        System.out.println("expected 4: " + longOrdNum("1234"));
        System.out.println("expected 1: " + longOrdNum("9"));
    }
    
}


   
