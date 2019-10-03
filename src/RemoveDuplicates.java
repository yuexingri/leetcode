public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] a = new int[] {0, 1, 2, 3, 4, 5, 6};
        int i = 0;
        int j = 3;
        System.out.println(a[i++]);
        System.out.println(i);
        System.out.println(a[++j]);
        System.out.println(j);
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int pre = 0;
        int cur = 0;
        while (cur < len) {
            if (nums[cur] == nums[pre]) {
                cur++;
            } else {
                ++pre;
                nums[pre] = nums[cur];
                cur++;
            }
        }
        return pre + 1;
    }

}
