package Mysort;

import java.util.HashMap;

public class Mysort {
    /**
     *
     * @param data
     */

    public void bubbleSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            boolean flag = true;
            for (int j = 0; j < data.length - i; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public void insertSort(int[] data) {
        for (int i = 0; i < data.length-1; i++) {
            int min = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = data[i];
                data[i] = data[min];
                data[min] = temp;
            }
        }
    }

    public void selectSort(int[] data) {
        int temp;
        int j;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];
            j = i;
            while(j > 0 && data[j-1] > temp) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = temp;
        }
    }

    public void shellSort(int[] data) {
        int len = data.length;
        int step;
        for (step = len/2; step > 0; step /= 2) {
            for (int i = step; i < len; i++) {
                int temp = data[i];
                int j = i;
                if (data[j-step] > data[j]) {
                    while(j-step >= 0 && data[j-step] > temp) {
                        data[j] = data[j-step];
                        j -= step;
                    }
                    data[j] = temp;
                }
            }
        }
    }

    public void quickSort(int[] data, int left, int right) {
        if (left >= right || data == null) {
            return;
        }
        int i = left;
        int j = right;
        int privot = data[left];
        while (i < j) {
            while (i < j && privot < data[j]) {
                j--;
            }
            while (i < j && privot >= data[i]) {
                i++;
            }
            if (i < j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        data[left] = data[j];
        data[j] = privot;
        quickSort(data, left, i-1);
        quickSort(data, i+1, right);
    }

    //???????????????
    public void adjustHeap(int[] data, int k, int length) {
        int k1 = 2*k+1;
        if (k1 < length-1 && data[k1] < data[k1+1]) { //????????????k1+1?????????<length -1
            k1++;
        }
        if (k1 > length-1 || data[k] >= data[k1]) { //???????????? >=??????????????????????????????????????????????????????length-1??????????????????
            return;
        } else {
            int temp = data[k];
            data[k] = data[k1];
            data[k1] = temp;
        }
        adjustHeap(data, k1, length);
    }

    //???????????????
    public void adjustHeapBig(int[] data, int k, int length) {
        int k1 = 2*k+1;
        if (k1 < length-1 && data[k1] > data[k1+1]) {
            k1++;
        }
        if (k1 > length-1 || data[k] <= data[k1]) { //???????????? <= ??????????????????????????????????????????????????????length-1??????????????????
            return;
        } else {
            int temp = data[k];
            data[k] = data[k1];
            data[k1] = temp;
        }
        adjustHeapBig(data, k1, length);
    }


    public void heapSort(int[] data) {
        int len = data.length;
        for (int i = (len - 2)/2; i >=0; i--) {
            adjustHeap(data, i, len);
        }
        for (int j = len - 1; j >= 1; j--) {
            int temp = data[0];
            data[0] = data[j];
            data[j] = temp;
            adjustHeap(data, 0, j);
        }
    }

    public int getMax(int[] data) {
        int len = data.length;
        if (len >= 2) {
            int max = len - 1;
            int min = 0;
            while(max - min > 1) {
                int mid = min + (max - min)/2;
                int left = mid - 1;
                while(left >= min) {
                    if (data[left] > data[mid]) {
                        max = left;
                        break;
                    } else if (data[left] < data[mid]) {
                        min = mid;
                        break;
                    } else {
                        if (min == left) {
                            min = mid;
                        }
                        left--;
                    }
                }
            }
            return data[max]>data[min]?max:min;
        } else if (len == 1) {
            return 0;
        } else {
            return -1;
        }
    }

    public String strAdd(String a, String b) {
        char[] charsA = new StringBuilder(a).reverse().toString().toCharArray();
        char[] charsB = new StringBuilder(b).reverse().toString().toCharArray();

        int maxLength = Math.max(charsA.length, charsB.length);
        int[] result = new int[maxLength+1];

        int temp = 0;
        for (int i = 0; i < maxLength; i++) {
            temp = result[i];
            if (i < charsA.length) {
                temp += charsA[i] - '0';
            }
            if (i < charsB.length) {
                temp += charsB[i] - '0';
            }
            if (temp >= 10) {
                temp -= 10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }
        StringBuilder str = new StringBuilder();
        boolean flag = true;
        for (int i = maxLength; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            }
            flag = false;
            str.append(result[i]);
        }
        return str.toString();
    }

    public void QSort(int arr[],int low,int high)
    {
        if (low >= high || arr == null) {
            return;
        }

        int first = low;
        int last = high;

        int left = low;
        int right = high;

        int leftLen = 0;
        int rightLen = 0;

        //????????????
        int key = SelectPivotMedianOfThree(arr,low,high);//?????????????????????????????????

        while(low < high)
        {
            while(high > low && arr[high] >= key)
            {
                if (arr[high] == key)//??????????????????
                {
                    swap(arr, right, high);
                    right--;
                    rightLen++;
                }
                high--;
            }
            arr[low] = arr[high];
            while(high > low && arr[low] <= key)
            {
                if (arr[low] == key)
                {
                    swap(arr, left, low);
                    left++;
                    leftLen++;
                }
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;

        //??????????????????
        //????????????key?????????????????????????????????????????????
        int i = low - 1;
        int j = first;
        while(j < left && arr[i] != key)
        {
            swap(arr, i, j);
            i--;
            j++;
        }
        i = low + 1;
        j = last;
        while(j > right && arr[i] != key)
        {
            swap(arr, i, j);
            i++;
            j--;
        }
        QSort(arr,first,low - 1 - leftLen);
        QSort(arr,low + 1 + rightLen,last);
    }

    /*????????????????????????????????????low???mid???high?????????????????????????????????????????????????????????????????????*/
    int SelectPivotMedianOfThree(int arr[],int low,int high)
    {
        int mid = low + ((high - low) >> 1);//????????????????????????????????????

        //?????????????????????????????????
        if (arr[mid] > arr[high])//??????: arr[mid] <= arr[high]
        {
            swap(arr, mid, high);
        }
        if (arr[low] > arr[high])//??????: arr[low] <= arr[high]
        {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[low]) //??????: arr[low] >= arr[mid]
        {
            swap(arr, mid, low);
        }
        //?????????arr[mid] <= arr[low] <= arr[high]
        int hp = arr[low];
        return arr[low];
        //low?????????????????????????????????????????????
        //???????????????????????????low????????????????????????????????????????????????????????????
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
