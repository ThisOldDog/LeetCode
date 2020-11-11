/**
 * 暴力解法 O((m+n)/2)
 *
 * @author qingsheng.chen@hand-china.com
 */
public class ViolentSolution {
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
            double ans = .0;
            int i = 0, j = 0, index = 0, length = nums1.length + nums2.length;
            int index1 = length % 2 == 0 ? (length / 2) : ((length + 1) / 2);
            int index2 = length % 2 == 0 ? (length / 2) + 1 : ((length + 1) / 2);
            while (index1 != -1 || index2 != -1) {
                ++index;
                int indexV;
                if (j == nums2.length || i < nums1.length && nums1[i] <= nums2[j]) {
                    indexV = nums1[i++];
                } else {
                    indexV = nums2[j++];
                }
                if (index1 == index) {
                    ans += indexV;
                    index1 = -1;
                }
                if (index2 == index) {
                    ans += indexV;
                    index2 = -1;
                }
            }
            return ans / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
