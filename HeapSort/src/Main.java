public class Main {
    public static void main(String[] args) {
        int[] array = {9, 1, 8, 0, 6, 5, 2, 4, 3, 7};
        heapSort(array, array.length);

        for (int i :
                array) {
            System.out.print(i + "  ");
        }
    }

    public static void heapSort(int[] array, int length){
        // Build heap (rearrange array)
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);

        // One by one extract an element from heap
        for (int i=length - 1; i > 0; i--)
        {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int[] array, int length, int index)
    {
        int largest = index; // Initialize largest as root
        int l = 2*index + 1; // left = 2*i + 1
        int r = 2*index + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < length && array[l] > array[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < length && array[r] > array[largest])
            largest = r;

        // If largest is not root
        if (largest != index)
        {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, length, largest);
        }
    }
}
