/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        while (i != j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                --j;
            } else {
                ++i;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
