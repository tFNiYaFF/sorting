package Sort;

import java.util.Scanner;

/**
 * Created by  on 06.11.2016.
 */
public class InsertionSort {
    public static int[] sort(int[] arr){
        if (arr == null)
        {
            return new int[0];
        }
        for (int i=1; i<arr.length; i++){
            int current = arr[i];
            int j = i;
            while (j>0 && arr[j-1]>current) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = current;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        arr = sort(arr);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}