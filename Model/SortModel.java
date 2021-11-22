package Model;

import Control.Controller;

import java.util.ArrayList;
import java.util.Arrays;

public class SortModel {
    //배열 정렬
    public static ArrayList<String> sort(ArrayList<String> arr) {
        ArrayList<String> temp = new ArrayList<String>();
        for (String str : arr) {
            temp.add(str);
        }
        divideAndMerge(temp, 0, temp.size()-1);
        return temp;
    }

    //분할
    private static void divideAndMerge(ArrayList<String> arr, int low, int high) {
//		System.out.println(String.format("%d %d", low, high));
        if(low >= high) {
            return;
        }
        int mid = (low+high)/2;
        divideAndMerge(arr, low, mid);
        divideAndMerge(arr,mid+1, high);
        merge(arr, low, mid, high);
    }


    public static void merge(ArrayList<String> arr, int low, int mid, int high) {
        String[] sorted = new String[arr.size()];
        int low_idx, high_idx, sort_idx;
        low_idx = low; high_idx = mid+1; sort_idx = low;

        while (low_idx <= mid && high_idx <= high) {
            int res = arr.get(low_idx).compareTo(arr.get(high_idx));
            if (res < 0) {
                sorted[sort_idx++] = arr.get(low_idx++);
            } else if (res >= 0) {
                sorted[sort_idx++] = arr.get(high_idx++);
            }
        }

        if(low_idx > mid) {
            for (int i = high_idx; i <= high; i++) {
                sorted[sort_idx++] = arr.get(i);
            }
        }
        else {
            for (int i = low_idx; i <= mid; i++) {
                sorted[sort_idx++] = arr.get(i);
            }
        }

        for (int i = low; i <= high; i++) {
            arr.set(i, sorted[i]);
        }
    }
}
