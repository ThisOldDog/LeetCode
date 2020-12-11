/**
 * @author 废柴 2020/12/11 21:52
 */
public class Solution {
    public String predictPartyVictory(String senate) {
        char[] senates = senate.toCharArray();
        int r = 0, d = 0, c = 0;
        while ((c + r < senates.length) && (c + d < senates.length)) {
            for (int i = 0; i < senates.length; i++) {
                if (senates[i] == 'R') {
                    if (d > 0) {
                        d--;
                        senates[i] = '0';
                        c++;
                    } else {
                        r++;
                    }
                } else if (senates[i] == 'D') {
                    if (r > 0) {
                        r--;
                        senates[i] = '0';
                        c++;
                    } else {
                        d++;
                    }
                }
            }
        }
        return r > 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().predictPartyVictory("RD"));
//        System.out.println(new Solution().predictPartyVictory("RDD"));
        System.out.println(new Solution().predictPartyVictory("RRDDD"));
    }
}
