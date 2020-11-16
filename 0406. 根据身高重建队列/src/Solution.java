import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author 废柴 2020/11/16 9:31
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] orderPeople = new int[people.length][2];
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            idx.add(i);
        }
        Arrays.sort(people, Comparator.comparing(Function.identity(), (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]));
        for (int[] person : people) {
            int i = idx.remove(person[1]);
            orderPeople[i][0] = person[0];
            orderPeople[i][1] = person[1];
        }
        return orderPeople;
    }
}
