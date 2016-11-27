package Sort;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by on 12.11.2016.
 */
public class MergeSort {
    public static int[] Arr;
    public static int[] sort(int[]arr, int[] Buffer, int left, int right){
        if(arr==null){
            return new int[0];
        }
        MergeSort(arr, Buffer,left,right);
        return arr;
    }
    public static void MergeSort(int[]arr, int[] Buffer, int left, int right){
        Arr = arr;
        if(right<=left){
            return;
        }
        int Middle = (left+right) >> 1;
        MergeSort(Arr, Buffer, left, Middle);
        MergeSort(Arr, Buffer, Middle+1,right);
        for (int i=left; i<=right; i++){
            Buffer[i] = Arr[i];
        }
        int LCureent = left;
        int RCurrent = Middle+1;
        for (int i=left; i<=right; i++){
            if (LCureent>Middle){
                Arr[i] = Buffer[RCurrent++];
            }
            else{
                if (RCurrent>right){
                    Arr[i] = Buffer[LCureent++];
                }
                else{
                    if(Buffer[RCurrent]<Buffer[LCureent]){
                        Arr[i] = Buffer[RCurrent++];
                    }
                    else{
                        Arr[i] = Buffer[LCureent++];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out  = new PrintWriter(System.out);
        int n = in.nextInt();
        int [] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        MergeSort(arr, new int[n],0,n-1);
        for (int i=0; i<n; i++){
            out.print(Arr[i]+ " ");
        }
        out.flush();
    }
}