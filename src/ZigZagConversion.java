import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 4);
        System.out.println();
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goDown = false;
        for (int i = 0; i < s.length(); i++) {
            rows.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1) {
                goDown = !goDown;
            }
            curRow += goDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}
