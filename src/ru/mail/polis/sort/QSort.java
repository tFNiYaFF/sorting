package Sort;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Crea
 */
public class QSort {
    public static int[] sort (int arr[], int left, int right){
        if (arr==null){
            return new int[0];
        }
        if (arr.length==0){
            return arr;
        }
        quickSort(arr, left, right);
        return arr;
    }
    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left<index) {
            quickSort(arr, left, index);
        }
        if(index+1<right) {
            quickSort(arr, index + 1, right);
        }
    }
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left+(right-left+1)/2];
        while(left<=right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left<=right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
        return right;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String[] ArrTmp = in.nextLine().split(" ");
        int[] arr = new int[ArrTmp.length];
        for (int i=0; i<ArrTmp.length; i++){
            arr[i] = Integer.parseInt(ArrTmp[i]);
        }
        quickSort(arr,0,arr.length-1);
        for (int i=0; i<arr.length; i++){
            out.print(arr[i] + " ");
        }
        out.flush();
    }
}