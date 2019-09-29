public class ReverseInteger {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        int reverse1 = reverse(123);
        int reverse2 = reverse(-123);
        int reverse3 = reverse(120);
        int reverse4 = reverse(Integer.MAX_VALUE);
        int reverse5 = reverse(-2147483648);
        System.out.println();
    }

    public static int reverse(int x) {
        int rec = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rec > Integer.MAX_VALUE / 10 || (rec == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rec < Integer.MIN_VALUE / 10 || (rec == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rec = rec * 10 + pop;
        }
        return rec;
    }
}
