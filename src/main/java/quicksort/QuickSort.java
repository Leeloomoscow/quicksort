package quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (left >= right)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = left + (right - left) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = left, j = right;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (left < j)
            quickSort(array, left, j);

        if (right > i)
            quickSort(array, right, i);
    }

    public static void main(String[] args) {
        int[] x = {8, 0, 4, 7, 3, 7, 10, 12, -3};
        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int left = 0;
        int right = x.length - 1;

        quickSort(x, left, right);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));
    }
}