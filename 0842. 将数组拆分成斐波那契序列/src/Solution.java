import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 废柴 2020/12/8 17:19
 */
public class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        char[] num = S.toCharArray();
        int[] nums = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            nums[i] = num[i] - '0';
        }
        long n1 = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            n1 = n1 * 10 + nums[i];
            int j = i + 1;
            boolean n2Next = nums[j] != 0;
            if (n1 > Integer.MAX_VALUE) {
                break;
            }
            long n2 = 0;
            for (; j < nums.length - 1; j++) {
                n2 = n2 * 10 + nums[j];
                if (n2 > Integer.MAX_VALUE) {
                    break;
                }
                List<Integer> fibonacci = isFibonacci(n1, n2, j + 1, nums);
                if (fibonacci != null) {
                    return fibonacci;
                }
                if (!n2Next) {
                    break;
                }
            }
            if (nums[0] == 0) {
                break;
            }
        }
        return Collections.emptyList();
    }

    private List<Integer> isFibonacci(long n1, long n2, int i, int[] nums) {
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add((int) n1);
        fibonacci.add((int) n2);
        while (true) {
            long n3 = fibonacci.get(fibonacci.size() - 2) + fibonacci.get(fibonacci.size() - 1);
            if (n3 > Integer.MAX_VALUE) {
                return null;
            }
            int[] n3s = toNums(n3);
            if (!match(n3s, i, nums)) {
                break;
            }
            i += n3s.length;
            fibonacci.add((int) n3);
            if (i == nums.length) {
                return fibonacci;
            }
        }
        return null;
    }

    private boolean match(int[] toNums, int i, int[] nums) {
        for (int j = 0; j < toNums.length; j++) {
            if (j + i >= nums.length || toNums[j] != nums[j + i]) {
                return false;
            }
        }
        return true;
    }

    private int[] toNums(long n) {
        if (n == 0) {
            return new int[]{0};
        }
        int[] nums = new int[10];
        int i = 9;
        while (n > 0) {
            nums[i--] = (int) (n % 10);
            n /= 10;
        }
        return Arrays.copyOfRange(nums, i + 1, 10);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().splitIntoFibonacci("123456579"));
//        System.out.println(new Solution().splitIntoFibonacci("11235813"));
//        System.out.println(new Solution().splitIntoFibonacci("112358130"));
//        System.out.println(new Solution().splitIntoFibonacci("1101111"));
        System.out.println(new Solution().splitIntoFibonacci("0000"));
    }
}
