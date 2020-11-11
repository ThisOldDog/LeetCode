import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 废柴 2020/9/7 11:02
 */
public class Solution {
    private Map<Integer, Integer> indexMap = new HashMap<>();

    static class Node {
        int value;
        int weight;

        public Node(int value) {
            this.value = value;
            this.weight = 1;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k == nums.length) {
            return nums;
        }
        Node[] heap = new Node[nums.length];
        // 大顶堆
        int index = 0;
        for (int num : nums) {
            // new node
            Integer j = indexMap.get(num);
            if (j == null) {
                Node node = new Node(num);
                heap[index] = node;
                indexMap.put(num, index++);
            } else {
                // append
                Node node = heap[j];
                node.weight++;
                up(heap, j);
            }
        }
        int[] result = new int[k];
        // 先序遍历前 k 个
        for (int i = 0, e = index - 1; i < k && e >= 0; i++, e--) {
            result[i] = heap[0].value;
            if (e == 0) {
                break;
            }
            heap[0] = heap[e];
            heap[e] = null;
            indexMap.put(heap[0].value, 0);
            down(heap, 0);
        }
        return result;
    }

    private void up(Node[] heap, int index) {
        // 根节点无法上移
        if (index == 0) {
            return;
        }
        int parentIndex = (index - 1) >> 1;
        Node parent = heap[parentIndex];
        Node child = heap[index];
        // 父节点大于子结点，不需要上移
        if (parent.weight < child.weight) {
            // 父节点小于子节点，子节点上移
            heap[parentIndex] = child;
            heap[index] = parent;
            indexMap.put(child.value, parentIndex);
            indexMap.put(parent.value, index);
            // 继续上移子节点
            up(heap, parentIndex);
        }
    }

    private void down(Node[] heap, int index) {
        Node parent = heap[index];
        int leftIndex = (index << 1) + 1;
        Node leftChild = heap[leftIndex];
        int rightIndex = (index << 1) + 2;
        Node rightChild = heap[rightIndex];
        // 父节点小于左结点，交换
        if (leftChild != null && (rightChild == null || rightChild.weight < leftChild.weight) && parent.weight < leftChild.weight) {
            heap[index] = leftChild;
            heap[leftIndex] = parent;
            indexMap.put(parent.value, leftIndex);
            indexMap.put(leftChild.value, index);
            // 左移父结点
            down(heap, leftIndex);
        } else if (rightChild != null && parent.weight < rightChild.weight) {
            heap[index] = rightChild;
            heap[rightIndex] = parent;
            indexMap.put(parent.value, rightIndex);
            indexMap.put(rightChild.value, index);
            // 左移父结点
            down(heap, rightIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1}, 1)));
    }
}