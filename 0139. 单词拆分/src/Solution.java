import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 废柴 2020/11/1 20:55
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int max = 0;
        for (String word : wordDict) {
            max = Math.max(max, word.length());
        }
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j <= max && dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }


}
