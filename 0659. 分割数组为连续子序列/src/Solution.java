import java.util.ArrayList;

/**
 * @author 废柴 2020/12/4 17:09
 */
public class Solution {
    public boolean isPossible(int[] nums) {
        int max = nums.length / 3 + 1;
        ArrayList<ArrayList<Integer>> sequence = new ArrayList<>();
        nextNum:
        for (int num : nums) {
            if (sequence.isEmpty()) {
                sequence.add(new ArrayList<>());
                sequence.get(0).add(num);
            } else {
                for (int i = sequence.size() - 1; i >= 0; i--) {
                    ArrayList<Integer> subSeq = sequence.get(i);
                    if (subSeq.get(subSeq.size() - 1) == num - 1) {
                        subSeq.add(num);
                        continue nextNum;
                    } else if (subSeq.get(subSeq.size() - 1) < num) {
                        break;
                    }
                }
                ArrayList<Integer> subSeq = new ArrayList<>();
                subSeq.add(num);
                sequence.add(subSeq);
                if (sequence.size() >max) {
                    return false;
                }
            }
        }
//        sequence.forEach(System.out::println);
        return sequence.stream().noneMatch(e -> e.size() < 3);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(new int[]{1, 2, 3, 3, 4}));
    }
}
