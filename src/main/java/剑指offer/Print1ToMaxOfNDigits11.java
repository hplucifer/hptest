package 剑指offer;

public class Print1ToMaxOfNDigits11 {
    /*
    题12：打印1到最大的n位数
    输入数字n，按顺序打印出从1到最大的n位十进制数，比如输入3，则打印出1，2，3。。。。。。一直到最大三位数999
     */

    /**
     * n的范围没有规定，所以要考虑大数问题，整型或者长整型都可能溢出
     * 所以用字符串,java字符串没有结束符
     */
    public static void print1ToMaxOfNDigits(int n) {
        int[] array = new int[n];
        if (n <= 0) {
            return;
        }
        printArray(array, 0);//传入0是为了开始把数组元素都置为0
    }

    /**
     * 转化成数组排列，采用递归，n位所有十进制数其实就是n个从0到9的全排列
     * @param array
     * @param n
     */
    public static void printArray(int[] array, int n) {
        /**
         * 外层循环，改变低位数字，0---9
         * 内层循环，从数字高位向个位打印
         * 例如，外层循环不断改变最深层遍历即个位的数字array[2]=0---9;
         * 最深层递归的外一层递归，改变array[1]=0---9
         * 当array[1]=1时，该值先被固定，他下一层递归改变array[2]=0---9
         * 内存循环就打印出10---19
         */
        for (int i = 0; i < 10; i++) {
            //i=0的时候，层层递归，数组元素都置为0
            //以n==array.length来锁住个位，即元素最后一个元素
            if (n != array.length) {
                array[n] = i;//通过递归，数组所有位都先置为0，然后后面每层递归用来固定上一层的前一位的值
                /**
                 * 递归后，最深进入到数组的最后一位，最后一位开始从1到9，由于上一层固定前一位，从而顺序打印
                 * 例如，上一层array[1] = 0,下一层array[2]从1到9
                 * 上一层array[1] = 1, 下一层array[2]从0到9，从而打印出10。。。。19
                 * 通过固定上一层数组元素的值，如此一层一层递归
                 */
                printArray(array, n + 1);
            } else {
                boolean isFirstNum0 = false;//不打印数组非0位前面元素的0
                for (int j = 0; j < array.length; j++) {
                    if (array[j] != 0) {
                        System.out.print(array[j]);
                        if (!isFirstNum0) {
                            isFirstNum0 = true;//如果前一位不为0，则通过置标志量，如果后一位为0，则可直接打印后一位
                                               // ，相当于补齐其他位的0
                        }
                    } else {
                        if (isFirstNum0) {
                            System.out.print(array[j]);//可以打印出其他位的0，例如10，20。。。。
                        }
                    }
                }
                System.out.print("  ");
                return;//跳出循环，不然会打印10次内循环的
            }
        }
    }
}
