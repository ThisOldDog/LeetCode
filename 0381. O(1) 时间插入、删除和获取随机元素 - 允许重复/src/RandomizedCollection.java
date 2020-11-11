/*
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

import java.util.*;

/**
 * @author 废柴 2020/10/31 16:47
 */
public class RandomizedCollection {
    protected int[] cols;
    protected int size;
    protected Map<Integer, Set<Integer>> indexMap;
    protected Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        cols = new int[0xF];
        size = 0;
        indexMap = new HashMap<>(cols.length);
        random = new Random(System.currentTimeMillis());
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean exists = !indexMap.compute(val, (k, o) -> o == null ? new HashSet<>() : o).isEmpty();
        if (size == cols.length) {
            cols = Arrays.copyOf(cols, cols.length << 1);
        }
        cols[size] = val;
        indexMap.get(val).add(size++);
        return !exists;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        boolean exists = !indexMap.compute(val, (k, o) -> o == null ? new HashSet<>() : o).isEmpty();
        if (exists) {
            Iterator<Integer> iterator = indexMap.get(val).iterator();
            int index = iterator.next();
            iterator.remove();
            if (index < size - 1) {
                cols[index] = cols[--size];
                Set<Integer> replace = indexMap.get(cols[index]);
                replace.remove(size);
                replace.add(index);
            } else {
                size--;
            }
        }
        return exists;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        if (size == 0) {
            return 0;
        }
        return cols[random.nextInt(size)];
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        System.out.println(randomizedCollection.insert(10));
        System.out.println(randomizedCollection.insert(10));
        System.out.println(randomizedCollection.insert(20));
        System.out.println(randomizedCollection.insert(20));
        System.out.println(randomizedCollection.insert(30));
        System.out.println(randomizedCollection.insert(30));

        System.out.println(randomizedCollection.remove(10));
        System.out.println(randomizedCollection.remove(20));
        System.out.println(randomizedCollection.remove(20));
        System.out.println(randomizedCollection.remove(10));
        System.out.println(randomizedCollection.remove(30));

        System.out.println(randomizedCollection.insert(40));
        System.out.println(randomizedCollection.remove(30));
        System.out.println(randomizedCollection.remove(30));
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
    }
}

