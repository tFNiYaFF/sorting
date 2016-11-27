package Sort;

import Bench.Helper;

import java.util.Scanner;

/**
 * Created by Никита on 14.11.2016.
 */
public class InsertionSortPlus {
    public static int BinarySearch(int[] arr, int key, int left, int right) {

        while (left < right-1) {
            int middle = (left + right) >> 1;
            if (key > arr[middle]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return right;
    }
    public static int[] sort(int[] arr){
        if (arr==null){
            return new int[0];
        }
        if(arr.length==0){
            return arr;
        }

        for(int i=1; i<arr.length; i++){
            int k = BinarySearch(arr,arr[i],-1,i);
            for(int j=i; j>k;j--){
                Helper.swap(arr,j,j-1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {4,3,2,1};
arr= sort(arr);
        for (int i=0;i<4; i++){
            System.out.print(arr[i]+ " ");
        }
        }
    }
