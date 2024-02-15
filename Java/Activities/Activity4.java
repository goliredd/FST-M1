package Activities;

import java.util.Arrays;



public class Activity4 {
    static void insertionSort(int array[]) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            } array[j+1] = key;
        }
    }

    public static void main(String[] args){
        int[] ArrayNum = {4,2,7,8,3,5,1,6};
        System.out.println("Array before sort: " + Arrays.toString(ArrayNum));
        insertionSort(ArrayNum);
        System.out.println("Array after sort: " + Arrays.toString(ArrayNum));
    }
}
