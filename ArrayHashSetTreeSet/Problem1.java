package ArrayHashSetTreeSet;

   import java.util.*;
public class Problem1 {

        public static final int SIZE = 1_000_000;  // 1 million elements
        public static final int SEARCH_COUNT = 1_000;  // Search 1000 random elements

        public static void main(String[] args) {
            // Generate random numbers
            int[] array = new int[SIZE];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            Random rand = new Random();
            for (int i = 0; i < SIZE; i++) {
                int num = rand.nextInt(SIZE);
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            // Generate random search keys
            int[] searchKeys = new int[SEARCH_COUNT];
            for (int i = 0; i < SEARCH_COUNT; i++) {
                searchKeys[i] = rand.nextInt(SIZE);
            }

            // Benchmark Array Search (O(N))
            long arrayTime = benchmarkArraySearch(array, searchKeys);

            // Benchmark HashSet Search (O(1) on average)
            long hashSetTime = benchmarkHashSetSearch(hashSet, searchKeys);

            // Benchmark TreeSet Search (O(log N))
            long treeSetTime = benchmarkTreeSetSearch(treeSet, searchKeys);

            // Print Results
            System.out.println("\nSearch Performance Results:");
            System.out.println("Array (O(N))      : " + arrayTime + " ms  ❌ (Slowest)");
            System.out.println("HashSet (O(1))    : " + hashSetTime + " ms  ✅ (Fastest)");
            System.out.println("TreeSet (O(log N)): " + treeSetTime + " ms  🚀 (Balanced Performance)");
        }

        // Linear Search in Array (O(N))
        public static long benchmarkArraySearch(int[] array, int[] searchKeys) {
            long start = System.nanoTime();
            for (int key : searchKeys) {
                for (int num : array) {
                    if (num == key) break;  // Linear search
                }
            }
            long end = System.nanoTime();
            return (end - start) / 1_000_000; // Convert to ms
        }

        // HashSet Search (O(1) on average)
        public static long benchmarkHashSetSearch(HashSet<Integer> hashSet, int[] searchKeys) {
            long start = System.nanoTime();
            for (int key : searchKeys) {
                hashSet.contains(key);
            }
            long end = System.nanoTime();
            return (end - start) / 1_000_000;
        }

        // TreeSet Search (O(log N))
        public static long benchmarkTreeSetSearch(TreeSet<Integer> treeSet, int[] searchKeys) {
            long start = System.nanoTime();
            for (int key : searchKeys) {
                treeSet.contains(key);
            }
            long end = System.nanoTime();
            return (end - start) / 1_000_000;
        }
    }



