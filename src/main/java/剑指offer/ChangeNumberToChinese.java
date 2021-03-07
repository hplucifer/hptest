package 剑指offer;

public class ChangeNumberToChinese {
    /*
    输入一个数字，将其转化为汉字形式
     */

    public static String convert(int num) {
        String[] nums = {"零","一","二","三","四","五","六","七","八","九"};
        String[] unit = {"","十","百","千","万","十","百","千","亿","十","百","千","万亿"};

        String str = String.valueOf(num);
        char[] charNum = str.toCharArray();
        String result = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            int c = charNum[i] - '0';
            if (c != 0) {
                result += nums[c] + unit[length - i - 1];
            } else {
                result += nums[c];
            }
        }
        return result;
    }
}
