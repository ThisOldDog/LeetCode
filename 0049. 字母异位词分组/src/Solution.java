import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 废柴 2020/12/14 11:33
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> r = new ArrayList<>();
        Map<String, Integer> cache = new HashMap<>();
        for (String str : strs) {
            int[] k = new int[26];
            for (char c : str.toCharArray()) {
                k[c - 'a'] += 1;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < k.length; i++) {
                if (k[i] > 0) {
                    key.append(i).append(k[i]).append(",");
                }
            }
            String keyStr = key.toString();
            Integer index = cache.get(keyStr);
            if (index != null) {
                r.get(index).add(str);
            } else {
                cache.put(keyStr, r.size());
                r.add(new ArrayList<>() {{
                    add(str);
                }});
            }
        }
        return r;
    }
}
