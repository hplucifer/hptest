package Mysort;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        String s ="ADOBEODEBAN";
        String t = "ABC";
        System.out.println(minStr(s, t));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high || array == null) {
            return;
        }
        int left = low;
        int right = high;

        int nLeft = low;
        int nRight = high;

        int leftLen = 0;
        int rightLen = 0;

        int pivot = selectPivot(array, low, high);

        while (low < high) {
            while (low < high && array[high] >= pivot) {
                if (array[high] == pivot) {
                    swap(array, nRight, high);
                    nRight--;
                    rightLen++;
                }
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                if (array[low] == pivot) {
                    swap(array, nLeft, low);
                    nLeft++;
                    leftLen++;
                }
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        int i = low - 1;
        int j = left;
        while (j < nLeft && array[i] != pivot) {
            swap(array, i, j);
            i--;
            j++;
        }
        i = low + 1;
        j = right;
        while (j > nRight && array[i] != pivot) {
            swap(array, i, j);
            i++;
            j--;
        }
        quickSort(array, left, low - 1 - leftLen);
        quickSort(array, low + 1 + rightLen, right);

    }

    public static int selectPivot(int arr[],int low,int high) {
        int mid = low + ((high - low) >> 1);

        if (arr[mid] > arr[high])
        {
            swap(arr, mid, high);
        }
        if (arr[low] > arr[high])
        {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[low])
        {
            swap(arr, mid, low);
        }
        return arr[low];
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static String minWindow(String s, String t) {
        //设置flag ，是为了排除s=a,t=aa的情况
        boolean flag = false;
        int left = 0;
        int lengthOfMin = s.length();
        int minLeft = 0;
        int minRight = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        int cnt = 0;
        //遍历T串
        for (char c : t.toCharArray())
            hashMap.put(c, hashMap.containsKey(c) ? hashMap.get(c) + 1 : 1);
        //遍历S串
        for (int right = 0; right < s.length(); right++) {
            char temp = s.charAt(right);
            if (hashMap.containsKey(temp)) {
                cnt = hashMap.get(temp) > 0 ? cnt + 1 : cnt;
                hashMap.put(temp, hashMap.get(temp) - 1);
            }
            while (cnt == t.length()) {
                flag = true;
                if (right - left + 1 <= lengthOfMin) {
                    lengthOfMin = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                char c = s.charAt(left);
                if (hashMap.containsKey(c)) {
                    if (hashMap.get(c) + 1 > 0) cnt--;
                    hashMap.put(c, hashMap.get(c) + 1);
                }
                left++;
                System.out.println(lengthOfMin);
            }
        }
        if (!flag) return "";
        return s.substring(minLeft, minRight + 1);
    }

    public static String minStr(String S, String T) {
        if (S == null || T == null) {
            return null;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int start = 0;
        int minLeft = -1;
        int minRight=0;
        int count = 0;
        int minLength = S.length();
        for (char c : T.toCharArray()) {
            hashMap.put(c, hashMap.containsKey(c) ? hashMap.get(c) + 1 : 1);
        }
        for (int i = 0; i < S.length(); i++) {
            if (hashMap.containsKey(S.charAt(i))) {
                count =hashMap.get(S.charAt(i)) > 0 ? count + 1 : count;
                hashMap.put(S.charAt(i), hashMap.get(S.charAt(i)) - 1);
            }
            while (count == T.length()) {
                if (minLength >= i - start + 1) {
                    minLength = i - start + 1;
                    minLeft = start;
                    minRight = i;
                }
                if (hashMap.containsKey(S.charAt(start))){
                    if (hashMap.get(S.charAt(start)) + 1 > 0) {
                        count--;
                    }
                    hashMap.put(S.charAt(start), hashMap.get(S.charAt(start)) + 1);
                }
                start++;
            }
        }
        return minLeft == -1 ? "" : S.substring(minLeft, minRight + 1);
    }

}
