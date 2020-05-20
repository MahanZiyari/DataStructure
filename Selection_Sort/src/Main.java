import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int[] array = {5, 7, 0, 8, 2, 3, 1, 9, 4, 6, 10};
        selectionSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + "  ");
        }
    }


    public static void selectionSort(int[] array, int lower , int upper){
        while (lower < upper){
            int currentMinimum = array[lower];
            int indexOfMinimum = lower, temp = 0;
            //finding minimum value
            for (int i = lower; i <= upper; i++){
                if (array[i] < currentMinimum){
                    currentMinimum = array[i];
                    indexOfMinimum = i;
                }
            }
            //swapping
            temp = array[lower];
            array[lower] = array[indexOfMinimum];
            array[indexOfMinimum] = temp;
            //forwarding our lower
            lower++;
            //calling method by new Arguments
            selectionSort(array, lower, upper);
        }
    }
}
