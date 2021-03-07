package 剑指offer;

public class Singleton {
    /**
     * 题1：写单例
     * 关键 静态
     */

    /*
    饿汉式：线程安全、类加载时就实力化对象，如果始终未使用则造成内存浪费。
    但是该对象只有一个，浪费空间也不是很大，可以使用，编写的时候非常简单。
     */
    static class HugerSingleton {
        private static HugerSingleton hugerSingleton = new HugerSingleton();

        private HugerSingleton() {}

        public static HugerSingleton getInstance() {
            return hugerSingleton;
        }
    }

    //懒汉式v1--------------------------------------------------------------------
    /*
    懒汉式1，非线程安全
     */
    static class LazySingleton1 {
        private static LazySingleton1 instance;

        private LazySingleton1() {}

        private static LazySingleton1 getInstance() {
            if (instance == null) {
                instance = new LazySingleton1();
            }
            return instance;
        }
    }

    /*
    懒汉式2，给方法加锁，线程安全,但性能降低（synchrized会造成线程阻塞）
     */
    static class LazySingleton2 {
        private static LazySingleton2 instance;

        private LazySingleton2() {}

        public static synchronized LazySingleton2 getInstance() {
            if (instance == null) {
                instance = new LazySingleton2();
            }
            return instance;
        }
    }

    /*
    懒汉式3，双重校验锁（同步代码块），既保证了线程安全，又提高了性能
    仍然用了synchrozied，所以还是影响效率
     */
    //为什么要加volatile：
    /*
    对象的创建实际包含一下几步：
    1. 类是否已经加载，没加载就加载类 ； 2. 申请内存； 3 初始化内存（置0，null等等）；4. 执行构造方法，初始化对象；
    5. 将生成的对象赋给引用
    问题就在于这几步指令是可能重排的，比如1 2 3 4 5,变成1 2 3 5 4。也就是说还没有执行构造方法将这个对象的属性初始化，
    各个属性都是默认值，就将这个对象赋给了引用instance了。假设有个线程A发生了上面说的情况，生成对象时执行了1 2 3 5步，
    这时候有个线程B执行line2发现instance不为null了，于是直接执行line6将还未执行构造方法的对象返回。
    因此为了万无一失，还是要使用volatile的，防止生成对象时第4步和第5步顺序颠倒。
     */
    static class LazySingleton3 {
        private static volatile LazySingleton3 instance;

        private LazySingleton3() {}

        public static LazySingleton3 getInstance() { //1
            if (instance == null) {                  //2
                synchronized (LazySingleton3.class) { //3
                    if (instance == null) {           //4
                        instance = new LazySingleton3();  //5
                    }
                }
            }
            return instance;                              //6
        }
    }
    //懒汉式v2--------------------------------------------------------------------
    /*
    线程安全的懒汉式：静态内部类（推荐），其实是线程安全饿汉式改良
    (因为在方法中创建对象，才存在并发问题，静态内部类随着方法调用而被加载，只加载一次，不存在并发问题）
    1。加载一个类时，其内部类不会同时被加载。
    2。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。
     */
    public static class LazySingleton4 {
        private LazySingleton4() {}

        static class SingleHodler {
            private static final LazySingleton4 instance = new LazySingleton4();
        }

        public static LazySingleton4 getInstance() {
            return SingleHodler.instance;
        }
    }

    /*
    线程安全的懒汉式：枚举
     */
    enum Singleton5 {
        INSTANCE;
        public void WhateverMethod() {

        }
    }
}
