package Mysort;

public class sort {

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

    public void selectSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
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

    public void insertSort(int[] data) {
        int temp;
        int j;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];
            j = i;
            while(j > 0 && data[j-1] > temp) {
                data[j-1] = data[j];
                j--;
            }
            data[j] = temp;
        }
    }

    public void shellSort(int[] data) {
        int len = data.length;
        int step;
        int temp;
        int j;
        for (step = len/2; step > 0; step /= 2) {
            for (int i = step; i < data.length; i++) {
                temp = data[i];
                j = i;
                if (data[j - step] > data[j]) {
                    while (j-step >= 0 && data[j-step] > temp) {
                        data[j-step] = data[j];
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
        } else {
            int len = data.length;
            int i = left;
            int j = right;
            int privot = data[left];
            while (i < j) {
                while (i < j && data[j] > privot) {
                    j--;
                }
                while (i < j && data[i] <= privot) {
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
    }

    public void adjustHeap(int[] data, int length, int k) {
        int k1 = 2*k+1;
        if (k1 < length && data[k1] < data[k1+1]) {
            k1++;
        }
        if (k1 > length || data[k] > data[k1]) {
            return;
        } else {
            int temp = data[k];
            data[k] = data[k1];
            data[k1] = temp;
            adjustHeap(data, k1, length);
        }
    }

    public void heapSort(int[] data) {
        int len = data.length;
        for (int i = (len-2)/2; i < len; i++) {
            adjustHeap(data, i, len);
        }
        for (int j = len-1; j >= 1; j--) {
            int temp = data[0];
            data[0] = data[j-1];
            data[j-1] = temp;
            adjustHeap(data, 0, j);
        }
    }

    public int getMax(int[] data) {
        int len = data.length;
        if (len >= 2) {
            int max = len-1;
            int min = 0;
            while (max - min > 1) {
                int mid = min + (max - min)/2;
                int left = mid - 1;
                while (left >= min) {
                    if (data[left] > data[mid]) {
                        max = left;
                        break;
                    } else if (data[left] < data[mid]) {
                        min = mid;
                        break;
                    } else {
                        if (left == min) {
                           min = mid;
                        }
                        left--;
                    }
                }
            }
            return data[max] > data[min] ? max:min;
        } else if (len == 1) {
            return data[0];
        } else {
            return -1;
        }
    }
}
