import java.util.Arrays;

// Member 1: Linear Search and Binary Search (with step counter and time)
public class Searching {
    // Member 3 idhai Performance table-ku use pannuvaanga
    public static int steps = 0;      // evlo comparisons aachu
    public static long timeNs = 0;    // evlo nano seconds aachu

    // Linear search: modhalil irundhu oravaa paakkum. O(n)
    public static int linearSearch(int[] arr, int key) {
        steps = 0;
        long start = System.nanoTime();
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            steps++;                       // ovvoru compare-kum 1 step
            if (arr[i] == key) {
                result = i;
                break;
            }
        }
        timeNs = System.nanoTime() - start;
        return result;
    }

    // Binary search: array-a sort pannitu, nadula paathu paadhi paadhi-ya thallum. O(log n)
    // Gavanam: index sorted array-oda index (original illa)
    public static int binarySearch(int[] arr, int key) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);               // binary search-ku sorted venum
        steps = 0;
        long start = System.nanoTime();
        int low = 0, high = sorted.length - 1;
        int result = -1;
        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (sorted[mid] == key) {
                result = mid;
                break;
            } else if (sorted[mid] < key) {
                low = mid + 1;             // right side paaru
            } else {
                high = mid - 1;            // left side paaru
            }
        }
        timeNs = System.nanoTime() - start;
        return result;
    }
}