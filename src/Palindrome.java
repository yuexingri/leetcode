public class Palindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 10;
        while (x / div > 10) {
            div *= 10;
        }
        while (x > 10) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
