package Sort;

import Bench.Helper;

/**
 * Created by Никита on 22.11.2016.
 */
public class MSDBinary {
    public static int[] sort(int[] arr){
        if (arr==null){
            return new int[0];
        }
        sortMSD(arr,0,arr.length-1,0x40000000);
        return arr;
    }
    public static void sortMSD(int[] arr,int left, int right, int bit){
        if (bit==0){
            return;
        }
        if (right-left+1<2 || right<1){
            return;
        }
        int last = left;
        for (int i=left; i<=right; i++){
           if((arr[i] & bit) == 0){
               Helper.swap(arr,last++,i);
           }
        }
            sortMSD(arr, left, last-1, bit >> 1);
            sortMSD(arr, last, right, bit >> 1);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        int[] arr = {4,3,2,1};
        sort(arr);
        for (int i=0;i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
