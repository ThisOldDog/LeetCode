import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 废柴 2020/11/2 9:34
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums2Set = IntStream.of(nums2).boxed().collect(Collectors.toSet());
        return IntStream.of(nums1).filter(nums2Set::contains).distinct().toArray();
    }
}
