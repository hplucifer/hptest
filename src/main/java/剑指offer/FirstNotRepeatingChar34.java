package 剑指offer;

import java.util.LinkedHashMap;

public class FirstNotRepeatingChar34 {
    /*
    题35：第一次出现一次的字符
    在字符串中找出第一个只出现一次的字符。例如输入"abaccdeff"，则输出b
     */

    /**
     * 首先想到的是遍历统计，如果字符串有n个字符，则每个字符可能要有后面n个字符比较，则时间负责度0（n*n），效率太低
     * 解法：采用哈希表,时间负责度0（n）
     */
    public static String firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] strChar = str.toCharArray();
        //使用有序hashmap，treemap不可以（内部排序，不是写入顺序）
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (char item : strChar) {
            if (hashMap.containsKey(item)) {
                hashMap.put(item, hashMap.get(item) + 1);
            } else {
                hashMap.put(item, 1);
            }
        }
        for (int i = 0; i < strChar.length; i++) {
            if (hashMap.get(strChar[i]) == 1) {
                System.out.println("第一个不重复的字符");
                return String.valueOf(strChar[i]);
            }
        }
        return "没有不重复的字符";
    }
}
