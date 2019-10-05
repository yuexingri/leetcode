import java.util.ArrayList;
import java.util.List;

public class Pascal2 {



    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        int index = 1;
        for (int i = 0; i <= rowIndex; i++) {
            result.add(index);
            index = index * (rowIndex - i) / (i + 1);
        }
        return result;
    }
}
