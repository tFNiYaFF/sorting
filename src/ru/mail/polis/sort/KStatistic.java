package Sort;

import Bench.Helper;

import java.security.InvalidKeyException;
import java.util.Random;

/**
 * Created by Никита on 15.11.2016.
 */
public class KStatistic {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0};
        System.out.println(GetKStatistic(arr,3,new Random()));
    }
    static int partition(int[] arr, int left, int right, int pivot) {
        if (left > right) {
            return right;
        }
        int i = left;
        int j = right;
        int x = arr[pivot];
        Helper.swap(arr,j--,pivot);
        while (i<=j){
            while(i<=j && arr[i]<x){
                i++;
            }
            while(i<=j && arr[j]>x){
                j--;
            }
            if (i>=j){
                break;
            }
            Helper.swap(arr,i++,j--);
        }
        Helper.swap(arr,i,right);
        return i;
    }

    public static int GetKStatistic(int[] arr, int key, Random random) {
        if(arr==null){
            System.out.println("Bad input");
            return 0;
        }
        if(arr.length==0 || key>arr.length-1|| key<0){
            System.out.println("Bad input");
            return 0;
        }
        int left = 0,right = arr.length-1;
        while(right>left){
            int pivotIdx = left+ random.nextInt(right-left+1);
            int idx = partition(arr,left,right,pivotIdx);
            if (key<idx){
                right = idx-1;
            }
            else{
                if (key>idx){
                    left = idx+1;
                }
                else{
                    break;
                }
            }
        }
        return arr[key];
    }
}
