package 剑指offer;

public class ReplaceBlank3 {
    /*
    题3：将一个字符串中的空格替换成"%20"
     */
    /**
     * 涉及 string  stringbuffer stringbuilder之间的不同
     * string是字符串常量，修改后都是新生成一个string对象，java字符串没有结束符
     * stringbuffer和stringbuilder是字符串变量，在原对象上修改
     * stringbuffer是线性安全，stringbuilder是非安全，效率高
     * 要问清楚面试官的要求，是否在原来字符串上修改，传入的是string还是stringbuffer或stringbuilder
     */

    /*
    String-----StringBuffer
    通过构造方法：StringBuffer sb = new StringBuffer("abc");
    通过append方法：StringBuffer sb = new StringBuffer();sb.append("abc");
    StringBuffer------String
    通过构造方法：StringBuffer sb = new StringBuffer("abc");String s = new String(sb);
    通过toString方法：StringBuffer sb = new StringBuffer("abc");String s = sb.toString();
    通过subString方法：StringBuffer sb = new StringBuffer("abc");String s = sb.substring(0, sb.length());
    String转StringBuilder、StringBuilder转String同理
     */

    /**
     * 解法1：使用stringbuffer
     */
    public static String replaceBlank1(String input) {
        if (input == null) {
            return null;
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') { //''是字符，""是字符串（机器可能无法识别，编码格式），应该先转为字符
                stringBuffer.append("%20");//append,追加子串到末尾
            } else {
                stringBuffer.append(String.valueOf(input.charAt(i)));
            }//将input逐一复制到stringbuffer
        }
        return new String(stringBuffer);
    }

    /**
     * 解法2：使用stringbuilder
     */
    public static String replaceBlank2(String input) {
        if (input == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(input.charAt(i));
            }
        }
        return String.valueOf(stringBuilder);
    }

    /**
     * 解法3：从后往前复制（从前往后一样），时间复杂度0(n)
     */
    public static String replaceBlank3(String input) {
        if (input == null) {
            return null;
        }
        int blankNum = 0;
        int length = input.length();
        int newLenght = 0;
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == ' ') {
                blankNum++;
            }
        }
        //替换后字符串长度
        newLenght = length + 2 * blankNum;
        char[] newChars = new char[newLenght];
        int index = newLenght - 1;
        for (int i = length - 1; i >= 0; i++) {
            if (input.charAt(i) == ' ') {
                newChars[index--] = '%';
                newChars[index--] = '2';
                newChars[index--] = '0';
            } else {
                newChars[index--] = input.charAt(i);//i--,先用i，后i-1
            }
        }
        return new String(newChars);
    }
}
