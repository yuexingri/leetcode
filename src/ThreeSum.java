import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0 || nums.length < 3) {
            return null;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            int target = 0 - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {

            }
        }
        return null;
    }

}
