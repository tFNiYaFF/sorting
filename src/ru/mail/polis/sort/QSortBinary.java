package Sort;

import Bench.Helper;

/**
 * Created by Никита on 24.11.2016.
 */
public class QSortBinary {
    public static int[] sort(int[] arr){
        if (arr == null) {
            return new int[0];
        }
        QSort(arr, 0, arr.length - 1, 31);
        return arr;
    }

    public static void QSort(int[] arr, int left, int right, int w){
        if (left >= right || w<0) {
            return;
        }
            int i = left;
            int j = right;
            while (i <= j){
                while ((i <=right) && Digit(arr[i], w) == 0 ){
                    i++;
                }
                while ((j >=left) && Digit(arr[j], w) == 1){
                    j--;
                }
                if (i <= j){
                    Helper.swap(arr, i++, j--);
                }
            }
            QSort(arr, left, j, w - 1);
            QSort(arr, j + 1, right, w - 1 );
        }

    private static int Digit(int n, int k) {
        return (n >> k) & 1;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,1,3,86,2,1,5,6};
        sort(arr);
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }

}
