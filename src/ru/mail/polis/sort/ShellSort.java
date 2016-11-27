package Sort;

import java.util.Scanner;

/**
 * Created by Никита on 14.11.2016.
 */
public class ShellSort {
    public static int[] sort(int[] arr){
        if (arr==null){
            return new int[0];
        }
        int step = arr.length / 2;
        while (step > 0)
        {
            for (int i = 0; i < (arr.length - step); i++)
            {
                int j = i;
                while (j >= 0 && arr[j] > arr[j + step])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + step];
                    arr[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;
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
        arr= sort(arr);
        for (int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
