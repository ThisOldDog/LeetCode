import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 废柴 2020/9/17 16:30
 */
public class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(restaurant -> veganFriendly == 0 || restaurant[2] == 1)
                .filter(restaurant -> restaurant[3] <= maxPrice)
                .filter(restaurant -> restaurant[4] <= maxDistance)
                .sorted(Comparator.comparing(Function.identity(), (r1, r2) -> {
                    int c = r2[1] - r1[1];
                    if (c == 0) {
                        c = r2[0] - r1[0];
                    }
                    return c;
                }))
                .map(restaurant -> restaurant[0])
                .collect(Collectors.toList());
    }
}
