/**
 * 二分查找 O(log (m+n))
 *
 * @author qingsheng.chen@hand-china.com
 */
public class BinarySolution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums2.length % 2 == 0
                    ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0
                    : nums2[nums2.length / 2];
        } else if (nums2 == null || nums2.length == 0) {
            return nums1.length % 2 == 0
                    ? (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0
                    : nums1[nums1.length / 2];
        } else {
            int total = nums1.length + nums2.length;
            return total % 2 == 0
                    ? (binarySearch(nums1, nums2, total / 2) + binarySearch(nums1, nums2, total / 2 + 1)) / 2.0
                    : binarySearch(nums1, nums2, (total + 1) / 2);

        }
    }

    public static int binarySearch(final int[] nums1, final int[] nums2, final int target) {
        int max = Math.min(target, nums1.length);
        return binarySearch(nums1, nums2, target, 0, max, max);
    }

    public static int binarySearch(final int[] nums1, final int[] nums2, final int target, int left, int right, int currentValue) {
        if (toRight(nums1, nums2, target, currentValue)) {
            left = right - left == 1 ? right : currentValue;
            currentValue = (right - left + 1) / 2 + left;
            return binarySearch(nums1, nums2, target, left, right, currentValue);
        } else if (toLeft(nums1, nums2, target, currentValue)) {
            right = right - left == 1 ? left : currentValue;
            currentValue = (right - left + 1) / 2 + left;
            if (target - currentValue > nums2.length) {
                currentValue = target - nums2.length;
            }
            return binarySearch(nums1, nums2, target, left, right, currentValue);
        } else {
            return getValue(nums1, nums2, target, currentValue);
        }
    }

    public static boolean toRight(final int[] nums1, final int[] nums2, final int target, final int currentValue) {
        int nums1Index = currentValue - 1;
        int nums2Index = target - currentValue - 1;
        return nums1Index >= 0 && nums2Index >= 0 && nums1Index < nums1.length - 1 && nums2[nums2Index] > nums1[nums1Index + 1];
    }

    public static boolean toLeft(final int[] nums1, final int[] nums2, final int target, final int currentValue) {
        int nums1Index = currentValue - 1;
        int nums2Index = target - currentValue - 1;
        return nums1Index >= 0 && nums2Index < nums2.length - 1 && nums1[nums1Index] > nums2[nums2Index + 1];
    }

    public static int getValue(int[] nums1, int[] nums2, int target, int currentValue) {
        int nums1Index = currentValue - 1;
        int nums2Index = target - currentValue - 1;
        if (nums1Index < 0) {
            return nums2[nums2Index];
        } else if (nums2Index < 0) {
            return nums1[nums1Index];
        } else {
            return Math.max(nums1[nums1Index], nums2[nums2Index]);
        }
    }


    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2,3,4,5}, new int[]{0}));
    }
}
