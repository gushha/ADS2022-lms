package by.it.group251051.Shiryavskaya.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Реализуйте сортировку слиянием для одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо отсортировать полученный массив.

Sample Input:
5
2 3 9 2 9
Sample Output:
2 2 3 9 9
*/
public class B_MergeSort {

    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        Scanner scanner = new Scanner(stream);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        mergeSort(a, 0, n - 1); // Вызов сортировки слиянием

        return a;
    }

    private void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            // Разделяем массив на две части и рекурсивно сортируем каждую половину
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            // Объединяем отсортированные половины
            merge(arr, left, middle, right);
        }
    }

    private void merge(int arr[], int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group251051/Shiryavskaya/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        // long startTime = System.currentTimeMillis();
        int[] result = instance.getMergeSort(stream);
        // long finishTime = System.currentTimeMillis();
        for (int index : result) {
            System.out.print(index + " ");
        }
    }

}
