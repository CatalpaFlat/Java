package future;

import java.util.Arrays;

/**
 * 不变模式
 * @author 陈梓平
 * @date 2017/10/20.
 */
public class Unchanged {
    /**
     * 不变模式
     * 如果读者熟悉多线程程序设计，那么一定对不变模式有所有了解。
     * 所谓不变，是指对象在创建后，就不再发生变化。
     * 比如，java.lang.String就是不变模式的典型。
     * 如果你在Java中创建了一个String实例，无论如何，你都不可能改变整个String的值。
     * 比如，当你使用String.replace()函数试图进行字符串替换时，
     * 实际上，原有的字符串对象并不会发生变化，函数本身会返回一个新的String对象，
     * 作为给定字符替换后的返回值。不变的对象在函数式编程中被大量使用。
     * @param args
     */
    public static void main(String[] args) {
         int[] arr={1,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).map((x)->x=x+1).forEach(System.out::println);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::println);
       /*
        * 代码第2行看似对每一个数组成员执行了加1的操作。
        * 但是在操作完成后，在最后一行，打印arr数组所有的成员值时，
        * 你还是会发现，数组成员并没有变化！在使用函数式编程时，
        * 这种状态是一种常态，几乎所有的对象都拒绝被修改。
        */
    }
}
