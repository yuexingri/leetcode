public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int ZERO = -1;
        int TWO = nums.length;
        for (int i = 0; i < TWO; ) {
            if (nums[i] == 0) {
                ZERO++;
                swap(nums, i, ZERO);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                TWO--;
                swap(nums, i, TWO);
            } else {
                throw new RuntimeException();
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
