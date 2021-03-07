package 剑指offer;

public class ReverseSentence41 {
    /*
    题42：(一）反转字符串
    输入一个英文句子，反转句子中单词的顺序，但单词内字符的顺序不变。标点符号按普通字母处理。
    例如，输入"I am a student."，输出"student. a am I"
    (二）左旋转字符串
    字符串的左旋转是把字符串前面的若干个字节转移到字符串的尾部。
    例如，输入"abcdefg"，将前两位左旋转，则旋转后为"cdefgab"。
     */

    /**
     * （一）解法：先反转整个句子，然后以空格为界，取出每个单词，反转为原来顺序
     */
    public static String reverseSentence(String str) {
        //如果字符串都为空格
        //string.trim()为取出空格
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String reverseStr = reverse(str);
        String[] strings = reverseStr.split(" ");
        for (int i = 0; i < strings.length - 1; i++) {
            stringBuilder.append(reverse(strings[i])).append(" ");
        }
        //要在拼接字母后加空格，最后一个单词后面不加，所以单独取出最后一个单词反转
        stringBuilder.append(reverse(strings[strings.length - 1]));
        return stringBuilder.toString();
    }

    //substring(),取出字符串长度 endindex-startindex
    public static String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.substring(i, i+1));//从尾一个一个字符取出，然后拼接
        }
        return stringBuilder.toString();
    }

    /**
     * （二）解法：观察字符串，将字符串分为两部分"ab cdefg"，然后分别反转"ba gfedc"，然后将两部分
     *  合为一个字符串"bagfedc"，然后反转该字符串得到"cdefgba"
     */
    public static String leftRotateString(String str, int index) {
       if (str == null || str.length() == 0 || index > str.length() || index < 0) {
           return null;
       }
       String[] strs = {str.substring(0, index), str.substring(index, str.length())};
       strs[0] = reverse(strs[0]);
       strs[1] = reverse(strs[1]);
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append(strs[0]).append(strs[1]);
       return reverse(stringBuilder.toString());
    }
}
