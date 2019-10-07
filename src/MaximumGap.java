public class MaximumGap {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 6, 9, 1};
        MaximumGap gap = new MaximumGap();
        System.out.println(gap.maximumGap(nums));
    }

    private class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int bucketSize = Math.max(1, (max - min) / (nums.length -1));
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        for (int i = 0; i < nums.length; i++) {
            int loc = (nums[i] - min) / bucketSize;

            if (buckets[loc] == null) {
                buckets[loc] = new Bucket();
            }

            buckets[loc].min = Math.min(buckets[loc].min, nums[i]);
            buckets[loc].max = Math.max(buckets[loc].max, nums[i]);
        }

        int previousMax = Integer.MAX_VALUE;
        int maxGap = Integer.MIN_VALUE;

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null && previousMax != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, buckets[i].min - previousMax);
            }
            if (buckets[i] != null) {
                previousMax = buckets[i].max;
                maxGap = Math.max(maxGap, buckets[i].max - buckets[i].min);
            }
        }
        return maxGap;
    }
}
