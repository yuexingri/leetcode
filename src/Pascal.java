import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) {
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = Arrays.asList(new Integer[i + 1]);
            row.set(0, 1);
            row.set(i, 1);
            for (int j = 1; j < i; j++) {
                row.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.add(row);
        }
        return result;
    }
}
