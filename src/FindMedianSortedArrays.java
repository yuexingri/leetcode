public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[] {1, 2};
        int[] num2 = new int[] {3, 4};
        findMedianSortedArrays(num1, num2);
        System.out.println();
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            pickMedianSortedArrays(nums2);
        }
        if (nums2.length == 0) {
            pickMedianSortedArrays(nums1);
        }
        int length = nums1.length + nums2.length;
        int[] allNums = new int[length];
        int indexForNum1 = 0;
        int indexForNum2 = 0;
        int indexForAll = 0;
        boolean num1IsEnd;
        boolean num2IsEnd;
        while (true) {
            num1IsEnd = arrayIsEnd(nums1, indexForNum1);
            num2IsEnd = arrayIsEnd(nums2, indexForNum2);
            if (num1IsEnd || num2IsEnd) {
                break;
            }
            if (nums1[indexForNum1] > nums2[indexForNum2]) {
                allNums[indexForAll] = nums2[indexForNum2];
                indexForNum2++;
            } else if (nums1[indexForNum1] < nums2[indexForNum2]) {
                allNums[indexForAll] = nums1[indexForNum1];
                indexForNum1++;
            }
            indexForAll++;
        }
        if (num1IsEnd && !num2IsEnd) {
            putRemainToResult(nums2, indexForNum2, allNums, indexForAll);
        }
        if (num2IsEnd && !num1IsEnd) {
            putRemainToResult(nums1, indexForNum1, allNums, indexForAll);
        }
        return pickMedianSortedArrays(allNums);
    }

    private static double pickMedianSortedArrays(int[] arrays) {
        int length = arrays.length;
        if (length % 2 == 0) {
            return ((arrays[length/2] + arrays[length/2 - 1])) * 1.0 / 2;
        } else {
            return arrays[(length - 1)/2] * 1.0;
        }
    }

    private static void putRemainToResult(int[] source, int sourceIndex, int[] target, int targetIndex) {
        for (int i = sourceIndex; i < source.length - sourceIndex; i++) {
            target[targetIndex] = source[i];
            targetIndex++;
        }
    }

    private static boolean arrayIsEnd(int[] nums, int index) {
        return index == nums.length;
    }
}
