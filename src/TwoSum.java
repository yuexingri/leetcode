import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result);
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (existedInList(results, i)) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (existedInList(results, j)) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    results.add(i);
                    results.add(j);
                }
            }
        }
        int[] res = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            res[i] = results.get(i);
        }
        return res;
    }

    private static boolean existedInList(List<Integer> result, int num) {
        return result.contains(num);
    }
}
