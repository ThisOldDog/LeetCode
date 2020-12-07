import java.util.ArrayList;
import java.util.List;

/**
 * @author 废柴 2020/12/7 19:11
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> generate = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> layer = new ArrayList<>(i + 1);
            generate.add(layer);
            layer.add(1);
            for (int j = 1; j < i; j++) {
                layer.add(generate.get(i - 1).get(j - 1) + generate.get(i - 1).get(j));
            }
            if (i > 0) {
                layer.add(1);
            }
        }
        return generate;
    }
}
