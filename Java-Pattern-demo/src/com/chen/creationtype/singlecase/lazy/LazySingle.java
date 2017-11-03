package com.chen.creationtype.singlecase.lazy;

/**
 * 懒汉模式
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class LazySingle {
    private LazySingle(){}
    private static LazySingle lazySingle =null;

    /**
     * 线程不安全
     * @return
     */
    public static LazySingle getInstance(){
        if (lazySingle == null) {
            lazySingle = new LazySingle();
        }
        return lazySingle;
    }

    /**
     * 线程安全-方法级别
     * @return
     */
    public static synchronized LazySingle getInstanceSynchronized(){
        if (lazySingle == null) {
            lazySingle = new LazySingle();
        }
        return lazySingle;
    }

    /**
     * 线程安全-块级别
     * @return
     */
    public static LazySingle getInstanceSynchronizedBlock(){
        if (lazySingle == null) {
            synchronized(LazySingle.class){
                if (lazySingle == null) {
                    lazySingle = new LazySingle();
                }
            }
        }
        return lazySingle;
    }

    //静态内部类
    private static class LazyHoulder{
        /** static final ——确保只有一个*/
        private static final LazySingle LAZYSINGLE = new LazySingle();
    }

    /**
     * 线程安全
     * @return
     */
    public static final LazySingle getInstanceStaticInside(){
        return LazyHoulder.LAZYSINGLE;
    }

}
