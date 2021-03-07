package 剑指offer;

public class NumbersPlus {
    /*
    实现两个超大整数相加
     */

    /**
     * 两个大数，如果直接相加，可能会越界，所以转化为数据
     * 先反转，把最高位放到尾部，防止进位，如果不仅为直接删除
     */
    public static String bigAdd(String a, String b) {
        char[] charsA = new StringBuffer(a).reverse().toString().toCharArray();
        char[] charsB = new StringBuffer(b).reverse().toString().toCharArray();

        int maxLength = Math.max(charsA.length, charsB.length);

        int[] result = new int[maxLength + 1];//防止进位，多开辟一位空间
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
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;

        for (int i = maxLength; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            }
            flag = false;
            stringBuilder.append(result[i]);
        }
        return  stringBuilder.toString();
    }
}
