package Sort;
import Bench.Helper;

public class MergeSortPlus {

    public static int[] sort(int[] a) {
        if(a==null){
            return new int[0];
        }
        if(a.length==0){
            return a;
        }
        for (int len = 2; len < a.length * 2; len *= 2) {
            for (int i = 0; i < a.length; i +=  len) {
                int l = len;
                if (i + len >= a.length) {
                    l = a.length - i;
                }
                mergeSort(a, i, l);
            }
        }
        return a;
    }

    private static void mergeSort(int[] a, int start, int length) {
        int len = (int) Math.sqrt(length);
        int blockCount = length / len;
        int cur = a[start];
        int block = 0;
        for (int i = 1; i < length; i++) {
            if (a[start + i] < cur) {
                block = i - 1;
                break;
            }
            cur = a[start + i];
        }
        block /= len;
        int last = blockCount - 1;
        swapBlock(a, len, start + block * len, start + last * len);

        for (int i = 0; i < blockCount - 1; i++) {
            int min = i;
            for (int j = i + 1; j < blockCount - 1; j++) {
                if (a[start + j * len] < a[start + min * len]) {
                    min = j;
                } else if ((a[ start + j * len] == a[ start + min * len]) && (a[ start + (j + 1) * len - 1] < a[start + (min + 1) * len - 1])) {
                    min = j;
                }
            }
            if (min != i) {
                swapBlock(a, len, start + i * len, start + min * len);
            }
        }
        for (int i = 0; i < blockCount - 2; i++) {
            int block1= i;
            int block2 = i + 1;
            mergeBlocks(a, len, start + block1 * len, start + block2 * len, start + (blockCount - 1) * len);
        }

        int S = length - (blockCount - 1) * len;
        QSort.sort(a, start + length - S * 2, start + length - 1);

        int buf = start + length - S;
        int currentBlock = buf - S;
        while (currentBlock >= start + S) {
            int secondBlock = currentBlock - S;
            mergeBlocks(a, S, secondBlock, currentBlock, buf);
            currentBlock -= S;
        }

        QSort.sort(a, start, start + S * 2 - 1);
        QSort.sort(a, start + length - S, start + length - 1);

    }

    private static void swapBlock(int[] arr, int blockLen, int aInd, int bInd) {
        for (int j = 0; j < blockLen; j++) {
            int tmp = arr[aInd + j];
            arr[aInd + j] = arr[bInd + j];
            arr[bInd + j] = tmp;
        }
    }


    private static void mergeBlocks(int[] a, int blockLen, int aInd, int bInd, int buffer) {
        swapBlock(a, blockLen, aInd, buffer);
        int p = bInd;
        int q = buffer;
        for (int i = 0; i < blockLen * 2; i++) {
            if (p > bInd + blockLen - 1) {
                Helper.swap(a, aInd + i, q);
                q++;
            } else if (q > buffer + blockLen - 1) {
                Helper.swap(a, aInd + i, p);
                p++;
            } else if (a[p] < a[q]) {
                Helper.swap(a, aInd + i, p);
                p++;
            } else {
                Helper.swap(a, aInd + i, q);
                q++;
            }
        }
    }
}
