import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 废柴 2020/12/16 9:43
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternWordMap = new HashMap<>();
        Map<String, Character> wordPatternMap = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        char[] ps = pattern.toCharArray();
        for (int i = 0; i < ps.length; i++) {
            String expectedWord = patternWordMap.get(ps[i]);
            Character expectedPattern = wordPatternMap.get(words[i]);
            if (expectedWord == null && expectedPattern == null) {
                patternWordMap.put(ps[i], words[i]);
                wordPatternMap.put(words[i], ps[i]);
            } else if (expectedWord == null || expectedPattern == null) {
                return false;
            } else if (!Objects.equals(expectedWord, words[i]) || !Objects.equals(expectedPattern, ps[i])) {
                return false;
            }
        }
        return true;
    }
}
