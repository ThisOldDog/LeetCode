/**
 * @author 废柴 2020/10/5 20:06
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] bucket = new boolean[123];
        for (char c : J.toCharArray()) {
            bucket[c] = true;
        }
        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (bucket[c])
                ++cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println((int) 'z');
    }
}
