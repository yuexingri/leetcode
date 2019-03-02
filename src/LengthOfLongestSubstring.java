import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = " ";
        String s5 = "dvdf";
        int l1 = lengthOfLongestSubstring(s1);
        int l2 = lengthOfLongestSubstring(s2);
        int l3 = lengthOfLongestSubstring(s3);
        int l4 = lengthOfLongestSubstring(s4);
        int l5 = lengthOfLongestSubstring(s5);
        System.out.println();
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] charArray = s.toCharArray();
        int subStringLength = 0;
        List<Character> subString = new ArrayList<Character>();
        for (int i = 0; i < charArray.length - 1; i++) {
            subString = new ArrayList<Character>();
            subString.add(charArray[i]);
            for (int j = i + 1; j < charArray.length; j++) {
                if (subString.contains(charArray[j])) {
                    subStringLength = maxlength(subString, subStringLength);
                    break;
                }
                subString.add(charArray[j]);
            }
            subStringLength = maxlength(subString, subStringLength);
        }
        return subStringLength;
    }

    private static int maxlength(List<Character> subString, int subStringLength) {
        return subStringLength > subString.size() ? subStringLength : subString.size();
    }
}
