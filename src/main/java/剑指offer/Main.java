//package 剑指offer;
//
//import Mysort.sort;
//
//import java.util.*;
//
//public class Main {
//    //计算字符串最后一个单词的长度，单词以空格隔开。
//    public static void main(String[] arg) {
//        Scanner scanner = new Scanner(System.in);
//        if (scanner.hasNext()) {
//            String str = scanner.nextLine();
//            str = str.substring(str.lastIndexOf(" ") + 1, str.length());
//            System.out.println(str.length());
//        }
//    }
//
//    //写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
//    public static void main(String[] arg) {
//        Scanner scanner = new Scanner(System.in);
//        int count = 0;
//        if (scanner.hasNext()) {
//            String str = scanner.nextLine();
//            String target = scanner.nextLine();
//            for (int i = 0; i < str.length(); i++) {
//                if (String.valueOf(str.charAt(i)).equalsIgnoreCase(target)) {
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//
//    //明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
//    // 他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，
//    // 只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
//    // 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
//    // 请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
//    public static void main(String[] args) {
//
//
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//
//            int num = sc.nextInt();
//            TreeSet<Integer> set = new TreeSet<Integer>();
//            for(int i = 0 ; i < num ;i++){
//                int curr = sc.nextInt();
//                set.add(curr);
//            }
//            for(Integer i : set){
//                System.out.println(i);
//            }
//        }
//    }
//
//    //•连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
//    //•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
//    public static void main(String[] arg) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String str = scanner.nextLine();
//            int count = str.length() / 8;
//            int index = str.length() - 8 * count;
//            if (index != 0) {
//                for (int i = 0; i < count; i++) {
//                    System.out.println(Arrays.copyOfRange(str.toCharArray(), (8 * i), (8 * (i + 1))));
//                }
//                char[] remainStr = {'0','0','0','0','0','0','0','0'};
//
//                for (int j = 0; j < index; j++) {
//                    remainStr[j] = str.charAt(8 * count + j);
//                }
//                System.out.println(remainStr);
//            } else {
//                for (int i = 0; i < count; i++) {
//                    System.out.println(Arrays.copyOfRange(str.toCharArray(), (8 * i), (8 * (i + 1))));
//                }
//            }
//        }
//    }
//
//    //接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        double d=scanner.nextDouble();
//        System.out.println(getReturn(d));
//    }
//
//    public static int getReturn(double d) {
//        int i=(int)d;
//        return  (d-i)>=0.5?i+1:i;
//    }
//
//    //数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
//    public static void main(String[] arg) {
//        Scanner scanner = new Scanner(System.in);
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        while (scanner.hasNextLine()){
//            int count = Integer.parseInt(scanner.nextLine());
//            for (int i = 0; i < count; i++) {
//                String string = scanner.nextLine();
//                String[] strs = string.split(" ");
//                Integer key = Integer.valueOf(strs[0]);
//                Integer value = Integer.valueOf(strs[1]);
//                if (treeMap.containsKey(key)) {
//                    treeMap.put(key, treeMap.get(key) + value);
//                } else {
//                    treeMap.put(key, value);
//                }
//            }
//            Iterator iterator = treeMap.entrySet().iterator();
//            while (iterator.hasNext()) {
//                Map.Entry entry = (Map.Entry)iterator.next();
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//        }
//    }
//
//    //功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
//    //
//    //最后一个数后面也要有空格
//    public static void main(String[] arg) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLong()) {
//            long num = scanner.nextLong();
//            String result = getResult(num);
//            System.out.println(result);
//        }
//    }
//
//    public static String getResult(long num) {
//        int index = 2;
//        String result = "";
//        while (num != 1) {
//            while (num % index == 0) {
//                num = num / index;
//                result += index + " ";
//            }
//            index++;
//        }
//        return result;
//    }
//
//    //编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
//    //contains去重
//    public static void main(String[] args) {
//        String s = new Scanner(System.in).nextLine();
//        System.out.println(getDiffNum(s));
//
//    }
//
//    private static int getDiffNum(String s){
//        ArrayList<Character> list = new ArrayList<Character>();
//        for(char ch : s.toCharArray()){
//            if(list.contains(ch)){
//
//            }else{
//                list.add(ch);
//            }
//        }
//        return list.size();
//    }
//
//    //按照指定规则对输入的字符串进行处理。
//    //
//    //详细描述：
//    //
//    //将输入的两个字符串合并。
//    //
//    //对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
//    //
//    //对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
//    //
//    //
//    //举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
//    //
//    //接口设计及说明：
//    //
//    ///*
//    //
//    //功能:字符串处理
//    //
//    //输入:两个字符串,需要异常处理
//    //
//    //输出:合并处理后的字符串，具体要求参考文档
//    //
//    //返回:无
//    import java.util.Arrays;
//import java.util.Scanner;
//    /**
//     * Created by Administrator on 2015/12/22.
//     */
//    public class Main {
//        public static void main(String[] args) {
//            Scanner sc=new Scanner(System.in);
//            while (sc.hasNext()){
//                StringBuffer rs=new StringBuffer();
//                char[] strmx=(sc.next()+sc.next()).toCharArray();
//                String string1="";
//                String string2="";
//                for(int i=0;i<strmx.length;i++){
//                    if(i%2==0){
//                        string1+=strmx[i];
//                    }else {
//                        string2+=strmx[i];
//                    }
//                }
//                char[] str1=string1.toCharArray();
//                char[] str2=string2.toCharArray();
//                Arrays.sort(str1);
//                Arrays.sort(str2);
//                String strx="";
//                int k=0;
//                for(int i=0;i<Math.min(str1.length,str2.length);i++){
//                    strx+=str1[i];
//                    strx+=str2[i];
//                    if(i==Math.min(str1.length,str2.length)-1){
//                        k=i;
//                    }
//                }
//                if(str1.length>str2.length){
//                    strx+=str1[k+1];
//                }else if(str1.length<str2.length) {
//                    strx+=str2[k+1];
//                }
//                char[] str=strx.toCharArray();
//                for (int i=0;i<str.length;i++){
//                    if(String.valueOf(str[i]).matches("[A-Fa-f]")){
//                        String res=revser(Integer.toBinaryString(Integer.valueOf(Character.toLowerCase(str[i])) - 87));
//                        int x=Integer.parseInt(res,2);
//                        rs.append(Nx(x));
//                    }else if(String.valueOf(str[i]).matches("[0-9]")){
//                        String res="";
//                        String hex=Integer.toBinaryString(Integer.parseInt(String.valueOf(str[i])));
//                        if(hex.length()<4){
//                            for(int j=0;j<4-hex.length();j++){
//                                res+="0";
//                            }
//                        }
//                        String resx=revser(res+hex);
//                        int x=Integer.parseInt(resx, 2);
//                        rs.append(Nx(x));
//                    }else {
//                        rs.append(str[i]);
//                    }
//                }
//                System.out.println(rs);
//
//            }
//
//        }
//        public  static String revser(String srx){
//            StringBuffer sb=new StringBuffer();
//            return sb.append(srx).reverse().toString();
//        }
//        public static String Nx(int x){
//            if(x==10){
//                return "A";
//            }else if(x==11){
//                return "B";
//            }else if(x==12){
//                return "C";
//            }else if(x==13){
//                return "D";
//            }else if(x==14){
//                return "E";
//            }else if(x==15){
//                return "F";
//            }
//            return String.valueOf(x);
//        }
//    }
//
//    //这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
//    // 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
//    // 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，
//    // 喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
//
//    //有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
//    // 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
//    // 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
//    import java.util.*;
//
//    public class Main {
//        public static void main(String[] arg) {
//            Scanner scanner = new Scanner(System.in);
//            while (scanner.hasNextLine()) {
//                ArrayList<Integer> arrayList = new ArrayList<>();
//                int m = 3;
//                int index = 2;
//                int n = Integer.parseInt(scanner.nextLine());
//                for (int i = 0; i < n && i < 1000; i++) {
//                    arrayList.add(i);
//                }
//                int length = arrayList.size();
//                int num = 0;
//                while (arrayList.size() > 1) {
//                    arrayList.remove(((index % length) - num));
//                    index = index + m;
//                    num++;
//                    if (index >= length) {
//                        index = index % length;
//                        length = arrayList.size();
//                        num = 0;
//                    }
//                }
//                System.out.println(arrayList.get(0));
//            }
//        }
//    }
//
//    //输入一个字符串，求出该字符串包含的字符集合
//    import java.util.*;
//
//    public class Main {
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            while (in.hasNext()) {
//                String strs = in.nextLine();
//                char[] c = strs.toCharArray();
//                LinkedHashSet<Character> set = new LinkedHashSet<>();
//                for (int i = 0; i < c.length; i++) {
//                    set.add(c[i]);
//                }
//                StringBuilder sb = new StringBuilder();
//                for (char c1 : set) {
//                    sb.append(c1);
//                }
//                System.out.println(sb.toString());
//            }
//        }
//    }
//
//    //数独
//    import java.util.Scanner;
//import java.util.ArrayList;
//    public class Main{
//        public static void main(String[] args){
//            Scanner in = new Scanner(System.in);
//            while(in.hasNext()){
//                int[][] A = new int[9][9];
//
//                for(int i =0;i<9;i++){
//                    for(int j =0;j<9;j++){
//                        A[i][j] = in.nextInt();
//                    }
//
//                }
//                solvesudoku(A,0);
//                for(int i =0;i<9;i++){
//                    for(int j =0;j<9;j++){
//                        if(j != 8)
//                            System.out.print(A[i][j] + " ");
//                        else
//                            System.out.print(A[i][j]);
//                    }
//                    if(i != 8)
//                        System.out.println();
//                }
//            }
//        }
//        static boolean solvesudoku(int[][] sd,int index){
//            if(index == 81)
//                return true;
//            int x = index/9;
//            int y = index%9;
//            if(sd[x][y]==0){
//                for(int n=1;n<=9;n++){
//                    sd[x][y] = n;
//                    if(CheckrowAndcol(sd,x,y,n) && CheckGrid(sd,x,y,n))
//                        if(solvesudoku(sd,index+1))
//                            return true;
//                    sd[x][y] = 0;
//                }
//            }else
//                return solvesudoku(sd,index+1);
//            return false;
//
//        }
//        // 判断 n 所在的行列是否包含 n
//        static boolean CheckrowAndcol(int[][] sd,int x ,int y,int n){
//            // x 行
//            for(int j=0;j<9;j++){
//                if(j!=y && sd[x][j] ==n  )
//                    return false;
//            }
//            // y列
//            for(int i=0;i<9;i++){
//                if(i!=x && sd[i][y]==n )
//                    return false;
//            }
//            return true;
//        }
//        // 判断所在的方格是否包含 n
//        static boolean CheckGrid(int[][] sd,int x,int y,int n){
//            // 根据x y的坐标求其所在方格的左上坐标和右下坐标表示不好想。
//            for(int i = (x/3)*3;i<(x/3+1)*3;i++){
//                for(int j=(y/3)*3;j<(y/3+1)*3;j++){
//                    if(i!=x && j!=y && sd[i][j]==n)
//                        return false;
//                }
//            }
//            return true;
//        }
//    }
//
//
////明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
//// 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
//// 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
//import java.util.Scanner;
//import java.util.TreeSet;
//
//    public class Main
//    {
//        public static void main(String[] args) {
//            Scanner sc=new Scanner(System.in);
//            while(sc.hasNext()){
//
//                TreeSet<Integer> set=new TreeSet<Integer>();
//                int n=sc.nextInt();
//                if(n>0){
//                    for(int i=0;i<n;i++){
//                        set.add(sc.nextInt());
//                    }
//                }
//                for(Integer i:set){
//                    System.out.println(i);
//                }
//            }
//        }
//    }
//
//    //输入包括多组测试数据。
//    //每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
//    //学生ID编号从1编到N。
//    //第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
//    //接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
//    //当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()) {
//            String str = in.nextLine();
//            String[] strs = new String[2];
//            strs = str.split(" ");
//            int sNum = Integer.parseInt(strs[0]);
//            int count = Integer.parseInt(strs[1]);
//            String sResult = in.nextLine();
//            String[] sResults = new String[sNum];
//            sResults = sResult.split(" ");
//            int[] sAll = new int[sNum];
//            for (int i = 0; i < sNum; i++) {
//                sAll[i] = Integer.parseInt(sResults[i]);
//            }
//            for (int j = 0; j < count; j++) {
//                String string = in.nextLine();
//                String[] strings = string.split(" ");
//                if (strings[0].equals("Q")) {
//                    int A = Math.max(Integer.parseInt(strings[1]) , Integer.parseInt(strings[2]));
//                    int B = Math.min(Integer.parseInt(strings[1]) , Integer.parseInt(strings[2]));
//                    int result = 0;
//                    for (int i = B - 1; i < A; i++) {
//                        if (sAll[i] > result) {
//                            result = sAll[i];
//                        }
//                    }
//                    System.out.println(result);
//                } else if (strings[0].equals("U")) {
//                    sAll[Integer.parseInt(strings[1]) - 1] = Integer.parseInt(strings[2]);
//                }
//            }
//        }
//    }
//    //开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
//    //处理:
//    //1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
//    //2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
//    //3.输入的文件可能带路径，记录文件名称不能带路径
//
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Scanner;
//
//
//    public class HuaWeiErrorRecords {
//
//
//
//        public static void main(String[] args) {
//
//            Scanner in = new Scanner(System.in);
//
//            Map<String, Integer> map = new LinkedHashMap<String, Integer>();//LinkedHashMap而不是hashmap！！！！！
//            String key;
//            String filename;
//            String path;
//            while(in.hasNext()){
//                path = in.next();
//                //将路径转换为文件名
//                int id = path.lastIndexOf('\\');
//                //如果找不到说明只有文件名没有路径
//                filename = id<0  ? path : path.substring(id+1);
//                int linenum = in.nextInt();
//                //统计频率
//                key = filename+" "+linenum;
//                if(map.containsKey(key)){
//                    map.put(key, map.get(key)+1);
//                }else{
//                    map.put(key, 1);
//                }
//            }
//
//            in.close();
//
//            //对记录进行排序
//            List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
//            Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
//                //降序
//                @Override
//                public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
//                    return(arg1.getValue()-arg0.getValue()) == 0? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
//                }
//            });
//            //只输出前8条
//            int m=0;
//            for(Map.Entry<String, Integer> mapping : list){
//                m++;
//                if(m<=8){
//                    String[] str = mapping.getKey().split(" ");
//                    String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
//                    String n = str[1];
//                    System.out.println(k+" "+n+" "+mapping.getValue());
//                }else{
//                    break;
//                }
//
//            }
//
//        }
//
//    }
//
//    //扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A，2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）:)
//    //3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
//    //输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如：4 4 4 4-joker JOKER
//    //请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR
//    //
//    //基本规则：
//    //（1）输入每手牌可能是个子，对子，顺子（连续5张），三个，炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
//    //（2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）
//    //（3）大小规则跟大家平时了解的常见规则相同，个子，对子，三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
//    //（4）输入的两手牌不会出现相等的情况。
//    //
//    //答案提示：
//    //（1）除了炸弹和对王之外，其他必须同类型比较。
//    //（2）输入已经保证合法性，不用检查输入是否是合法的牌。
//    //（3）输入的顺子已经经过从小到大排序，因此不用再排序了.
//    import java.util.ArrayList;
//import java.util.Scanner;
//
//    public class Main {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            String[] left, right;
//            String[] line;
//            String nextLine, outString;
//            while (sc.hasNext()) {
//                nextLine = sc.nextLine();
//                //有王炸就王炸最大
//                if (nextLine.contains("joker JOKER")) {
//                    outString = "joker JOKER";
//                } else {
//                    //拆分 先拆成左右 再拆成单排
//                    line = nextLine.split("-");
//                    left = line[0].split(" ");
//                    right = line[1].split(" ");
//
//                    //炸弹最大
//                    if (left.length == 4 && right.length != 4) {
//                        outString = line[0];
//                    } else if (right.length == 4 && left.length != 4) {
//                        outString = line[1];
//                    }
//                    // 牌数相同的情况下比较最小的牌的大小，compare方法返回牌所对应的值
//                    else if (right.length == left.length) {
//                        if (count(left[0]) > count(right[0])) {
//                            outString = line[0];
//                        } else {
//                            outString = line[1];
//                        }
//                    } else {
//                        outString = "ERROR";
//                    }
//                }
//
//                System.out.println(outString);
//
//            }
//        }
//
//        //2-JOKER 按大小返回2-16
//        private static int count(String str) {
//            return "345678910JQKA2jokerJOKER".indexOf(str);
//        }
//    }
//
//    .sort
//    //升序
//    public static void main(String[] args) {
//
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.sort(new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                if(o1>o2)
//                    return 1;//第二个元素（o1）比第一个元素（o2）大，返回1
//                if(o1==o2)
//                    return 0;
//                return -1;
//            }//1,0,-1三者同时出现时，1表示不交换位置，0表示相等时不交换，-1表示交换
//        });
//
//        System.out.println(list.toString());
//    }
//
//    //降序
//    public static void main(String[] args) {
//
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.sort(new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                if (o1 > o2)
//                    return -1;//第二个元素（o1）比第一个元素（o2）大，返回-1
//                if (o1 == o2)
//                    return 0;
//                return 1;
//            }//1,0,-1三者同时出现时，1表示不交换位置，0表示相等时不交换，-1表示交换
//        });
//
//        System.out.println(list.toString());
//    }
//
//
//}
