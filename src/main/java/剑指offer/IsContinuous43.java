package 剑指offer;

import java.util.Arrays;

public class IsContinuous43 {
    /*
    题44：扑克牌的顺子
    从扑克牌中随机抽取5张牌，判断是不是一个顺子，即5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，大小王可为任意数
     */

    /**
     * 5张牌其实就是5个数字，可以看作一个有5个元素的数组
     * 看是否为一个顺子，即数组元素之间连续递增、不会有重复元素
     * 大小王可为任意数，可以把大小为定义为0，和其他元素区分开
     * 1。先排序，是数组元素递增
     * 2。排序后数组是否连续，如果不连续，两个相邻元素之间间隔的数字是否可以用数组内所含大小王去填补
     * 3。数组内是否有重复元素
     * 解法：转化为计算机问题
     */
     public static boolean isContinuous(int[] numbers) {
         if (numbers == null || numbers.length == 0) {
             return false;
         }
         int count = 0;
         int diff = 0;
         Arrays.sort(numbers);
         for (int i = 0; i < numbers.length - 1; i++) {
             if (numbers[i] == 0) {
                 count++;
                 continue;
             }
             if (numbers[i] == numbers[i + 1]) {
                 return false;
             }

             diff += numbers[i + 1] - numbers[i] - 1;
         }

         return (diff <= count);
     }
}
