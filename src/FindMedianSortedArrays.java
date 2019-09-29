public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[] {1, 2};
        int[] num2 = new int[] {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
        System.out.println();
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length;
        int j = nums2.length;
        int k1 = (i + j + 1) / 2;
        int k2 = (i + j + 2) / 2;
        return (findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k1)
                + findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k2)) / 2;
    }

    private static double findKth(int[] num1, int start1, int end1, int[] num2, int start2, int end2, int k) {
        int lenght1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        if (lenght1 > length2) {
            findKth(num2, start2, end2, num1, start1, end1, k);
        }
        if (lenght1 == 0) {
            return num2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(num1[start1], num2[start2]);
        }
        int i = start1 + Math.min(lenght1, k/2) - 1;
        int j = start2 + Math.min(length2, k/2) - 1;
        if (num1[i] > num2[j]) {
            return findKth(num1, start1, end1, num2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return findKth(num1, i + 1,end1, num2, start2, end2, k - (i - start1 + 1));
        }
    }
}
