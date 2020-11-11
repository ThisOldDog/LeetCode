/**
 * @author 废柴 2020/9/7 16:07
 */
public class Solution {
    public static int findUnsortedSubarray(int[] nums) {
        int head = 0, tail = nums.length - 2, max = 0, min = Integer.MAX_VALUE;
        while (tail >= 0) {
            if (nums[tail] > nums[tail + 1]) {
                max = nums[tail + 1];
                tail += 1;
                break;
            }
            tail--;
        }
        if (tail < 0) {
            return 0;
        }
        while (head < tail) {
            if (nums[head] <= max && nums[head] <= nums[head + 1]) {
                head++;
            } else {
                max = nums[head];
                break;
            }
        }
        for (int i = head + 1; i <= tail; ++i) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        while (head >= 1) {
            if (nums[head - 1] > min) {
                head--;
            } else {
                break;
            }
        }
        while (tail != 0 && tail < nums.length - 1) {
            if (max > nums[tail + 1]) {
                tail++;
            } else {
                break;
            }
        }
        return tail == head ? 0 : (tail - head + 1);
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}));
        System.out.println(findUnsortedSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
        System.out.println(findUnsortedSubarray(new int[]{2, 1}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 4, 5}));
        System.out.println(findUnsortedSubarray(new int[]{2, 3, 1, 5, 4}));
    }
}
