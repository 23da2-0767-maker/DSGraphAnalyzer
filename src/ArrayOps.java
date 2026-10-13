import java.util.Arrays;

// Member 1: Array operations (insert, delete, search, display)
public class ArrayOps {
    private int[] data;   // numbers store panra array
    private int size;     // ippo evlo numbers irukku

    public ArrayOps(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // Insert: kadaisila number serkkum
    public boolean insert(int value) {
        if (size == data.length) {
            System.out.println("Array is full!");
            return false;
        }
        data[size] = value;
        size++;
        System.out.println(value + " inserted.");
        return true;
    }

    // Delete: number-a neekki, pinnadi irukkura elements-a left-ku shift pannum
    public boolean delete(int value) {
        if (size == 0) {
            System.out.println("Array is empty!");
            return false;
        }
        int index = search(value);
        if (index == -1) {
            System.out.println(value + " not found. Cannot delete.");
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println(value + " deleted.");
        return true;
    }

    // Search: index return pannum, illana -1
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Display: ellaa numbers-um kaattum
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // Searching class-ku array kudukka (size alavukku mattum)
    public int[] getData() {
        return Arrays.copyOf(data, size);
    }

    public int getSize() {
        return size;
    }
}