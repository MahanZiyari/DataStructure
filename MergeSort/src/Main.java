public class Main {

    public static void main(String[] args) {
        // test unit
        int[] array = {20, 6, 14, 31, 9, 0, 44, 11};

        mergeSort(array, array.length);

        // printing the result
        for (int i : array) {
            System.out.print(i + "  ");
        }
    }

    public static void mergeSort(int array[], int length){
        // return condition
        if (length > 1){

            // declaring middle position and Sub-arrays
            int middle = length/ 2;
            int[] leftArray = new int[middle];
            int[] rightArray = new int[length - middle];

            // assigning sub-arrays
            for (int i = 0; i < middle; i++)
                leftArray[i] = array[i];
            for (int j = middle; j < length; j++)
                rightArray[j - middle] = array[j];

            // method calls itself for both sub-arrays to divide them
            mergeSort(leftArray, middle);
            mergeSort(rightArray, length - middle);

            //passing original array and sub-arrays to merge
            merge(array, leftArray, rightArray, middle, length - middle);
        }
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray, int n1, int n2){
        int i = 0, j = 0, k = 0;
        /* each time this method is called,
        it compares left-array values with the right one
        and put them in their correct position int the original array*/
        while (i < n1 && j < n2){
            if (leftArray[i] <= rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
        }

        /* put the remaining values from the sub-array
        which it's pointer doesn't reach the end of array*/
        while (i < n1)
            array[k++] = leftArray[i++];
        while (j < n2)
            array[k++] = rightArray[j++];

    }
}
