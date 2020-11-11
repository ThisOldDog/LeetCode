/**
 * @author 废柴 2020/10/24 22:00
 */
public class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] bucket = new int[T + 1];
        for (int[] clip : clips) {
            // 初始化 或者 取 下表能够到达的最远位置
            int idx = Math.min(T, clip[0]);
            if (bucket[idx] == 0) {
                bucket[idx] = clip[1];
            } else {
                bucket[idx] = Math.max(clip[1], bucket[idx]);
            }
        }
        // 没有 0 起始的片段
        if (bucket[0] == 0) return -1;
        int s = 0, e = bucket[0], cnt = 1;
        while (e < T) {
            int max = e;
            for (int i = s + 1; i <= e; i++) {
                if (bucket[i] > max) {
                    max = bucket[i];
                }
            }
            if (max > e) {
                cnt++;
                s = e;
                e = max;
            } else {
                return -1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().videoStitching(new int[][]
                {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}}, 9));
    }
}
