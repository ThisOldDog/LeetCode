import java.util.HashSet;
import java.util.Set;

/**
 * @author 废柴 2020/12/13 16:40
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> d = new HashSet<>(nums.length * 4 / 3);
        for (int num : nums) {
            if (d.contains(num)) {
                return true;
            }
            d.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new HashSet<>());
    }
}
