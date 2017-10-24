package future;

import java.util.Arrays;

/**
 * 函数式编程是申明式的编程方式。
 * @author 陈梓平
 * @date 2017/10/20.
 */
public class Declarative {
    /**
     * 相对于命令式（imperative）而言，命令式的程序设计喜欢大量使用可变对象和指令。
     * 我们总是习惯于创建对象或者变量，并且修改它们的状态或者值，或者喜欢提供一系列指令，
     * 要求程序执行。这种编程习惯在申明式的函数式编程中有所变化。对于申明式的编程范式，
     * 你不在需要提供明确的指令操作，所有的细节指令将会更好的被程序库所封装，
     * 你要做的只是提出你要的要求，申明你的用意即可
     * @param args
     */
    public static void main(String[] args) {
        //旧版 循环 命令式
        int[]iArr={1,3,4,5,6,9,8,7,4,2};
//        for(int i=0;i<iArr.length;i++){
//            System.out.println(iArr[i]);
//        }
        //新版 循环 申明式
        Arrays.stream(iArr).forEach(System.out::println);
       /*
        * 可以看到，变量数组的循环体居然消失了！
        * println()函数似乎在这里也没有指定任何参数，
        * 在此，我们只是简单的申明了我们的用意。
        * 有关循环以及判断循环是否结束等操作都被简单地封装在程序库中
        */
    }
}
